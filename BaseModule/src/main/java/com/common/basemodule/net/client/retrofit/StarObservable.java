package com.common.basemodule.net.client.retrofit;

import android.text.TextUtils;
import android.util.Log;

import com.common.basemodule.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by xk on 17/6/4.
 */
public class StarObservable<T> implements Observable.OnSubscribe<T> {
    Observable<ResponseBody> observable;
    public StarObservable(Observable<ResponseBody> observable) {
        this.observable = observable;
    }

    @Override
    public void call(final Subscriber<? super T> subscriber) {

        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody typedString) {
                try {
                    String responseStr = typedString.string();
                    if (!TextUtils.isEmpty(responseStr)) {
                        Log.i("StarObservable", responseStr);
                        Type collectionType = new TypeToken<T>() {}.getType();
                        T t = (T)new Gson().fromJson(responseStr, collectionType);
                        if (t != null) {
                            subscriber.onNext(t);
                        }else {
                            subscriber.onError(new Throwable("返回值转换异常"));
                        }
                    } else {
                        subscriber.onError(new Throwable("没有返回值"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    subscriber.onError(new Throwable(e.getMessage()));
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                subscriber.onError(throwable);
            }
        });
    }
}
