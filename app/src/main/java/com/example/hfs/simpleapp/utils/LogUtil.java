package com.example.hfs.simpleapp.utils;

import com.example.hfs.simpleapp.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by HFS on 2016/12/8.
 * 日志类
 */

public class LogUtil {

    private static final String TAG="SimpleApp";

    public static void init() {
        Logger.init(TAG)                 // 设置Log的TAG值，默认值为 PRETTYLOGGER，也可自定义
                .methodCount(3)                 // 设置Log中调用堆栈的函数行数，默认值为 2，即显示2层
                .hideThreadInfo()               // 隐藏Log中的线程信息，默认值为 shown，即显示线程信息
                .logLevel(LogLevel.FULL)        // 设置Log的是否输出，默认值为 LogLevel.FULL，即Log全输出，LogLevel.NONE即无Log输出
                .methodOffset(0);             // 设置调用堆栈的函数偏移值，默认值为 0，即从打印该Log的函数开始输出堆栈信息
//                .logAdapter(new AndroidLogAdapter()); //设置Log工具，默认值为 AndroidLogAdapter，即 android.util.log
    }

    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.i(msg);
        }
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.d(msg);
        }
    }

    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Logger.w(msg);
        }
    }

    public static void e(String msg) {
        Logger.e(msg);
    }

    public static void e(Throwable e) {
        Logger.e(e, "");
    }

}