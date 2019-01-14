package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.shrb.hrsdk.sdk.HRSDK;

import java.util.HashMap;
import java.util.Map;

import util.HRUtil;

/**
 * Created by user on 2016/12/21.
 */

public class LoanActivity extends Activity implements View.OnClickListener {
    private static EditText et_show_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_loan).setOnClickListener(this);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        TextView tv_title = (TextView) findViewById(R.id.tv_title);
        TextView tv_loan = (TextView) findViewById(R.id.tv_loan);
        tv_title.setText("极度贷");
        tv_loan.setText("极度贷");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_loan:
                Map callbackMap = new HashMap();
                Map extraMessage = new HashMap();
                HRSDK.Loan.loanManagement(extraMessage, callbackMap, this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case HRSDK.METHOD_LOAN:
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
