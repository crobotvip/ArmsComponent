package me.jessyan.armscomponent.commonres.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.mvp.IPresenter;

import me.jessyan.armscomponent.commonres.utils.IconFont;

/**
 * Created by peng.luo on 2019/1/2.
 */

public abstract class EasyActivity<P extends IPresenter> extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory()
        {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs)
            {
                AppCompatDelegate delegate = getDelegate();
                View view = delegate.createView(parent, name, context, attrs);

                if ( view!= null && (view instanceof TextView))
                {
                    IconFont.setIconFont((TextView) view);
                }
                return view;
            }
        });
        super.onCreate(savedInstanceState);
    }
}
