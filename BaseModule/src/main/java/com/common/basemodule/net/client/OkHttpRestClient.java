package com.common.basemodule.net.client;

import com.common.basemodule.net.NetConstant;
import com.common.basemodule.net.callback.CallBack;
import com.common.basemodule.net.client.RestClient;
import com.common.basemodule.net.client.retrofit.LogInterceptor;
import com.common.basemodule.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;

/**
 * Created by klx on 2017/8/12.
 * OkHttp 网络请求
 */

public class OkHttpRestClient extends RestClient {
    @Override
    public void init() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
//                .addInterceptor(new ResponseInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }

    @Override
    public void doGet(final CallBack callBack) {
        OkHttpUtils.get()
                .url(NetConstant.BSE_URL + "weather/index")
                .headers(headers)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.onFail(e.getMessage(), id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtils.i("get结果：" + response);
                        callBack.onSuccess(callBack.parseCallBack(response));
                    }
                });
    }

    @Override
    public void doPost(final CallBack callBack) {
        OkHttpUtils.post()
                .url(url)
                .headers(headers)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.onFail(e.getMessage(), id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtils.i("post结果：" + response);
                        callBack.onSuccess(callBack.parseCallBack(response));
                    }
                });
    }
}
