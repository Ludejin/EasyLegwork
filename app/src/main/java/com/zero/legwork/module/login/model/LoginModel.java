package com.zero.legwork.module.login.model;

import com.zero.legwork.entity.UserInfo;

import rx.Observable;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public interface LoginModel {
    Observable<UserInfo> doLogin(String name,String phone);
}
