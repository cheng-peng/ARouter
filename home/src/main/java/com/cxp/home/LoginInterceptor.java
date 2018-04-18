package com.cxp.home;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.module_base.Constants;
import com.cxp.module_base.MainLooper;
import com.cxp.module_base.RouterPath;

/**
 * 文 件 名: LoginInterceptor
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 23:48
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Interceptor(priority = 8, name = "登录跳转拦截器")
public class LoginInterceptor implements IInterceptor {

    private Context mContext;

    @Override
    public void process(Postcard postcard,final InterceptorCallback callback) {
        if (Constants.NEED_LOGIN==postcard.getExtra()) {
            MainLooper.runThread(new Runnable() {
                @Override
                public void run() {
                    //如果需要再界面展示东西，需要切换到主线程进行操作
                    Toast.makeText(mContext, "请登录", Toast.LENGTH_SHORT).show();
                    ARouter.getInstance().build(RouterPath.USER_LOGIN_ACTIVITY).navigation();
                    //处理完成，交还控制权
                    callback.onInterrupt(null);
                }
            });
        }else {
            //处理完成，交还控制权
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        mContext = context;
        //此处做一些初始化的工作
    }
}
