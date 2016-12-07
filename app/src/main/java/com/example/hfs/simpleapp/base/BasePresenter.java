package com.example.hfs.simpleapp.base;

/**
 * Created by HFS on 2016/12/7.
 * MVP框架的简单封装 P处理层
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
