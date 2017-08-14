package com.aiijie.mybasemodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aiijie.mybasemodule.bean.ShortUrlBean;
import com.common.basemodule.net.HttpManager;
import com.common.basemodule.net.NetConstant;
import com.common.basemodule.net.callback.ResultCallBack;
import com.common.basemodule.net.callback.StringCallBack;
import com.common.basemodule.utils.LogUtils;

import java.net.URLEncoder;
import java.util.List;

/**
 * 网络库测试
 */
public class NetTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_test);
    }

    public void doGet(View v) {
        HttpManager.getInstance()
                .addParam("cityname", "苏州")
                .addParam("key", NetConstant.WEATHER_KEY)
                .doGet(new StringCallBack() {
                    @Override
                    public void onFail(String reason, int code) {

                    }

                    @Override
                    public void onSuccess(String response) {
                        LogUtils.i("结果：" + response);
                    }
                });
    }

    public void doPost(View v) {
//        HttpManager.getInstance().doPost(new StringCallBack() {
//            @Override
//            public void onFail(String reason, int code) {
//
//            }
//
//            @Override
//            public void onSuccess(String response) {
//
//            }
//        });
    }
}
