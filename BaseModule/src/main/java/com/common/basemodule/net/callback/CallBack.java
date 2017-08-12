package com.common.basemodule.net.callback;

/**
 * Created by klx on 2017/8/12.
 *
 */

public interface CallBack<T> {
    void onFail(String reason,int code);
    void onCancel();
    void onSuccess(T response);
    T parseCallBack(String resultStr);
}
