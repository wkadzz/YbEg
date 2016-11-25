package com.example.wk.ybeg.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wk.ybeg.R;

/**
 * Created by WK on 2016/11/25.
 */
public class GengDuo extends BaseFragment {
    public static final String TAG=GengDuo.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.gengduo,container,false);
        return view; }
}
