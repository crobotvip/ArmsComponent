package com.shrb.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import constant.Constant;
import util.HRUtil;

/**
 * Created by user on 2016/11/9.
 */

public class InitActivity extends Activity implements View.OnClickListener {
    private EditText et_appid;
    private EditText et_secure_key;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        preferences = getSharedPreferences("hrSDK", Context.MODE_PRIVATE);
        findViewById(R.id.tv_load_appid_save).setOnClickListener(this);
        findViewById(R.id.tv_load_secure_key_save).setOnClickListener(this);
        findViewById(R.id.tv_init).setOnClickListener(this);
        et_appid = (EditText) findViewById(R.id.et_appid);
        et_secure_key = (EditText) findViewById(R.id.et_secure_key);
        et_appid.setText("135a3a1a-a41c-4919-a819-5afb5b5e5231");//亏普生产
        et_secure_key.setText("8ec4973b-39f7-44a1-b275-1fdfcebd1246");//亏普生产
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_init:
                init();
                break;
            case R.id.tv_load_appid_save:
                et_appid.setText(getValue("appId"));
                break;
            case R.id.tv_load_secure_key_save:
                et_secure_key.setText(getValue("secureKey"));
                break;
        }
    }

    private void init() {
        String appId = et_appid.getText().toString();
        String secureKey = et_secure_key.getText().toString();
        save(appId, secureKey);
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("appId", appId);
        intent.putExtra("loginSign", HRUtil.signLogin(appId, "123456", secureKey));
        Constant.secureKey = secureKey;
        startActivity(intent);
    }

    public void save(String appId, String secureKey) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString("appId", appId);
        edit.putString("secureKey", secureKey);
        edit.commit();
    }

    public String getValue(String key) {
        return preferences.getString(key, "");
    }

}
