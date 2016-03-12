package com.zero.legwork.module.login.model.impl;

import com.zero.legwork.entity.UserInfo;
import com.zero.legwork.module.login.api.LoginHttpService;
import com.zero.legwork.module.login.model.LoginModel;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginModelImpl implements LoginModel {

    private LoginHttpService mService = new LoginHttpService();

    @Override
    public Observable<UserInfo> doLogin(final String name, final String phone) {
        return Observable.create(new Observable.OnSubscribe<UserInfo>() {
            @Override
            public void call(Subscriber<? super UserInfo> subscriber) {
                subscriber.onNext(
                    mService.doLogin(name,phone)
                );
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());
    }
}
