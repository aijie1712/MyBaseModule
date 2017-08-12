package com.aiijie.mybasemodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.common.basemodule.image.ImageLoaderManager;
import com.common.basemodule.widget.SendVerifyCodeView;

public class MainActivity extends AppCompatActivity {

    private SendVerifyCodeView sendVerifyView;
    private ImageView iv_image;

    private String url = "http://img1.imgtn.bdimg.com/it/u=679805784,3150507797&fm=214&gp=0.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendVerifyView = (SendVerifyCodeView) findViewById(R.id.sendVerifyView);
        iv_image = (ImageView) findViewById(R.id.iv_image);

        ImageLoaderManager.getInstance().showImage(ImageLoaderManager.getDefaultOptions(iv_image, url));
    }

    public void onSendSuccess(View view) {
        sendVerifyView.onSendSuccess();
    }

    public void onSendFail(View view) {
        sendVerifyView.onSendFail();
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_go_pay:  // 支付测试
                startActivity(new Intent(this,PayTestActivity.class));
                break;
            case R.id.btn_net: // 网络请求
                startActivity(new Intent(this,NetTestActivity.class));
                break;
        }
    }
}
