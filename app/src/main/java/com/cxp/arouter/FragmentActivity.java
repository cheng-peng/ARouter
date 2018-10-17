package com.cxp.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

/**
 * 文 件 名: FragmentActivity
 * 创 建 人: CXP
 * 创建日期: 2018-10-17 11:42
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = "/cxp/FragmentActivity")
public class FragmentActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        //2.开启一个事务，通过调用beginTransaction方法开启。
        FragmentTransaction ft =fm.beginTransaction();
        //Fragment 跳转
        Fragment fragment = (Fragment) ARouter.getInstance().build( "/cxp/TestFragment" ).navigation();
        //向容器内加入Fragment，一般使用add或者replace方法实现，需要传入容器的id和Fragment的实例。
        ft.add(R.id.fragment_fl,fragment);
        //提交事务，调用commit方法提交。
        ft.commit();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //多个Fragment的时候使用
        List<Fragment> allFragments = getSupportFragmentManager().getFragments();
        if (allFragments != null) {
            for (Fragment fragment : allFragments) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
