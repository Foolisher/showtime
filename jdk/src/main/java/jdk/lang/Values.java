package jdk.lang;

import java.util.Map;

/**
 * Created by wanggen on 15/11/19.
 */
public class Values {

    public static <T> T getVal(Object obj, String field, T... defaultVal) {
        if (obj == null) return null;
        if (obj instanceof String) return (T) obj;
        if (obj instanceof Map) return (T) ((Map) obj).get(field);
        return defaultVal[0];
    }


}
