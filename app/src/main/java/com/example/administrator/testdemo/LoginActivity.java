package com.example.administrator.testdemo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.mylibrary.base.CM_BaseActivity;

import log.CM_Toast;

/**
 * Created by Flyhooo on 2017/2/7 15:15
 */

public class LoginActivity extends CM_BaseActivity {
    @Override
    public int getContentLayout() {
        return R.layout.activity_login;
    }

    private EditText accountET, pwdET;
    private String account, pwd;
    private ProgressBar progressBar;

    @Override
    protected void initData() {
        accountET = (EditText) findViewById(R.id.login_account_Etx);
        pwdET = (EditText) findViewById(R.id.login_password_Etx);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.login_login_Btn:
                account = accountET.getText().toString();
                pwd = pwdET.getText().toString();

                if (TextUtils.isEmpty(account) && TextUtils.isEmpty(pwd)) {
                    CM_Toast.showShort("请输入账号密码");
                } else {
                    login();
                }
                break;
        }
    }

    private void login() {
        progressBar.setVisibility(View.VISIBLE);
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    startActivity(new Intent(activity, MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();
    }


}
