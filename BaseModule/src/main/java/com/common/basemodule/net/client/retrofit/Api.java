package com.common.basemodule.net.client.retrofit;


import com.common.basemodule.net.NetConstant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2016-11-25
 *
 * @desc
 */

public class Api {
    public static Api instance;
    private static Retrofit retrofit;
    private static ApiService service;
    private static final Object monitor = new Object();

    public Api(OkHttpClient okHttpClient) {
        retrofit = new Retrofit.Builder()
                .baseUrl(NetConstant.BSE_URL)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
    }

    private static OkHttpClient getHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
//                .addInterceptor(new ResponseInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
        return okHttpClient;
    }

    public static Api getInstance() {
        if (instance == null)
            instance = new Api(getHttpClient());
        return instance;
    }

    public ApiService getApiService() {
        synchronized (monitor) {
            if (service == null) {
                service = retrofit.create(ApiService.class);
            }
            return service;
        }
    }
}
