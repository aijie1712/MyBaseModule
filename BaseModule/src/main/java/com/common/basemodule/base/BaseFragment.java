package com.common.basemodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by klx on 2017/8/12.
 * Fragment基类
 */

public abstract class BaseFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), null);
        initView();
        initData();
        return rootView;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();
}
