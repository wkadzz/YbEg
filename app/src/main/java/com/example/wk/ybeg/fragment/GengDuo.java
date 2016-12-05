package com.example.wk.ybeg.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wk.ybeg.R;
import com.rock.qrcodelibrary.CaptureActivity;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by WK on 2016/11/25.
 */
public class GengDuo extends BaseFragment implements View.OnClickListener {
    public static final String TAG=GengDuo.class.getSimpleName();
    private TextView erweima;
    private TextView share;
    private int QR_REQUEST=80;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.gengduo,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        erweima = ((TextView) view.findViewById(R.id.erweima));
        share = ((TextView) view.findViewById(R.id.share));
        erweima.setOnClickListener(this);
        share.setOnClickListener(this);
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.erweima:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent,QR_REQUEST);
                break;
            case R.id.share:
                showShare();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==getActivity().RESULT_OK) {
            if (requestCode==QR_REQUEST) {
                String stringExtra = data.getStringExtra(CaptureActivity.RESULT);
                Toast.makeText(getActivity(), stringExtra, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
