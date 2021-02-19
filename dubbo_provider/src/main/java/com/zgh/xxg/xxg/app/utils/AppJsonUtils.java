package com.zgh.xxg.xxg.app.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * @author huikai
 * @date 2020-05-18
 */
public class AppJsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
        mapper.setAnnotationIntrospector(secondary);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * 将对象转成字符串
     */
    public static String objectToString(Object obj) throws Exception {
        return mapper.writeValueAsString(obj);
    }

    /**
     * 将Map转成指定的Bean
     */
    public static Object mapToBean(Map map, Class clazz) throws Exception {
        return mapper.readValue(objectToString(map), clazz);
    }

    /**
     * 将Bean转成Map
     */
    public static Map beanToMap(Object obj) throws Exception {
        return mapper.readValue(objectToString(obj), Map.class);
    }

    /**
     * 将String转成T
     */
    public static <T> T stringToBean(String obj) throws Exception {
        return mapper.readValue(obj, new TypeReference<T>(){});
    }

}
