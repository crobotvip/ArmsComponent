package me.jessyan.armscomponent.demo.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import me.jessyan.armscomponent.demo.di.module.DemoModule;
import me.jessyan.armscomponent.demo.mvp.contract.DemoContract;

import com.jess.arms.di.scope.ActivityScope;

import me.jessyan.armscomponent.demo.mvp.ui.activity.DemoActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/18/2019 15:38
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = DemoModule.class, dependencies = AppComponent.class)
public interface DemoComponent {
    void inject(DemoActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        DemoComponent.Builder view(DemoContract.View view);

        DemoComponent.Builder appComponent(AppComponent appComponent);

        DemoComponent build();
    }
}