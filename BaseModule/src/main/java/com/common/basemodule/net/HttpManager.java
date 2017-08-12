package com.common.basemodule.net;

import com.common.basemodule.net.callback.CallBack;

/**
 * Created by klx on 2017/8/12.
 * 网络请求管理类
 */

public class HttpManager extends RestClient {
    private static RestClient restClient;

    private HttpManager() {
    }

    public static void init(){
        restClient = new OkHttpRestClient();
    }

    public static RestClient getInstance() {
        return restClient;
    }

    @Override
    public void doGet(CallBack callBack) {
        restClient.doGet(callBack);
    }

    @Override
    public void doPost(CallBack callBack) {
        restClient.doPost(callBack);
    }
}
