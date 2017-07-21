package com.ehome.niuyunyang.nyylib.ui.basemvp;

import android.app.Activity;
import android.content.Context;

/**
 * Created by NewYyoung on 2017/4/11.
 */
//业务逻辑基本的实现类,创建对应的业务逻辑需要集成该类实现方法.
public class BasePresenter<V extends MvpView> implements Presenter<V>{
    public V mMvpView;//需要绑定的view
    public Context mContext;
    @Override
    public void attachView(V mvpView) {
       if (mvpView!=null){
           mMvpView=mvpView;
           if (mvpView instanceof Activity){
               mContext= ((Activity) mvpView).getBaseContext();
           }
       }
    }

    @Override
    public void detachView() {
           mMvpView=null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }
   //获取绑定的view
    public V getMvpView() {
        return mMvpView;
    }
    //判断是否绑定view
    public void checkViewAttached() {
        if (!isViewAttached()){
            throw new  MvpViewNotAttachedException();
        }
    }
    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
