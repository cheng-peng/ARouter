package com.cxp.arouter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * 文 件 名: TestFragment
 * 创 建 人: CXP
 * 创建日期: 2018-04-17 9:35
 * 描    述:
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
@Route(path = "/cxp/TestFragment")
public class TestFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        return view ;
    }
}
