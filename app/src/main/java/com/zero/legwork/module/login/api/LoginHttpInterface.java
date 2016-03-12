package com.zero.legwork.module.login.api;

import com.zero.legwork.entity.UserInfo;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public interface LoginHttpInterface {
    @Multipart
    @POST("clerk/getClerkByPhone")
    Call<UserInfo> doLogin(@PartMap Map<String, RequestBody> params);
}
