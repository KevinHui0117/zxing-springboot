package com.zgh.xxg.xxg.app.annotation;


import com.zgh.xxg.xxg.app.constants.AppConstants;
import com.zgh.xxg.xxg.app.utils.AppDateUtils;
import lombok.Data;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Locale;

@Data
@Component
public class DateSerializeFormatter implements Formatter<Object> {

    private DateSerialize.ISO iso;
    private DateSerialize.TYPE type;
    private String pattern = "yyyy-MM-dd";

    @Override
    public String print(Object object, Locale locale) {
        return null;
    }

    @Override
    public Object parse(String text, Locale locale) {

        if (DateSerialize.ISO.TIME_STR.equals(this.iso)) {
            return convertTimeStr(text, locale);
        } else {
            return convertDate(text, locale);
        }
    }

    private String convertTimeStr(String text, Locale locale) {
        if (DateSerialize.TYPE.BEGIN.equals(type)) {
            return text + AppConstants.COLON + "00";
        } else {
            return text + AppConstants.COLON + "59";
        }
    }

    private Date convertDate(String text, Locale locale) {
        Date date = AppDateUtils.parseDate(text, this.pattern);
        if (DateSerialize.TYPE.BEGIN.equals(type)) {
            return AppDateUtils.getDayBegin(date);
        } else if (DateSerialize.TYPE.END.equals(type)) {
            return AppDateUtils.getDayEnd(date);
        }
        return date;
    }
}