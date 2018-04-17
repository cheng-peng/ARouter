package com.cxp.arouter.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 文 件 名: IService
 * 创 建 人: CXP
 * 创建日期: 2018-04-17 13:04
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public interface IService extends IProvider {

    void sayHello(Context context );
}
