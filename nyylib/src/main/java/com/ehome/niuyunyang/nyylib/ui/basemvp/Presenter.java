package com.ehome.niuyunyang.nyylib.ui.basemvp;

/**
 * Created by NewYyoung on 2017/4/11.
 */
//基础业务处理类接口
public interface Presenter<V extends  MvpView>{
    //每一个业务处理类需要绑定一个mvpView
     void attachView(V mvpView);
    //解除绑定
     void detachView();
}
