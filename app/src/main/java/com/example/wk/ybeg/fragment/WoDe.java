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
public class WoDe extends BaseFragment {
    public static final String TAG=WoDe.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.wode,container,false);
        return view; }
}
