package com.example.administrator.testdemo;

import com.example.mylibrary.base.CM_BaseApplication;

import log.CM_Toast;

/**
 * Created by Flyhooo on 2017/2/7 15:29
 */

public class MainApplication extends CM_BaseApplication {
    @Override
    protected void init() {
        CM_Toast.init(this);
    }
}
