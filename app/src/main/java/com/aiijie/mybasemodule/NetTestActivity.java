package com.aiijie.mybasemodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.common.basemodule.net.HttpManager;
import com.common.basemodule.net.callback.StringCallBack;
import com.common.basemodule.utils.LogUtils;

import java.net.URLEncoder;

/**
 * 网络库测试
 */
public class NetTestActivity extends AppCompatActivity {
    private final String params = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8f94b1f1bab669bf&redirect_uri=";
    private StringBuilder baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_test);
        baseUrl = new StringBuilder("http://api.t.sina.com.cn/short_url/shorten.json?source=");
        baseUrl.append("3246799287")
                .append("&url_long=" + URLEncoder.encode(params));
    }

    public void doGet(View v) {
        HttpManager.getInstance()
                .url(baseUrl.toString())
                .doGet(new StringCallBack() {
                    @Override
                    public void onFail(String reason, int code) {

                    }

                    @Override
                    public void onSuccess(String response) {
                        LogUtils.i("结果是：" + response);
                    }
                });
    }

    public void doPost(View v) {
        HttpManager.getInstance().doPost(new StringCallBack() {
            @Override
            public void onFail(String reason, int code) {

            }

            @Override
            public void onSuccess(String response) {

            }
        });
    }
}
