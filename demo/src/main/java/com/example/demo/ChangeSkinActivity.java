package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;

import me.jessyan.armscomponent.commonsdk.core.RouterHub;

@Route(path = RouterHub.TEST_CHANGESKINACTIVITY)
public class ChangeSkinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_skin);
    }
}
