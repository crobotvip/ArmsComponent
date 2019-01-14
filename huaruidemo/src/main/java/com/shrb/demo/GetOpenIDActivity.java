package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shrb.hrsdk.sdk.HRSDK;
import com.shrb.hrsdk.util.HRResponse;

import java.util.HashMap;
import java.util.Map;

import util.HRUtil;

/**
 * Created by user on 2016/12/1.
 */

public class GetOpenIDActivity extends Activity implements View.OnClickListener {
    private static EditText et_show_msg;
    private TextView tv_title;
    private TextView tv_bind_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_card);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_bind_card = (TextView) findViewById(R.id.tv_bind_card);
        findViewById(R.id.ll_name).setVisibility(View.GONE);
        findViewById(R.id.ll_phone).setVisibility(View.GONE);
        findViewById(R.id.ll_bank_number).setVisibility(View.GONE);
        tv_title.setText("获取OpenID");
        tv_bind_card.setText("获取OpenID");
        findViewById(R.id.tv_back).setOnClickListener(this);
        tv_bind_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_bind_card:
                HRSDK.getOpenID(new HRResponse() {
                    @Override
                    public void response(Object obj) {
                        HRUtil.splitString((String) obj, et_show_msg);
                        Toast.makeText(GetOpenIDActivity.this, "获取到的openID：" + obj, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

}
