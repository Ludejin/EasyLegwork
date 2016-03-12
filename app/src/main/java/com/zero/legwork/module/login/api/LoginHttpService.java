package com.zero.legwork.module.login.api;

import com.zero.legwork.common.Const;
import com.zero.legwork.common.http.BaseHttpClient;
import com.zero.legwork.entity.UserInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginHttpService {
    private LoginHttpInterface mService;

    public LoginHttpService() {
        this.mService = BaseHttpClient.getRetrofit().create(LoginHttpInterface.class);
    }

    public UserInfo doLogin(String name, String phone){
        UserInfo mRes = null;

        Map<String, RequestBody> params = new HashMap<>();

        RequestBody p_name = RequestBody.create(MediaType.parse(Const.REQ_TYPE_TEXT), name);
        RequestBody p_phone = RequestBody.create(MediaType.parse(Const.REQ_TYPE_TEXT), phone);

        params.put("name",p_name);
        params.put("phone",p_phone);


        try {
            mRes = mService.doLogin(params).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mRes;
    }

}
