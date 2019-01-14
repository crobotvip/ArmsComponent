package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.shrb.hrsdk.sdk.HRSDK;

import java.util.HashMap;
import java.util.Map;

import util.HRUtil;

/**
 * Created by user on 2016/12/1.
 */

public class BindCardActivity extends Activity implements View.OnClickListener {
    private static EditText et_show_msg;
    private EditText et_id_card;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_bank_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_card);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_bind_card).setOnClickListener(this);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_bank_number = (EditText) findViewById(R.id.et_bank_number);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_bind_card:
                String campaignUrl = "";
                Map extraMessage = new HashMap();
                Map checkData = new HashMap();
                if (et_name.getText().length() > 0) {
                    checkData.put("userName", et_name.getText().toString());
                }
                if (et_phone.getText().length() > 0) {
                    checkData.put("mobile", et_phone.getText().toString());
                    extraMessage.put("mobile", et_phone.getText().toString());
                }
                if (et_bank_number.getText().length() > 0) {
                    extraMessage.put("cardNo", et_bank_number.getText().toString());
                }
                extraMessage.put("checkData", checkData);
                HRSDK.Users.bindCard(campaignUrl, extraMessage, this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case HRSDK.METHOD_BIND_CARD:
                if (resultCode == RESULT_OK) {
                    HashMap map = (HashMap) data.getSerializableExtra("data");
                    if (map != null) {
                        HRUtil.splitString(map.toString(), et_show_msg);
                    }
                }
                break;
        }
    }
}
