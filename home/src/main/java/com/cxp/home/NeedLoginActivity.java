package com.cxp.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.module_base.Constants;
import com.cxp.module_base.RouterPath;

/**
 * 文 件 名: NeedLoginActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 23:35
 * 描    述: 需要登录页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = RouterPath.NEED_LOGIN_ACTIVITY,extras = Constants.NEED_LOGIN)
public class NeedLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_login);
    }
}
