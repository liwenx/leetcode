package com.liwx.util;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;

public class TranslateUtil {

    public static <target, source> target translateObject(source source, Class<target> cls) {
        if (null == source) {
            return null;
        }
        target target;
        try {
            Gson gson = new Gson();
            String srStr = gson.toJson(source);
            target = gson.fromJson(srStr, cls);
        } catch (Exception e) {
            throw new IllegalArgumentException("对象转换失败，请检查相关对象", e);
        }
        return target;
    }

    /**
     * source, new TypeToken<List<target>>(){}.getType()
     */
    public static <target, source> target translateObjectList(source source, Type type) {
        if (null == source) {
            return null;
        }
        target target;
        try {
            Gson gson = new Gson();
            String srStr = gson.toJson(source);
            target = gson.fromJson(srStr, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("对象转换失败，请检查相关对象", e);
        }
        return target;
    }

    public static <source,T> List<T> fastTranslateObjectList(source source, Class<T> clazz) {
        if (null == source) {
            return null;
        }
        final List<T> ts;
        try {
            String srStr = JSON.toJSONString(source);
            ts = JSON.parseArray(srStr, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException("对象转换失败，请检查相关对象", e);
        }
        return ts;
    }
}
