package com.shrb.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shrb.hrsdk.sdk.HRSDK;
import com.shrb.hrsdk.util.HRResponse;

import java.util.Map;

import constant.Constant;
import util.HRUtil;


/**
 * Created by Administrator on 2016/10/10.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private static final String USER_TOKEN = "userToken";
    private static final String MERCHANT_ID = "merchantId";
    private TextView init_sdk;
    private EditText usertoken_input_et;
    private EditText et_merchant_id;
    private EditText getinfo_show_et;
    private EditText et_show_success_page;

    private static String appID="87042462-8071-4020-b2f8-4998d4e001d2";
    private String loginSign;

    private String random = "123456";
    private SharedPreferences preferences;

    public static String getAppID() {
        return appID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);
        preferences = getSharedPreferences("hrSDK", Context.MODE_PRIVATE);
        appID = getIntent().getStringExtra("appId");
        loginSign = getIntent().getStringExtra("loginSign");
        init();
    }

    private void init() {
        init_sdk = (TextView) findViewById(R.id.init_sdk);
        usertoken_input_et = (EditText) findViewById(R.id.usertoken_input_et);
        getinfo_show_et = (EditText) findViewById(R.id.getinfo_show_et);
        et_merchant_id = (EditText) findViewById(R.id.et_merchant_id);
        et_show_success_page = (EditText) findViewById(R.id.et_show_success_page);
        init_sdk.setOnClickListener(this);
        String userToken = getValue(USER_TOKEN).length() != 0 ? getValue(USER_TOKEN) : "123456";
//        String merchantId = getValue(MERCHANT_ID).length() != 0 ? getValue(MERCHANT_ID) : "SHRB01100000000385";//uat
//        String merchantId = getValue(MERCHANT_ID).length() != 0 ? getValue(MERCHANT_ID) : "SHRB01100000000387";//uat
//        String merchantId = getValue(MERCHANT_ID).length() != 0 ? getValue(MERCHANT_ID) : "SYT011";//sitSHRB01100000000387
        String merchantId = getValue(MERCHANT_ID).length() != 0 ? getValue(MERCHANT_ID) : "SHRB01200000000110";//生产
//        MERCHANT_ID : "SHRB01200000000110";//生产
        usertoken_input_et.setText(userToken);
        et_merchant_id.setText(merchantId);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.init_sdk:
                initSDK();
                break;
        }
    }

    private void initSDK() {
        final String appUserId = usertoken_input_et.getText().toString().trim();
        final String merchantId = et_merchant_id.getText().toString().trim();
        final String isShowSuccessPageStr = et_show_success_page.getText().toString().trim();
        HRSDK.initWithAppID(appID, isShowSuccessPageStr,appUserId, merchantId, loginSign, random, this, new HRResponse() {
            @Override
            public void response(Object obj) {
                Map responseMap = (Map) obj;
                HRUtil.splitString(responseMap.toString(), getinfo_show_et);
                String returnCode = (String) responseMap.get("returnCode");
                if (HRUtil.notNull(returnCode)) {
                    save(USER_TOKEN, appUserId);
                    save(MERCHANT_ID, merchantId);
                    Constant.mchID = merchantId;
                    Intent intent = new Intent(MainActivity.this, FunctionSelectActivity.class);
                    startActivity(intent);
                }
                Log.e("responseMap:", responseMap.toString());
            }
        });

    }

    public void save(String key, String value) {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public String getValue(String key) {
        return preferences.getString(key, "");
    }

}
