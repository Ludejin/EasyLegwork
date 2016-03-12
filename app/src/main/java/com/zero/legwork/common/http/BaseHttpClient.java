package com.zero.legwork.common.http;

import com.zero.legwork.common.Const;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public final class BaseHttpClient {

    private static Retrofit mRetrofit = null;

    static {
        if (null == mRetrofit){

            OkHttpClient mClient = new OkHttpClient.Builder()
                    .connectTimeout(5*1000, TimeUnit.MILLISECONDS)
                    .build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(mClient)
                    .build();
        }
    }

    public static Retrofit getRetrofit(){
        return mRetrofit;
    }

}
