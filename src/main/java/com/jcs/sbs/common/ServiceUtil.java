package com.jcs.sbs.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javax.persistence.Column;

public class ServiceUtil {

    public static String getColumnName(Class theClass, String fieldName) {
        try {
            Field field = theClass.getDeclaredField(fieldName);
            Annotation annotation = field.getAnnotation(Column.class);

            if (annotation instanceof Column) {
                Column column = (Column) annotation;
                return column.name();
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return null;
    };

    public static String removeLeadingZeroes(String str) {
        int leadingZeroes;
        for (leadingZeroes = 0; leadingZeroes < str.length() && str.charAt(leadingZeroes) == '0'; leadingZeroes++)
            ;
        return str.substring(leadingZeroes);
    }
}
