package com.cxp.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

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

    private TextView mTv;
    private Button mBt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        mTv=view.findViewById(R.id.fragment_tv);
        mBt=view.findViewById(R.id.fragment_bt);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/cxp/TestActivity")
                        .navigation( getActivity() , 100 );
            }
        });
        return view ;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            if (requestCode == 100) {
                String name = data.getStringExtra("name");
                mTv.setText(name);
            }
        }
    }

}
