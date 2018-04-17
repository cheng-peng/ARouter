package com.cxp.arouter.service;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 文 件 名: MyService
 * 创 建 人: CXP
 * 创建日期: 2018-04-17 13:04
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = "/service/hello", name = "测试服务")
public class MyService implements IService {
    @Override
    public void sayHello(Context context) {
        Toast.makeText(  context , "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {

    }
}
