//package com.zgh.xxg.xxg.app.config;
//
//import com.fasterxml.jackson.databind.AnnotationIntrospector;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
//import com.zgh.xxg.xxg.app.converter.Jackson2HttpMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.ByteArrayHttpMessageConverter;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
//import org.springframework.validation.Validator;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.charset.StandardCharsets;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.TimeZone;
//
///**
// * @author caiyz
// * @since 2020-04-07 09:45:48
// */
//@EnableWebMvc
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public Validator addValidator() {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        return bean;
//    }
//
//    @Bean
//    public List<HttpMessageConverter<?>> messageConverters() {
//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        converters.add(new ByteArrayHttpMessageConverter());
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
//        stringConverter.setWriteAcceptCharset(false);
//        stringConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED));
//        converters.add(stringConverter);
//        Jackson2HttpMessageConverter jsonConverter = new Jackson2HttpMessageConverter();
//        jsonConverter.setObjectMapper(createMapper());
//        converters.add(jsonConverter);
//        converters.add(new Jaxb2RootElementHttpMessageConverter());
//        return converters;
//    }
//
//    @Bean
//    public ObjectMapper createMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
//        mapper.setAnnotationIntrospector(secondary);
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        mapper.setTimeZone(TimeZone.getDefault());
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        return mapper;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.addAll(messageConverters());
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/app/signature/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST")
//                .allowedHeaders("*")
//                .maxAge(3600 * 24);
//    }
//}