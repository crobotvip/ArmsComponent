package me.jessyan.armscomponent.app.di.module;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.scope.ActivityScope;

import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import me.jessyan.armscomponent.app.mvp.contract.GuideContract;
import me.jessyan.armscomponent.app.mvp.model.GuideModel;
import me.jessyan.armscomponent.commonsdk.core.RouterHub;


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
@Module
public abstract class GuideModule {

    @Binds
    abstract GuideContract.Model bindGuideModel(GuideModel model);


}