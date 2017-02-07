package com.example.mylibrary.base;

import android.app.Application;

import com.example.mylibrary.R;

import exception.UnCacheExceptionHandler;
import file.FilePathUtils;
import log.CM_Config;
import log.CM_Toast;


/**
 * Created by Flyhooo on 2016/12/15 16:08
 * <p>
 * 实现程序异常处理
 * Toast统一工具
 * Log日志管理
 * 文件路径管理
 * Xutils框架集成（注解 、数据库、网络请求）
 * 图片加载
 * xRecyclerView（多种上拉加载 下拉刷新效果）
 * BaseAdapter 简化adapter代码并集成onItemClickListener、onItemLongClickListener
 * 下载安装包并自动更新
 * SharedPreferences存取数据封装
 */
public abstract class CM_BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        //设置程序未知异常处理
        UnCacheExceptionHandler catchExcep = UnCacheExceptionHandler.getInstance();
        if (!CM_Config.IS_DEBUG) {
            catchExcep.init(this);
        }



        CM_Toast.init(getApplicationContext());//初始化toast提示

        FilePathUtils.init("ETSPos_Android");//初始化文件路径管理

        init();
    }

    /**
     * 初始化
     */
    protected abstract void init();


    /**
     * 控制调试开关
     *
     * @param isDebug
     */
    public void setDebug(boolean isDebug) {
        CM_Config.IS_DEBUG=isDebug;
    }

}
