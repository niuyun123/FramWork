package com.ehome.niuyunyang.nyylib.ui.basemvp;

import android.view.View;

/**
 * Created by NewYyoung on 2017/4/11.
 */
//业务逻辑的基本回调;继承该接口实现每个界面相对因的回调
public interface MvpView {
    //数据加载
    void showLoading(String msg);
   //数据加载结束
    void hideLoading();
    //数据加载错误
    void showError(String msg, View.OnClickListener onClickListener);
   //数据为空
    void showEmpty(String msg, View.OnClickListener onClickListener);
   //网络错误
    void showEmpty(String msg, View.OnClickListener onClickListener, int imageId);
}
