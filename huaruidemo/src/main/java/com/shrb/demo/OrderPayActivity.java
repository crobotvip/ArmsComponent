package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.shrb.hrsdk.sdk.HRSDK;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import constant.Constant;
import util.HRUtil;

/**
 * Created by user on 2016/11/30.
 */

public class OrderPayActivity extends Activity implements View.OnClickListener {

    private EditText et_product_name;
    private EditText et_order_id;
    private EditText et_random_number;
    private EditText et_sku;
    private EditText et_spu;
    private EditText et_order_total;
    Random random = new Random();
    private static EditText et_show_msg;
    private int payType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        findViewById(R.id.tv_back).setOnClickListener(this);
        findViewById(R.id.tv_pay).setOnClickListener(this);
        payType = getIntent().getIntExtra("payType", HRSDK.PAY_JSH);
        et_product_name = (EditText) findViewById(R.id.et_product_name);
        et_order_id = (EditText) findViewById(R.id.et_order_id);
        et_random_number = (EditText) findViewById(R.id.et_random_number);
        et_sku = (EditText) findViewById(R.id.et_sku);
        et_spu = (EditText) findViewById(R.id.et_spu);
        et_order_total = (EditText) findViewById(R.id.et_order_total);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        et_product_name.setText("铂金钻戒");
        et_order_id.setText(getRandomOrderId(""));
        et_random_number.setText("123456");
    }

    private String getRandomOrderId(String number) {
        number += random.nextInt(10);
        if (number.length() < 6) {
            return getRandomOrderId(number);
        }
        return number;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_pay:
                if (et_product_name.getText().toString().length() == 0) {
                    Toast.makeText(this, "请先输入产品名称", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_order_id.getText().toString().length() == 0) {
                    Toast.makeText(this, "请先输入订单号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_random_number.getText().toString().length() == 0) {
                    Toast.makeText(this, "请先输入随机数", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_random_number.getText().toString().length() == 0) {
                    Toast.makeText(this, "请先输入随机数", Toast.LENGTH_SHORT).show();
                    return;
                }
                String outTradeNo = et_order_id.getText().toString().trim();
                String body = et_product_name.getText().toString().trim();
                String random = et_random_number.getText().toString().trim();
                String totalFee = et_order_total.getText().toString().trim().length() == 0 ? "100" : et_order_total.getText().toString().trim();
                String sku = et_sku.getText().toString().trim();
                String spu = et_spu.getText().toString().trim();
                String mchName = "珠宝商城";
                String detail = "3克拉，￥200000，舒适";
                String confirmOrder = "N";
                String attach = "attach附加数据";
                String limitPay = "01";
                String feeType = "CNY";
                String goodsTag = "WXG";
                String timeValid = "120";
                String deviceInfo = "34234234";
                String key = Constant.secureKey;
                String mchID = Constant.mchID;
                Map callbackMap = new HashMap();
                Map autoFillMap = new HashMap();
                Constant.outTradeNo = outTradeNo;
                HRSDK.Pay.orderPay(mchName, outTradeNo, body, detail, random, HRUtil.signOrderPay(MainActivity.getAppID(), body, mchID, outTradeNo, totalFee, random, key), attach, confirmOrder,
                        totalFee, limitPay, feeType, goodsTag, timeValid, deviceInfo, sku, spu, autoFillMap, callbackMap, payType, this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case HRSDK.METHOD_PAY:
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
