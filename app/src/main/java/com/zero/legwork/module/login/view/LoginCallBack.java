package com.zero.legwork.module.login.view;

import com.zero.legwork.entity.UserInfo;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public interface LoginCallBack {
    void doLoginFail(String msg);
    void doLoginSuc(UserInfo userInfo);
}
