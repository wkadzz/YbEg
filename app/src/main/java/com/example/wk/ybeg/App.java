package com.example.wk.ybeg;

import android.app.Application;

import org.xutils.DbManager;
import org.xutils.x;

import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;

/**
 * Created by WK on 2016/11/29.
 */
public class App extends Application {
    public static DbManager.DaoConfig daoConfig = new DbManager.DaoConfig();;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
        ShareSDK.initSDK(this,"193f56fde01b9");
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig();
        daoConfig.setDbName("goods")
                .setAllowTransaction(true);
    }
}
