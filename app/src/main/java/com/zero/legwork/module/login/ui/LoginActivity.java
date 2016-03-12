package com.zero.legwork.module.login.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zero.legwork.R;
import com.zero.legwork.app.homepage.MainActivity;
import com.zero.legwork.entity.UserInfo;
import com.zero.legwork.module.login.presenter.LoginPresenter;
import com.zero.legwork.module.login.presenter.impl.LoginPresenterImpl;
import com.zero.legwork.module.login.view.LoginCallBack;
import com.zero.legwork.utils.CodeUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jin_ on 2016/3/12
 * 邮箱：dejin_lu@creawor.com
 */
public class LoginActivity extends AppCompatActivity
        implements OnClickListener,LoginCallBack {

    private Context mContext;
    private LoginPresenter mPresenter;

    private String mMsg;

    @Bind(R.id.edt_name) EditText mName;
    @Bind(R.id.edt_phone) EditText mPhone;
    @Bind(R.id.btn_doLogin) Button doLogin;
    @Bind(R.id.img_getCode) ImageView getCode;
    @Bind(R.id.edt_verifyCode) EditText mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = new LoginPresenterImpl(this);

        initData();
        initEvent();
    }

    private void initEvent() {
        getCode.setOnClickListener(this);
        doLogin.setOnClickListener(this);
    }

    private void initData() {
        getCode.setImageBitmap(CodeUtils.getInstance().getBitmap());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_getCode:
                getVerifyCode();
                break;
            case R.id.btn_doLogin:
                doLogin();
                break;
        }
    }

    /*
     * 执行登录
     */
    private void doLogin(){
        if (isValid()) {
            mPresenter.doLogin(mName.getText().toString()
                    , mPhone.getText().toString());
        } else {
            Toast.makeText(mContext,mMsg,Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 重新获取验证码
     */
    private void getVerifyCode(){
        getCode.setImageBitmap(CodeUtils.getInstance().getBitmap());
    }

    private boolean isValid(){
        if (TextUtils.isEmpty(mName.getText().toString())){
            mMsg = "请输入用户名";
            return false;
        }
        if (TextUtils.isEmpty(mPhone.getText().toString())){
            mMsg = "请输入手机号码";
            return false;
        }
        if (!mCode.getText().toString().equals(CodeUtils.getInstance().getCode())){
            mMsg = "验证码不正确";
            return false;
        }
        return true;
    }

    /**
     * 登录失败返回失败信息
     * @param msg 提示信息
     */
    @Override
    public void doLoginFail(String msg) {
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 登录成功
     * @param userInfo 登录结果
     */
    @Override
    public void doLoginSuc(UserInfo userInfo) {
        this.finish();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
