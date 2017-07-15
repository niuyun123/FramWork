package com.ehome.niuyunyang.nyylib.widget.list_grid_view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 描述：根据内容自适应高度的表格
 * com.ijia.framework.view.component </br>
 * Created by 兰云梁 on 2015/11/30.
 */
public class AutoHeightGridView extends GridView {

    boolean isAutoHight = true;
    boolean isMeasure = false;


    public AutoHeightGridView(Context context) {
        super(context);
    }

    public AutoHeightGridView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public AutoHeightGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        isMeasure = true;

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

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        isMeasure = false;
        super.onLayout(changed, l, t, r, b);

    }

    public boolean isAutoHight() {
        return isAutoHight;
    }

    public void setIsAutoHight(boolean isAutoHight) {

        this.isAutoHight = isAutoHight;
        this.requestLayout();
    }

    public boolean isMeasure() {
        return isMeasure;
    }

}
