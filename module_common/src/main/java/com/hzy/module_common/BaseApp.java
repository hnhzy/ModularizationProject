package com.hzy.module_common;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by hzy on 2018/12/25
 **/
public class BaseApp extends Application {

    //全局唯一的context
    private static BaseApp application;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
        //MultiDex分包方法 必须最先初始化
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();  // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(application);// 尽可能早，推荐在Application中初始化
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }
}
