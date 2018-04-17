package com.cxp.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 文 件 名: MyApplication
 * 创 建 人: CXP
 * 创建日期: 2018-04-16 17:20
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init( this ); // 尽可能早，推荐在Application中初始化
    }
}
