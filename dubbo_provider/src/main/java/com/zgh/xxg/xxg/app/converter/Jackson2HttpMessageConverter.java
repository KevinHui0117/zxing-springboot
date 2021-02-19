//package com.zgh.xxg.xxg.app.converter;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
//import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//
//import java.io.IOException;
//import java.util.Collection;
//import java.util.List;
//import java.util.Map;
//
//
///**
// * @author caiyz
// * @since 2020-08-27 13:48
// */
//public class Jackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
//
//    /**
//     * 处理数组类型的null值
//     */
//    public class NullArrayJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
//            if (value == null) {
//                jsonGenerator.writeStartArray();
//                jsonGenerator.writeEndArray();
//            }
//        }
//    }
//
//    /**
//     * 处理Map类型的null值
//     */
//    public class NullMapJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
//            if (value == null) {
//                jsonGenerator.writeStartObject();
//                jsonGenerator.writeEndObject();
//            }
//        }
//    }
//
//    /**
//     * 处理字符串等类型的null值
//     */
//    public class NullStringJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeString(StringUtils.EMPTY);
//        }
//    }
//
//    /**
//     * 处理字符串等类型的null值
//     */
//    public class NullNumberJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeNumber(0);
//        }
//    }
//
//    /**
//     * 处理字符串等类型的null值
//     */
//    public class NullBooleanJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeBoolean(false);
//        }
//    }
//
//    /**
//     * 默认JavaBean值类型
//     */
//    public class NullJavaBeanJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeStartObject();
//            jsonGenerator.writeEndObject();
//        }
//    }
//
//    /**
//     * 默认NULL值类型
//     */
//    public class NullJsonSerializer extends JsonSerializer<Object> {
//        @Override
//        public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeString("");
//        }
//    }
//
//    public class  DefaultValueBeanSerializerModifier extends BeanSerializerModifier {
//        @Override
//        public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
//            //循环所有的beanPropertyWriter
//            for (Object beanProperty : beanProperties) {
//                BeanPropertyWriter writer = (BeanPropertyWriter) beanProperty;
//                //判断字段的类型，如果是array，list，set则注册nullSerializer
//                if (isArrayType(writer)) {
//                    writer.assignNullSerializer(new NullArrayJsonSerializer());
//                } else if (isMapType(writer)) {
//                    writer.assignNullSerializer(new NullMapJsonSerializer());
//                } else if (isNumberType(writer)) {
//                    writer.assignNullSerializer(new NullNumberJsonSerializer());
//                } else if (isBooleanType(writer)) {
//                    writer.assignNullSerializer(new NullBooleanJsonSerializer());
//                } else if (isStringType(writer)) {
//                    writer.assignNullSerializer(new NullStringJsonSerializer());
//                } else if (isEnumType(writer)) {
//                    writer.assignNullSerializer(new NullJsonSerializer());
//                } else if (isJavaBeanType(writer)) {
//                    writer.assignNullSerializer(new NullJavaBeanJsonSerializer());
//                } else {
//                    writer.assignNullSerializer(new NullJsonSerializer());
//                }
//            }
//            return beanProperties;
//        }
//
//        /**
//         * 是否是数组
//         */
//        private boolean isArrayType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return clazz.isArray() || Collection.class.isAssignableFrom(clazz);
//        }
//
//        /**
//         * 是否是Map
//         */
//        private boolean isMapType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return Map.class.isAssignableFrom(clazz);
//        }
//
//        /**
//         * 是否是string
//         */
//        private boolean isStringType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return CharSequence.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz);
//        }
//
//        /**
//         * 是否是int
//         */
//        private boolean isNumberType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return Number.class.isAssignableFrom(clazz) || int.class == clazz || float.class == clazz || double.class == clazz;
//        }
//
//        /**
//         * 是否是boolean
//         */
//        private boolean isBooleanType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return clazz.equals(Boolean.class);
//        }
//
//        /**
//         * 是否是Enum
//         */
//        private boolean isEnumType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return Enum.class.isAssignableFrom(clazz);
//        }
//
//        /**
//         * 是否是JavaBean
//         */
//        private boolean isJavaBeanType(BeanPropertyWriter writer) {
//            Class<?> clazz = writer.getType().getRawClass();
//            return clazz.getClassLoader() != null;
//        }
//    }
//
//    @Override
//    public void setObjectMapper(ObjectMapper objectMapper) {
//        super.setObjectMapper(objectMapper);
//        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(new DefaultValueBeanSerializerModifier()));
//    }
//
//}