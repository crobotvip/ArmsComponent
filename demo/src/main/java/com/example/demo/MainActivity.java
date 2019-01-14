package com.example.demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;
import me.jessyan.armscomponent.commonsdk.utils.Utils;
@Route(path = RouterHub.TEST_MAINACTIVITY)
public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_skip)
    TextView tv_skip;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);

            }

            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {

            }
        });
        //                        Utils.navigation(getBaseContext(), RouterHub.TEST_CHANGESKINACTIVITY);
        adapter = new RecyclerView.Adapter() {
              @NonNull
              @Override
              public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                  TextView textView=new TextView(getBaseContext());
                  textView.setBackgroundColor(Color.GRAY);
                  textView.setGravity(Gravity.CENTER);

                  textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,200));
                  RecyclerView.ViewHolder viewHolder=new RecyclerView.ViewHolder(textView){};
                  textView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          switch (i){
                              case 0:
                                  Utils.navigation(getBaseContext(), RouterHub.TEST_CHANGESKINACTIVITY);

                                  break;
                              case 1:
                                  break;
                              case 2:
                                  break;
                              case 3:
                                  break;
                              case 4:
                                  break;
                              case 5:
                                  break;
                              case 6:
                                  break;
                              case 7:
                                  break;
                          }
                      }
                  });

                  return   viewHolder;
              }

              @Override
              public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                  TextView textView=((TextView)viewHolder.itemView);
                  switch (i){
                      case 0:
                          textView.setText("更换皮肤");
  //                        Utils.navigation(getBaseContext(), RouterHub.TEST_CHANGESKINACTIVITY);

                          break;
                      case 1:
                          break;
                      case 2:
                          break;
                      case 3:
                          break;
                      case 4:
                          break;
                      case 5:
                          break;
                      case 6:
                          break;
                      case 7:
                          break;
                  }

              }

              @Override
              public int getItemCount() {
                  return 100;
              }
          };
        recyclerView.setAdapter(adapter);




    }

    @OnClick({R.id.tv_skip})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_skip:
                Utils.navigation(MainActivity.this, RouterHub.GOLD_HOMEACTIVITY);
                break;

        }
    }
}
