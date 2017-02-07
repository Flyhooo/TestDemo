package com.example.mylibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



/**
 * Created by Flyhooo on 2016/12/15 16:12
 * Activity基础类
 * <p>
 * 继承本类加载布局文件在头部添加注解如：
 *
 * @ContentView(R.layout.activity_main) public class MainActivity extends CM_BaseActivity
 */

public abstract class CM_BaseActivity extends AppCompatActivity {

    public AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentLayout());


        activity = this;
        initData();
    }

    public abstract int getContentLayout();

    /**
     * 数据操作
     */
    protected abstract void initData();



}
