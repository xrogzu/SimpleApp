package com.example.hfs.simpleapp.rx;

import com.example.hfs.simpleapp.base.BaseResponse;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by win7 on 2016/12/16.
 * Rx处理服务器返回
 */

public class RxResultHelper {

    public static <T> Observable.Transformer<BaseResponse<T>, T> handleResult() {
        return new Observable.Transformer<BaseResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResponse<T>> tObservable) {
                return tObservable.flatMap(
                        new Func1<BaseResponse<T>, Observable<T>>() {
                            @Override
                            public Observable<T> call(BaseResponse<T> result) {

                                if (result.getStatus() == BaseResponse.SUCCESS) {
                                    return createData(result.getData());
                                } else {
                                    return Observable.error(new ServerException(result.getMessage()));
                                }

                            }
                        }

                );
            }
        };
    }

    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
