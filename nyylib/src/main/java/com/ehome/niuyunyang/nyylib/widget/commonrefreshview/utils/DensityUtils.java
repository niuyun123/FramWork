package com.ehome.niuyunyang.nyylib.widget.commonrefreshview.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * 日期：2016/2/1.19:25
 * <p/>
 * 作者：XuDiWei
 * <p/>
 * 描述：密度与单位转换工具
 */
public class DensityUtils {

    /**
     * dip转Px
     *
     * @param dip
     * @return
     */
    public static float dipToPx(Context context, int dip) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, context.getResources().getDisplayMetrics());
//        float density = context.getResources().getDisplayMetrics().density;
//        return (int) (density * dip + 0.5f);
    }

    /**
     * sp 转px
     *
     * @param context
     * @param sp
     * @return
     */
    public static float spToDx(Context context, int sp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}
