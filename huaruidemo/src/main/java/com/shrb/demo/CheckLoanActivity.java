package com.shrb.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.shrb.hrsdk.sdk.HRSDK;
import com.shrb.hrsdk.util.HRResponse;

import java.util.HashMap;
import java.util.Map;

import util.HRUtil;

/**
 * Created by user on 2016/11/30.
 */

public class CheckLoanActivity extends Activity implements View.OnClickListener {
    private EditText et_show_msg;
    private EditText et_identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_loan);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_check).setOnClickListener(this);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        et_identity = (EditText) findViewById(R.id.et_identity);
        et_identity.setText("52222319941125425X");
    }

    //是否绑过卡
    private void getLoan(String idNumber) {
        HRSDK.Loan.checkHasLoan(idNumber, new HRResponse() {

            @Override
            public void response(Object obj) {
                Map responseMap = (Map) obj;
                HRUtil.splitString(responseMap.toString(), et_show_msg);
                Log.e("是否授信", responseMap.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_check:
                String identity = et_identity.getText().toString().trim();
                if (identity.length() != 0 && !(identity.length() == 15 || identity.length() == 18)) {
                    Toast.makeText(this, "身份证号码不正确", Toast.LENGTH_SHORT).show();
                }
                getLoan(identity);
                break;
        }
    }
}
