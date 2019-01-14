package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.shrb.hrsdk.sdk.HRSDK;

import java.util.HashMap;

import constant.Constant;
import util.HRUtil;

/**
 * Created by user on 2017/7/25.
 */

public class ScanCodeActivity extends Activity implements View.OnClickListener {
    private EditText et_show_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_scan_qrcode).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_scan_qrcode:
                HRSDK.Pay.scanQRCodePay(Constant.secureKey, this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case HRSDK.METHOD_SCAN_QRCODE_PAY:
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
