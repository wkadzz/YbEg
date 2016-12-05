package com.example.wk.ybeg.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wk.ybeg.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Set;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by WK on 2016/11/25.
 */
public class WoDe extends BaseFragment implements View.OnClickListener, PlatformActionListener,Handler.Callback {
    public static final String TAG=WoDe.class.getSimpleName();
    private static final int IMG = 99;
    private Button mBtn;
    private Handler handler;
    private static final int NAME=100;
    private TextView name;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.wode,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mBtn = ((Button) view.findViewById(R.id.denglu));
        mBtn.setOnClickListener(this);
        handler=new Handler(this);
        name = ((TextView) view.findViewById(R.id.wode_name));
        img = ((ImageView) view.findViewById(R.id.wode_img));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.denglu:
                login();
                break;
        }
    }

    private void login() {
        //获取指定的平台
        Platform platform = ShareSDK.getPlatform(getContext(), QQ.NAME);
        //为平台操作动作添加监听
        platform.setPlatformActionListener(this);

        //平台认证
        platform.authorize();
        //showUser
        platform.showUser(null);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Set<String> keySet = hashMap.keySet();
        for (String s : keySet) {
            Log.e(TAG, "onComplete: "+s+"---"+hashMap.get(s) );
            if (s.equals("nickname")) {
                Log.e(TAG, "onComplete: "+hashMap.get(s) );
                Message msg = new Message();
                msg.what=NAME;
                msg.obj=hashMap.get(s);
                handler.sendMessage(msg);
            }
            if (s.equals("figureurl_qq_1")) {
                Log.e(TAG, "onComplete: "+hashMap.get(s) );
                Message msg = new Message();
                msg.what=IMG;
                msg.obj=hashMap.get(s);
                handler.sendMessage(msg);
            }
        }
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case NAME:
                if (msg.obj != null) {
                    name.setVisibility(View.VISIBLE);
                    name.setText((CharSequence) msg.obj);
                    mBtn.setText("切换用户");
                }
                break;
            case IMG:
                if (msg.obj!=null){
                    img.setVisibility(View.VISIBLE);
                    Picasso.with(getContext()).load((String) msg.obj).into(img);
                }
                break;
        }

        return true;
    }
}
