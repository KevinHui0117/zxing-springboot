package com.zgh.xxg.xxg.app.annotation;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DateSerializeFactory implements AnnotationFormatterFactory<DateSerialize> {

    @Resource
    private DateSerializeFormatter dateFormatter;

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> fieldTypes = new HashSet<Class<?>>();
        fieldTypes.add(Date.class);
        fieldTypes.add(String.class);
        return fieldTypes;
    }

    @Override
    public Printer<?> getPrinter(DateSerialize annotation, Class<?> fieldType) {
        return dateFormatter;
    }

    @Override
    public Parser<?> getParser(DateSerialize annotation, Class<?> fieldType) {
        DateSerializeFormatter formatter = new DateSerializeFormatter();
        formatter.setIso(annotation.iso());
        formatter.setType(annotation.type());
        formatter.setPattern(annotation.pattern());
        return formatter;
    }
 
}