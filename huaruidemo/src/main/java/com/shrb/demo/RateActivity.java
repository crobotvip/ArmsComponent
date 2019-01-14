package com.shrb.demo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.shrb.entity.HRNews;
import com.shrb.hrsdk.sdk.HRSDK;
import com.shrb.hrsdk.util.HRResponse;

import java.util.Map;

import util.HRUtil;

/**
 * Created by user on 2017/6/22.
 */

public class RateActivity extends Activity implements View.OnClickListener {
    private EditText et_show_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_rate).setOnClickListener(this);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
    }

    private void rate() {
        HRSDK.Loan.getRate(new HRResponse() {
            @Override
            public void response(Object obj) {
                Map responseMap = (Map) obj;
                HRUtil.splitString(responseMap.toString(), et_show_msg);
                Log.e("存贷款利率", responseMap.toString());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_rate:
                rate();
                break;
        }

    }
}
