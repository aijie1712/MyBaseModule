package com.common.basemodule.image;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by klx on 2017/8/12.
 */

public interface IImageLoaderstrategy {
    void showImage(@NonNull ImageLoaderOptions options);
    void cleanMemory(Context context);
    // 在application的oncreate中初始化
    void init(Context context);
}
