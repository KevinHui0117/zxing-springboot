package com.zgh.xxg.xxg.app.annotation;

import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.google.common.base.Optional;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import springfox.documentation.builders.ModelPropertyBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * 出参 model枚举备注扩展
 * @author caiyz
 * @since 2020-08-25 13:23
 */
public class ApiEnumModelBuilder implements ModelPropertyBuilderPlugin {

    @Override
    public void apply(ModelPropertyContext context) {

        Optional<BeanPropertyDefinition> optional = context.getBeanPropertyDefinition();

        if (optional.isPresent()) {
            final Class<?> fieldType = optional.get().getField().getRawType();
            addDescForEnum(context, fieldType);
        }
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    private void addDescForEnum(ModelPropertyContext context, Class<?> fieldType) {

        if (Enum.class.isAssignableFrom(fieldType)) {
            ApiEnum annotation = AnnotationUtils.findAnnotation(fieldType, ApiEnum.class);
            if (annotation != null) {
                Object[] enumConstants = fieldType.getEnumConstants();
                String displayValues = Arrays.stream(enumConstants)
                        .filter(Objects::nonNull)
                        .map(item -> {
                            Class<?> currentClass = item.getClass();

                            Field textField = ReflectionUtils.findField(currentClass, annotation.text());
                            ReflectionUtils.makeAccessible(textField);
                            Object textV = ReflectionUtils.getField(textField, item);

                            Field nameField = ReflectionUtils.findField(currentClass, annotation.name());
                            ReflectionUtils.makeAccessible(nameField);
                            Object nameV = ReflectionUtils.getField(nameField, item);
                            return nameV + ":" + textV;

                        }).collect(Collectors.joining(", "));

                ModelPropertyBuilder builder = context.getBuilder();
                Field descField = ReflectionUtils.findField(builder.getClass(), "description");
                ReflectionUtils.makeAccessible(descField);
                String joinText = ReflectionUtils.getField(descField, builder) + " (" + displayValues + ")";

                builder.description(joinText).type(context.getResolver().resolve(Integer.class));
            }
        }

    }
}