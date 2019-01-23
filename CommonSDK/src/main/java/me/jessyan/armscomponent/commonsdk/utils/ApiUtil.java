package me.jessyan.armscomponent.commonsdk.utils;

import android.util.Log;

import com.google.gson.Gson;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import me.jessyan.armscomponent.commonsdk.core.IBaseResponse;
import me.jessyan.armscomponent.commonsdk.core.NetError;

public class ApiUtil {
    /**
     * 异常处理变换
     *
     * @return
     */
    public static <T extends IBaseResponse> ObservableTransformer<T, T> getObservableTransformer() {

        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.flatMap(new Function<T, Observable<T>>() {
                    @Override
                    public Observable<T> apply(T model) throws Exception {
//                        Log.i("XApi", "exception msg：" + new Gson().toJson(model));
                        if (model == null || model.isNull()) {
                            return Observable.error(new NetError(model.getErrorMsg(), NetError.NoDataError));
                        } else if (model.isAuthError()) {
                            return Observable.error(new NetError(model.getErrorMsg(), NetError.AuthError));
                        } else if (model.isBizError()) {
                            return Observable.error(new NetError(model.getErrorMsg(), NetError.BusinessError));
                        } else {
                            return Observable.just(model);
                        }
                    }
                });
            }
        };
    }

    /**
     * 异常处理变换
     *
     * @return
     */
    @Deprecated
    public static <T extends IBaseResponse> FlowableTransformer<T, T> getFlowableTransformer() {

        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.flatMap(new Function<T, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(T model) throws Exception {
                        Log.i("XApi", "exception msg：" + new Gson().toJson(model));
                        if (model == null || model.isNull()) {
                            return Flowable.error(new NetError(model.getErrorMsg(), NetError.NoDataError));
                        } else if (model.isAuthError()) {
                            return Flowable.error(new NetError(model.getErrorMsg(), NetError.AuthError));
                        } else if (model.isBizError()) {
                            return Flowable.error(new NetError(model.getErrorMsg(), NetError.BusinessError));
                        } else {
                            return Flowable.just(model);
                        }
                    }
                });
            }
        };
    }
}
