package com.common.basemodule.net.client.retrofit;

import android.app.Activity;

import com.common.basemodule.utils.LogUtils;

import rx.Subscriber;

/**
 * Created by Administrator on 2016-12-19
 *
 * @desc 封装的观察者
 */

public abstract class MySubscribe<T> extends Subscriber<T> {

    private Activity activity;
    private String loadingDes;

    public MySubscribe() {
        loadingDes = "";
    }

    public MySubscribe(Activity activity, String loadingDes) {
        this.activity = activity;
        this.loadingDes = loadingDes;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        LogUtils.i("操作onError==" + e.getMessage());
    }

    @Override
    public abstract void onNext(T t);

    @Override
    public void onStart() {
        super.onStart();

    }
}
