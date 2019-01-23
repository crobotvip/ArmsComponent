package me.jessyan.armscomponent.app.mvp.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIPagerAdapter;

import me.jessyan.armscomponent.app.R;

public class GuideAdapter extends QMUIPagerAdapter {


    int[] mids=null;
    public GuideAdapter(int... id) {
        mids=id;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mids.length;
    }



    @Override
    protected Object hydrate(ViewGroup container, int position) {
        return new ItemView(container.getContext());
    }

    @Override
    protected void populate(ViewGroup container, Object item, int position) {
        ItemView itemView = (ItemView) item;
        itemView.setImage(mids[position]);
        container.addView(itemView);
    }

    @Override
    protected void destroy(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    static class ItemView extends FrameLayout {
        private ImageView mTextView;

        public ItemView(Context context) {
            super(context);
            mTextView = new ImageView(context);
            mTextView.setScaleType(ImageView.ScaleType.FIT_XY);

//            mTextView.setBackgroundColor(ContextCompat.getColor(context, R.color.qmui_config_color_white));
//            int size = QMUIDisplayHelper.dp2px(context, 300);
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            lp.gravity = Gravity.CENTER;
            addView(mTextView, lp);
        }

        public void setImage(int id) {
            mTextView.setImageResource(id);
        }
    }
}
