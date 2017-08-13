package com.common.basemodule.net.client;

import com.common.basemodule.net.callback.CallBack;
import com.common.basemodule.net.client.retrofit.Api;
import com.common.basemodule.net.client.retrofit.MySubscribe;
import com.common.basemodule.net.client.retrofit.StarObservable;

import java.util.Map;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by klx on 2017/8/13.
 */

public class RetrofitRestClient extends RestClient {

    @Override
    public void init() {

    }

    /**
     * @param parameter 请求参数
     */
    private static Observable<String> getStarObserable(Map<String, String> parameter) {
        return Observable.create(new StarObservable<String>(createObservable(parameter)));
    }

    /**
     * @param parameter 请求参数
     */
    private static Observable<String> getStarObserable(String url, Map<String, String> parameter) {
        return Observable.create(new StarObservable<String>(createObservableByPost(url, parameter)));
    }

    /**
     * @return 使用GET请求
     */
    private static Observable<ResponseBody> createObservable(Map<String, String> params) {
        return Api.getInstance().getApiService().methodGet(params);
    }

    /**
     * @return 使用post请求
     */
    private static Observable<ResponseBody> createObservableByPost(String url, Map<String, String> params) {
        return Api.getInstance().getApiService().methodPost(url, params);
    }

    @Override
    public void doGet(final CallBack callBack) {
        getStarObserable(params).subscribe(new MySubscribe<String>() {
            @Override
            public void onNext(String string) {
                callBack.onSuccess(callBack.parseCallBack(string));
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                callBack.onFail(e.getMessage(), -1);
            }
        });
    }

    @Override
    public void doPost(CallBack callBack) {

    }
}
