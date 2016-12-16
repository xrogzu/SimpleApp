package com.example.hfs.simpleapp.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by win7 on 2016/12/16.
 * 封装的Rx线程转换
 * 使用： .compose(RxSchedulersHelper.io_main())
 */

public class RxSchedulersHelper {
    public static <T> Observable.Transformer<T, T> io_main() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
