package com.ehome.niuyunyang.nyylib.widget.list_grid_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 描述：根据内容自适应高度的列表
 * com.ijia.framework.view.component </br>
 * Created by 兰云梁 on 2015/10/16.
 */
public class AutoHeightListView extends ListView {

    boolean isAutoHight = true;

    public AutoHeightListView(Context context) {
        super(context);
    }

    public AutoHeightListView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public AutoHeightListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        ViewGroup.LayoutParams params = this.getLayoutParams();
//        if(params.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
//            isAutoHight = true;
//        }
//        else{
//            isAutoHight = false;
//        }


        if(isAutoHight) {
            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                    MeasureSpec.AT_MOST);

            setOverScrollMode(OVER_SCROLL_NEVER);
            super.onMeasure(widthMeasureSpec, expandSpec);
            return;
        }

        setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public boolean isAutoHight() {
        return isAutoHight;
    }

    public void setIsAutoHight(boolean isAutoHight) {

        this.isAutoHight = isAutoHight;
        this.requestLayout();
    }
}
