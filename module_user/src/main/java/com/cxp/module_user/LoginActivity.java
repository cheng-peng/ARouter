package com.cxp.module_user;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.module_base.RouterPath;

/**
 * 文 件 名: LoginActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-18 23:18
 * 描    述: 登录页面
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = RouterPath.USER_LOGIN_ACTIVITY)
public class LoginActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext=this;
    }

    public void clickLis(View view){
        Toast.makeText(mContext,"登录",Toast.LENGTH_SHORT).show();
    }

}
