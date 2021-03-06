package com.cxp.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 文 件 名: TestActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-16 17:21
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = "/cxp/TestActivity")
public class TestActivity extends AppCompatActivity {

    @Autowired
    String name;

    TextView tv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);

        //传参解析
        ARouter.getInstance().inject(this);

        tv=findViewById(R.id.test_tv);

        //解析参数
        Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString("name");

        if (name!=null) {
            tv.setText("name："+name+"\nname1："+name1);
        }

    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_down_out);
    }

    public void clickLis(View view) {
        //数据是使用Intent返回
        Intent intent = new Intent(); //把返回数据存入
        intent.putExtra("name", "CXP"); //设置返回数据
        setResult(1, intent);
        finish();
    }
}
