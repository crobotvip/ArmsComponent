package me.jessyan.armscomponent.commonres.utils;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by peng.luo on 2019/1/2.
 */

public abstract class IconFont {

    /**
     * 设置字体颜色
     * @param textView
     * @param stringId
     */
    public static void setIconFont(TextView textView,int stringId){
        Typeface iconfont = Typeface.createFromAsset(textView.getContext().getAssets(), "iconfont/iconfont.ttf");
        textView.setText(stringId);
        textView.setTextColor(Color.GREEN);
        textView.setTypeface(iconfont);
    }

    public static void setIconFont(TextView textView){
        Typeface iconfont = Typeface.createFromAsset(textView.getContext().getAssets(), "iconfont/iconfont.ttf");
        textView.setTextColor(Color.GREEN);
        textView.setTypeface(iconfont);
    }
}
