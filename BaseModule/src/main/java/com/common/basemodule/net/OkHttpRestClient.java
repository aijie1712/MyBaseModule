package com.common.basemodule.net;

import com.common.basemodule.net.callback.CallBack;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by klx on 2017/8/12.
 * OkHttp 网络请求
 */

public class OkHttpRestClient extends RestClient {
    @Override
    public void doGet(final CallBack callBack) {
        OkHttpUtils.get()
                .url(url)
                .headers(headers)
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callBack.onFail(e.getMessage(),id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callBack.onSuccess(response);
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
                        callBack.onFail(e.getMessage(),id);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        callBack.onSuccess(response);
                    }
                });
    }
}
