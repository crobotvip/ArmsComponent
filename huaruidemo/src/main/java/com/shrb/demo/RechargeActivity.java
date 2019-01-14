package com.shrb.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.shrb.hrsdk.sdk.HRSDK;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import util.HRUtil;

/**
 * Created by chenli on 2018/4/11.
 */

public class RechargeActivity extends Activity implements View.OnClickListener {
    private static EditText et_show_msg;
    private EditText et_money;
    private EditText et_order_id;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_recharge).setOnClickListener(this);
        et_money = (EditText) findViewById(R.id.et_money);
        et_order_id = (EditText) findViewById(R.id.et_order_id);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        et_order_id.setText(getRandomOrderId(""));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_recharge:
                Map extraMessage = new HashMap();
                String money = et_money.getText().length() == 0 ? "100" : et_money.getText().toString();
                if (et_order_id.getText().length() > 0) {
                    extraMessage.put("outTradeNo", et_order_id.getText().toString());
                }
                HRSDK.Users.recharge(money, extraMessage, this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case HRSDK.METHOD_RECHARGE:
                if (resultCode == RESULT_OK) {
                    HashMap map = (HashMap) data.getSerializableExtra("data");
                    if (map != null) {
                        HRUtil.splitString(map.toString(), et_show_msg);
                    }
                }
                break;
        }
    }

    private String getRandomOrderId(String number) {
        number += random.nextInt(10);
        if (number.length() < 6) {
            return getRandomOrderId(number);
        }
        return number;
    }

}
