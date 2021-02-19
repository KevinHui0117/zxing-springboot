package com.zgh.xxg.xxg.app.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Json返回数据信息处理类
 * @author huikai
 * @since 2020-04-01 17:23:47
 */
public class MessageSourceUtil {
    private static final AtomicBoolean once = new AtomicBoolean(false);

    private static MessageSource messageSource;

    public static void setMessageSource(MessageSource messageSource) {
        if (once.compareAndSet(false, true)) {
            MessageSourceUtil.messageSource = messageSource;
        }
    }

    public static String getMessage(String code,String locale) {
        Locale localeTmp = new Locale("zh");
        if (StringUtils.isNotEmpty(locale)){
            LocaleType localeType = LocaleType.valueOf(locale);
            localeTmp = new Locale(localeType.getName(),localeType.getCountry());
        }

        if (localeTmp == null) {
            localeTmp = new Locale(LocaleType.zh.getName(),LocaleType.zh.getCountry());
        }
        return messageSource.getMessage(code, null, localeTmp);
    }
}
