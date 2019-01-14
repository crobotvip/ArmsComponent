package com.shrb.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.shrb.entity.HRNews;
import com.shrb.entity.HRProduct;
import com.shrb.hrsdk.sdk.HRSDK;
import com.shrb.hrsdk.util.HRResponse;

import java.util.Map;

import util.HRUtil;

/**
 * Created by user on 2016/12/1.
 */

public class NewsDetailActivity extends Activity implements View.OnClickListener {
    private EditText et_show_msg;
    private HRNews news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        findViewById(R.id.tv_get_detail).setOnClickListener(this);
        findViewById(R.id.tv_back).setOnClickListener(this);
        et_show_msg = (EditText) findViewById(R.id.et_show_msg);
        news = (HRNews) getIntent().getSerializableExtra("news");
    }

    private void getDetail() {
        HRSDK.Loan.getNewsDetail(news.id, new HRResponse() {
            @Override
            public void response(Object obj) {
                Map responseMap = (Map) obj;
                HRUtil.splitString(responseMap.toString(), et_show_msg);
                Log.e("新闻详情", responseMap.toString());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            case R.id.tv_get_detail:
                getDetail();
                break;
        }
    }
}
