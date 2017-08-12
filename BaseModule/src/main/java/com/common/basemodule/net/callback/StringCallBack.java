package com.common.basemodule.net.callback;

/**
 * Created by klx on 2017/8/12.
 * 字符串回调
 */

public abstract class StringCallBack implements CallBack<String> {
    @Override
    public void onCancel() {

    }

    @Override
    public String parseCallBack(String resultStr) {
        return resultStr;
    }
}
