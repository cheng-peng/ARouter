package com.cxp.module_base;

import android.os.Handler;
import android.os.Looper;

/**
 * 文 件 名: MainLooper
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 23:51
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class MainLooper extends Handler {

    private static MainLooper instance = new MainLooper(Looper.getMainLooper());

    protected MainLooper(Looper looper) {
        super(looper);
    }

    public static void runThread(Runnable runnable) {
        if(Looper.getMainLooper().equals(Looper.myLooper())) {
            runnable.run();
        } else {
            instance.post(runnable);
        }

    }
}
