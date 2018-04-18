package com.cxp.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.module_base.RouterPath;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.main_bt1:
                //跳转用户模块登录页
                ARouter.getInstance().build(RouterPath.USER_LOGIN_ACTIVITY).navigation();
                break;
            case R.id.main_bt2:
                //登录拦截器测试
                ARouter.getInstance().build(RouterPath.NEED_LOGIN_ACTIVITY).navigation();
                break;
        }
    }
}
