package com.common.basemodule.net.client;

import com.common.basemodule.net.NetConstant;
import com.common.basemodule.net.callback.CallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klx on 2017/8/12.
 * 网络工具类
 */

public abstract class RestClient {
    protected String url = NetConstant.BSE_URL;
    // 请求头
    protected Map<String, String> headers = new HashMap<>();
    // 请求参数
    protected Map<String, String> params = new HashMap<>();

    public RestClient setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public RestClient setHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public RestClient addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public RestClient addHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public RestClient url(String url) {
        this.url = url;
        return this;
    }

    public abstract void init();

    public abstract void doGet(CallBack callBack);

    public abstract void doPost(CallBack callBack);
}
