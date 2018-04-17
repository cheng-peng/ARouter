package com.cxp.arouter.url;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cxp.arouter.R;

/**
 * 文 件 名: URLActivity1
 * 创 建 人: CXP
 * 创建日期: 2018-04-17 11:13
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = "/cxp/URLActivity1")
public class URLActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url1);
    }
}
