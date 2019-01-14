package com.shrb.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.shrb.entity.HRNews;
import com.shrb.hrsdk.sdk.HRSDK;
import com.shrb.hrsdk.util.HRResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2016/11/22.
 */

public class NewsListActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView lv_news;
    private List<HRNews> newsList = new ArrayList<>();
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        getNewsList("1", "999");
        lv_news = (ListView) findViewById(R.id.lv_news);
        newsAdapter = new NewsAdapter();
        lv_news.setAdapter(newsAdapter);
        lv_news.setOnItemClickListener(this);
        findViewById(R.id.tv_back).setOnClickListener(this);
    }

    //新闻列表
    private void getNewsList(String pageNo, String pageSize) {
        HRSDK.Loan.getNewsList(pageNo, pageSize, new HRResponse() {

            @Override
            public void response(Object obj) {
                Map responseMap = (Map) obj;
                Log.e("新闻列表:", responseMap.toString());
                if ("999999".equals(responseMap.get("returnCode"))) {
                    Toast.makeText(NewsListActivity.this, "" + responseMap.get("returnMsg"), Toast.LENGTH_SHORT).show();
                    return;
                }
                Object list = responseMap.get("body");
                if (list != null) {
                    newsList = JSON.parseArray(list.toString(), HRNews.class);
                    newsAdapter.updateData(newsList);
                } else {
                    Toast.makeText(NewsListActivity.this, "暂无新闻", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("news", newsAdapter.getItem(position));
        intent.setClass(this, NewsDetailActivity.class);
        startActivity(intent);
    }

    class NewsAdapter extends BaseAdapter {
        List<HRNews> newsList = new ArrayList<>();

        public void updateData(List<HRNews> newsList) {
            this.newsList = newsList;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return newsList.size();
        }

        @Override
        public HRNews getItem(int position) {
            return newsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(NewsListActivity.this).inflate(R.layout.item_product, parent, false);
            TextView tv_product = (TextView) view.findViewById(R.id.tv_product);
            HRNews item = getItem(position);
            StringBuffer buffer = new StringBuffer();
            buffer.append("id:" + item.id + "\n");
            buffer.append("author:" + item.author + "\n");
            buffer.append("title:" + item.title.substring(0, 15) + "\n");
            buffer.append("time:" + item.time + "\n");
            tv_product.setText(buffer.toString());
            return view;
        }
    }
}
