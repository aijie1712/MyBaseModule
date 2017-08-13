package com.common.basemodule.net.client.retrofit;

import com.common.basemodule.utils.LogUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by Administrator on 2016-11-28
 *
 * @desc
 */

public class ResponseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LogUtils.i("request:" + request.toString());
        try {
//            if (!NetworkUtils.isAvailable(CustomApplication.getApplication())) {
//                new UIEvent(UIEvent.EVENT_NET_ERROR).post();
//                throw new NoNetException();
//            }
            // try the request
            Response originalResponse = chain.proceed(request);
            ResponseBody responseBody = originalResponse.body();
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            Charset charset = Charset.forName("UTF8");
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }

            String bodyString = buffer.clone().readString(charset);
//            if (bodyString.contains(AppConstant.INVALID_SESSION)) {
                // session失效，清空session，重新登录
//                Config.setSession("");
//                // session过期，重新登录
//                new UIEvent(UIEvent.EVENT_RE_LOGIN).post();
//            }
//        LogUtils.logL("bodyString==" + bodyString);
            // otherwise just pass the original response on
            return originalResponse;
        } catch (Exception e) {
            return chain.proceed(request);
        }
    }
}
