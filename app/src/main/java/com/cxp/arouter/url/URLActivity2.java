package com.cxp.arouter.url;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
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
@Route(path = "/cxp/URLActivity2")
public class URLActivity2 extends AppCompatActivity {

    TextView tv;

    @Autowired
    String name;
    @Autowired
    int age;
    @Autowired
    boolean boy;
    @Autowired
    int high;
    @Autowired
    String obj ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url2);

        tv=findViewById(R.id.url2_tv);

        ARouter.getInstance().inject(this);

        //解析参数
        Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString("name");

        tv.setText("参数是： " + "name: " + name + "  age: " + age
                + " boy: " + boy + " name1: " + name1 + " obj: " + obj );
    }
}
