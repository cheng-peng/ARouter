package com.cxp.arouter.url;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.arouter.R;

/**
 * 文 件 名: URLActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-17 11:08
 * 描    述: URL跳转
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */

public class URLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url);

        Uri uri = getIntent().getData();
        ARouter.getInstance().build(uri).navigation();
        finish();
    }
}
