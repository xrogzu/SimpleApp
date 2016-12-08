package com.example.hfs.simpleapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HFS on 2016/12/7.
 * 一般用于初始化一些数据，如屏幕的信息之类的和Activity的简单的管理啊，还有一些第三方SDK的初始化
 */

public class App extends Application {

    private static App instance;
    private Set<Activity> allActivities;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    /**
     * 返回App 实例对象
     *
     * @return App
     */
    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        getScreenSize();

        initLogger();
    }


    /**
     * 初始化屏幕宽高
     */
    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    /**
     * 添加activity
     */
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    /**
     * 移除activity
     */
    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出app
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 这还有一系列的第三方SDK的初始化
     */

    private void initLogger() {
        Logger.init()                 // 设置Log的TAG值，默认值为 PRETTYLOGGER，也可自定义
                .methodCount(3)                 // 设置Log中调用堆栈的函数行数，默认值为 2，即显示2层
                .hideThreadInfo()               // 隐藏Log中的线程信息，默认值为 shown，即显示线程信息
                .logLevel(LogLevel.FULL)        // 设置Log的是否输出，默认值为 LogLevel.FULL，即Log全输出，LogLevel.NONE即无Log输出
                .methodOffset(0);             // 设置调用堆栈的函数偏移值，默认值为 0，即从打印该Log的函数开始输出堆栈信息
//                .logAdapter(new AndroidLogAdapter()); //设置Log工具，默认值为 AndroidLogAdapter，即 android.util.log
    }
}
