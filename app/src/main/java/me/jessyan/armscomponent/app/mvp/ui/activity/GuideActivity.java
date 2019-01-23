package me.jessyan.armscomponent.app.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.armscomponent.app.di.component.DaggerGuideComponent;
import me.jessyan.armscomponent.app.mvp.contract.GuideContract;
import me.jessyan.armscomponent.app.mvp.presenter.GuidePresenter;

import me.jessyan.armscomponent.app.R;
import me.jessyan.armscomponent.app.mvp.ui.adapter.GuideAdapter;
import me.jessyan.armscomponent.commonres.utils.Anim;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;
import me.jessyan.armscomponent.commonsdk.utils.Utils;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/18/2019 15:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Route(path = RouterHub.APP_GUIDEACTIVITY)
public class GuideActivity extends BaseActivity<GuidePresenter> implements GuideContract.View {

    @BindView(R.id.qmuiViewPager)
    QMUIViewPager qmuiViewPager;
    @BindView(R.id.btn_open)
    QMUIButton btn_open;




    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerGuideComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_guide; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {


        GuideAdapter guideAdapter=new GuideAdapter(R.mipmap.flower,R.mipmap.ice,R.mipmap.river,R.mipmap.night);
        qmuiViewPager.setInfiniteRatio(500);
//        qmuiViewPager.setEnableLoop(true);
        qmuiViewPager.setAdapter(guideAdapter);
        qmuiViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(guideAdapter.getCount()-1==i){

                    btn_open.setVisibility(View.VISIBLE);

                }else {
                    btn_open.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @OnClick(R.id.btn_open)
    void click(View view)
    {
        Utils.navigation(this, RouterHub.USER_LOGINACTIVITY);

    }
}
