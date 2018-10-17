package com.cxp.arouter;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cxp.arouter.service.IService;

public class MainActivity extends AppCompatActivity {

    @Autowired(name = "/service/hello")
    IService service;

    @Autowired(name = "/service/hello1")
    IService service2;

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv=findViewById(R.id.main_tv);

        ARouter.getInstance().inject(this);
    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.main_bt1:
                if (Build.VERSION.SDK_INT >= 16) {
                    //动画
                    ActivityOptionsCompat compat = ActivityOptionsCompat. makeCustomAnimation(MainActivity.this,R.anim.slide_down_in,0);
                    //发起路由跳转
                    ARouter.getInstance().build("/cxp/TestActivity").withOptionsCompat(compat).navigation();
                }else{
                    //发起路由跳转
                    ARouter.getInstance().build("/cxp/TestActivity").navigation();
                }
                break;
            case R.id.main_bt2:
                //startActivityForResult跳转
                ARouter.getInstance()
                        .build("/cxp/TestActivity")
                        .navigation( this , 100 );
                break;
            case R.id.main_bt3:
                //跳转拦截（看log）
                ARouter.getInstance()
                        .build("/cxp/Test")
                        .navigation(this, new NavCallback() {

                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("CXP", "onArrival: 找到了 ");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("CXP", "onArrival: 找不到了 ");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.e("CXP", "onArrival: 跳转完了 ");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("CXP", "onArrival: 被拦截了 ");
                            }
                        });
                break;
            case R.id.main_bt4:
                //传参跳转
                ARouter.getInstance()
                        .build("/cxp/TestActivity")
                        .withString( "name" , "CXP")  //参数：键：key 值：123
                        .navigation();

                //基础类型
                //.withString( String key, String value )
                //.withBoolean( String key, boolean value)
                //.withChar( String key, char value )
                //.withShort( String key, short value)
                //.withInt( String key, int value)
                //.withLong( String key, long value)
                //.withDouble( String key, double value)
                //.withByte( String key, byte value)
                //.withFloat( String key, float value)
                //.withCharSequence( String key,  CharSequence value)

                //数组类型
                //.withParcelableArrayList( String key, ArrayList<? extends Parcelable > value)
                //.withStringArrayList( String key,  ArrayList<String> value)
                //.withIntegerArrayList( String key, ArrayList<Integer> value)
                //.withSparseParcelableArray( String key, SparseArray<? extends Parcelable> value)
                //.withCharSequenceArrayList( String key, ArrayList<CharSequence> value)
                //.withShortArray( String key,  short[] value)
                //.withCharArray( String key, char[] value)
                //.withFloatArray( String key, float[] value)
                //.withCharSequenceArray( String key,  CharSequence[] value)

                //Bundle 类型
                //.with( Bundle bundle )

                //Activity 跳转动画
                //.withTransition(int enterAnim, int exitAnim)

                //其他类型
                //.withParcelable( String key, Parcelable value)
                //.withParcelableArray( String key,  Parcelable[] value)
                //.withSerializable( String key, Serializable value)
                //.withByteArray( String key, byte[] value)
                //.withTransition(int enterAnim, int exitAnim)
                break;
            case R.id.main_bt5:
                //发起路由跳转
                ARouter.getInstance().build("/cxp/FragmentActivity").navigation();
                break;
            case R.id.main_bt6:
                //发起路由跳转
                ARouter.getInstance().build("/cxp/WebViewActivity").navigation();
                break;
            case R.id.main_bt7:
                //暴露服务1
                service.sayHello(this);
                break;
            case R.id.main_bt8:
                //暴露服务2
                service2.sayHello(this);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1) {
            if (requestCode == 100) {
                String name = data.getStringExtra("name");
                mTv.setText(name);
            }
        }
    }


}
