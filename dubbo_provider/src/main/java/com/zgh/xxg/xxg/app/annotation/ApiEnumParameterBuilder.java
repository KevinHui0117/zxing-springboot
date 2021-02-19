package com.zgh.xxg.xxg.app.annotation;

import com.fasterxml.classmate.ResolvedType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResolvedMethodParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static springfox.documentation.schema.Collections.isContainerType;
import static springfox.documentation.schema.Maps.isMapType;
import static springfox.documentation.schema.Types.isBaseType;
import static springfox.documentation.schema.Types.typeNameFor;


/**
 * 入参枚举备注扩展
 * @author caiyz
 * @since 2020-08-25 13:23
 */
@Component
public class ApiEnumParameterBuilder implements ParameterBuilderPlugin, OperationBuilderPlugin {

    @Override
    public void apply(ParameterContext context) {

        Class<?> type = context.resolvedMethodParameter().getParameterType().getErasedType();

        if (Enum.class.isAssignableFrom(type)) {
            ApiEnum annotation = AnnotationUtils.findAnnotation(type, ApiEnum.class);
            if (annotation != null) {
                Object[] enumConstants = type.getEnumConstants();
                List<String> displayValues = Arrays.stream(enumConstants).filter(Objects::nonNull).map(item -> {
                    Class<?> currentClass = item.getClass();

                    Field textField = ReflectionUtils.findField(currentClass, annotation.text());
                    ReflectionUtils.makeAccessible(textField);
                    Object textV = ReflectionUtils.getField(textField, item);

                    Field nameField = ReflectionUtils.findField(currentClass, annotation.name());
                    ReflectionUtils.makeAccessible(nameField);
                    Object nameV = ReflectionUtils.getField(nameField, item);
                    return nameV + ":" + textV;

                }).collect(Collectors.toList());

                ParameterBuilder parameterBuilder = context.parameterBuilder();
                AllowableListValues values = new AllowableListValues(displayValues, "LIST");
                parameterBuilder.allowableValues(values);
            }
        }
    }


    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }


    @Override
    public void apply(OperationContext context) {

        List<ResolvedMethodParameter> parameters = context.getParameters();

        parameters.stream()
                .filter(p -> shouldExpand(p.getParameterType()))
                .forEach(parameter -> {

                    OperationBuilder operationBuilder = context.operationBuilder();
                    Field parametersField = ReflectionUtils.findField(operationBuilder.getClass(), "parameters");
                    ReflectionUtils.makeAccessible(parametersField);
                    List<Parameter> list = (List<Parameter>) ReflectionUtils.getField(parametersField, operationBuilder);

                    list.stream().filter(p -> p.getType().isPresent()).forEach(p -> {

                        Class<?> clazz = p.getType().get().getErasedType();
                        ApiEnum annotation = AnnotationUtils.findAnnotation(clazz, ApiEnum.class);
                        if (annotation != null) {
                            Object[] enumConstants = clazz.getEnumConstants();
                            String displayValues = Arrays.stream(enumConstants).filter(Objects::nonNull).map(item -> {
                                Class<?> currentClass = item.getClass();

                                Field textField = ReflectionUtils.findField(currentClass, annotation.text());
                                ReflectionUtils.makeAccessible(textField);
                                Object textV = ReflectionUtils.getField(textField, item);

                                Field nameField = ReflectionUtils.findField(currentClass, annotation.name());
                                ReflectionUtils.makeAccessible(nameField);
                                Object nameV = ReflectionUtils.getField(nameField, item);
                                return nameV + ":" + textV;

                            }).collect(Collectors.joining(", "));

                            Field description = ReflectionUtils.findField(p.getClass(), "description");
                            ReflectionUtils.makeAccessible(description);
                            Object field = ReflectionUtils.getField(description, p);
                            ReflectionUtils.setField(description, p, field + " (" + displayValues + ")");

                            Field allowableValues = ReflectionUtils.findField(p.getClass(), "allowableValues");
                            ReflectionUtils.makeAccessible(allowableValues);
                            ReflectionUtils.setField(allowableValues, p, null);
                        }
                    });
                });
    }

    private boolean shouldExpand(ResolvedType resolvedParamType) {
        return !isBaseType(typeNameFor(resolvedParamType.getErasedType()))
                && !Enum.class.isAssignableFrom(resolvedParamType.getErasedType())
                && !isContainerType(resolvedParamType)
                && !isMapType(resolvedParamType);


    }
}