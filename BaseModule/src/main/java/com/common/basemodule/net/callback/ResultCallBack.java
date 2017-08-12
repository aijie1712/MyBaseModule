package com.common.basemodule.net.callback;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;

/**
 * Created by klx on 2017/8/12.
 * bean回调
 */

public abstract class ResultCallBack<T> implements CallBack<T> {
    @Override
    public void onCancel() {

    }

    @Override
    public T parseCallBack(String string) {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }
        T bean = new Gson().fromJson(string, entityClass);
        return bean;
    }
}
