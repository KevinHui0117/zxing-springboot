package com.zgh.xxg.xxg.app.utils;

import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.*;

/**
 * app考勤模块Map工具类
 * @author huikai
 * @since 2020-04-07 10:36:36
 */
public class AppMapUtils extends MapUtils {
    private AppMapUtils() {
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static <K, V> HashMap<K, V> newHashMap(K k, V v) {
        HashMap<K, V> map = new HashMap<K, V>();
        map.put(k, v);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static <K, V> HashMap<K, V> newHashMap(K k, V v, Object... extraKeyValues) {
        if (extraKeyValues.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        HashMap<K, V> map = new HashMap<K, V>();
        map.put(k, v);
        for (int i = 0; i < extraKeyValues.length; i += 2) {
            k = (K) extraKeyValues[i];
            v = (V) extraKeyValues[i + 1];
            map.put(k, v);
        }
        return map;
    }

    public static String getClobValue(final Map map, final Object key) {
        String value = "";
        try {
            Object object = getObject(map, key);
            if (object != null && object instanceof Clob) {
                Clob clob = (Clob)object;
                int size = (int) clob.length();
                value = clob.getSubString(1, size);
            }
        } catch (SQLException e) {
            logInfo(e);
        }
        return value;
    }

    public static List getList(final Map map, final Object key) {
        Object object = getObject(map, key);
        return object instanceof Collection ? new ArrayList((Collection)object) : new ArrayList();
    }

    public static <T> boolean equalValue(final Map map, final Object key, T value) {
        return value.equals(getObject(map, key));
    }

    public static <T> boolean containsValue(final Map map, final Object key, T value) {
        Collection collection = (Collection) getObject(map, key);
        return collection.contains(value);
    }

    public static Map<String,Object> fromBean2Map(final Object dto){
        Field[] fields = dto.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<>();
        for(Field field : fields){
            String name = field.getName();
            String fieldName = name.substring(0, 1).toUpperCase() + name.substring(1);//把得到属性名称的第一个字母大写
            Object object= null;
            Method m;
            try {
                m = dto.getClass().getMethod("get" + fieldName);
                object =  m.invoke(dto); //得到属性值
                map.put(name,object);
                return map;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return map;
    }



}
