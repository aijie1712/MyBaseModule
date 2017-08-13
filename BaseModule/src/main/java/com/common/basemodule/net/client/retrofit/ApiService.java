package com.common.basemodule.net.client.retrofit;


import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 网络请求service
 */

public interface ApiService {
    @GET("weather/index")
    Observable<ResponseBody> methodGet(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST()
    Observable<ResponseBody> methodPost(@Url String url, @FieldMap Map<String, String> map);

    @Multipart
    @POST
    Observable<ResponseBody> uploadFile(@Url String url, @Part("description") RequestBody description,
                                        @Part MultipartBody.Part file);

}
