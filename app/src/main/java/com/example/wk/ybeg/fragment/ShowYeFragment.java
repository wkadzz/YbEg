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
public class ShowYeFragment extends BaseFragment {
//    董辉辉、
    public static final String TAG=ShowYeFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.showye,container,false);
        return view; }
}
