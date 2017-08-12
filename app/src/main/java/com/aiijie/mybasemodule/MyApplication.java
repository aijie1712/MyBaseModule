package com.aiijie.mybasemodule;

import android.app.Application;

import com.common.basemodule.image.ImageLoaderManager;


/**
 * Created by klx on 2017/8/12.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderManager.getInstance().init(this);
    }
}
