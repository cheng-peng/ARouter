package com.cxp.arouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 文 件 名: WebViewActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-17 12:53
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = "/cxp/WebViewActivity")
public class WebViewActivity extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mWebView=findViewById(R.id.webview);
        mWebView.loadUrl("file:///android_asset/index.html");
    }
}
