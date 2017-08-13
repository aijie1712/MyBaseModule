package com.common.basemodule.net;

import com.common.basemodule.net.client.OkHttpRestClient;
import com.common.basemodule.net.client.RestClient;
import com.common.basemodule.net.client.RetrofitRestClient;

/**
 * Created by klx on 2017/8/12.
 * 网络请求管理类
 */

public class HttpManager {
    private static RestClient restClient;

    private HttpManager() {
    }

    public static void init() {
//        restClient = new OkHttpRestClient();
        restClient = new RetrofitRestClient();
        restClient.init();
    }

    public static RestClient getInstance() {
        if (restClient == null) {
            throw new RuntimeException("请先调用init()方法");
        }
        return restClient;
    }
}
