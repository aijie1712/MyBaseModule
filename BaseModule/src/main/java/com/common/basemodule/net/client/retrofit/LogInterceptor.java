/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.common.basemodule.net.client.retrofit;


import com.common.basemodule.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Retrofit2 Log拦截器。用于保存和设置Cookies
 *
 * @author yuyh.
 * @date 16/8/6.
 */
public final class LogInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        KLog.d(String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
        LogUtils.i("请求url："+request.url());
        long t1 = System.nanoTime();
        Response response = chain.proceed(chain.request());
        long t2 = System.nanoTime();
//        KLog.d(String.format(Locale.getDefault(), "Received response for %s in %.1fms%n%s",
//                response.request().url(), (t2 - t1) / 1e6d, response.headers()));

        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();

//        KLog.json(content);
        // 解析json
        try {
            JSONObject jsonObject = new JSONObject(content);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}
