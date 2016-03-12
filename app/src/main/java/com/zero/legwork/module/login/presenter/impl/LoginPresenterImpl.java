package com.zero.legwork.module.login.presenter.impl;

import com.zero.legwork.entity.UserInfo;
import com.zero.legwork.module.login.model.LoginModel;
import com.zero.legwork.module.login.model.impl.LoginModelImpl;
import com.zero.legwork.module.login.presenter.LoginPresenter;
import com.zero.legwork.module.login.view.LoginCallBack;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginModel mModel;
    private LoginCallBack mCallback;

    public LoginPresenterImpl(LoginCallBack mCallback) {
        this.mCallback = mCallback;
        this.mModel = new LoginModelImpl();
    }

    @Override
    public void doLogin(String name, String phone) {
        mModel.doLogin(name,phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<UserInfo>() {
                    @Override
                    public void call(UserInfo userInfo) {
                        mCallback.doLoginSuc(userInfo);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mCallback.doLoginFail("发生异常");
                    }
                });
    }
}
