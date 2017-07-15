package com.ehome.niuyunyang.nyylib.widget.popupwindow.basepopup;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ehome.niuyunyang.nyylib.util.DisplayUtil;

/**
 * Created by NewYyoung on 2017/7/6.
 * version 2.8
 */

public class PopupWindowMaker {
    private int layoutId;//指定布局的ID
    private boolean isAutoSize;//自适应布局的大小
    private int height;//指定布局高
    private int weidth;//指定布局宽
    private boolean outsidetouchable;//是否能点击外部消失
    private View anchorView;//指定的锚点view
    private PopupWindow popupWindow;
    private Context context;
    private Gravity location;//显示的位置,目前默认
    private View contentView;

    public enum Gravity{
        LEFT,TOP,RIGHT,BOTTOM,
    }
    public static class  PopupWindowBuilder{
        private int layoutId;//指定布局的ID
        private boolean isAutoSize;//自适应布局的大小
        private int height=0;//指定布局高
        private int weidth=0;//指定布局宽
        private View anchorView;//显示在指定的view处
        private boolean outsidetouchable;//是否能点击外部消失

        public PopupWindowBuilder() {
        }

        public PopupWindowBuilder  LayoutId(int layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        public PopupWindowBuilder  AutoSize(boolean autoSize) {
            this.isAutoSize = autoSize;
            return this;
        }

        public PopupWindowBuilder  Height(int height) {
            this.height = height;
            return this;
        }

        public PopupWindowBuilder  Weidth(int weidth) {
            this.weidth = weidth;
            return this;
        }

        public PopupWindowBuilder  AnchorView(View anchorView) {
            this.anchorView = anchorView;
            return this;
        }

        public PopupWindowBuilder  Outsidetouchable(boolean outsidetouchable) {
            this.outsidetouchable = outsidetouchable;
            return this;
        }
        public PopupWindowMaker builder(){

            return new PopupWindowMaker(this);
        }
    }
    private PopupWindowMaker(PopupWindowBuilder builder){
        this.layoutId=builder.layoutId;
        this.isAutoSize=builder.isAutoSize;
        this.weidth=builder.weidth;
        this.height=builder.height;
        this.anchorView=builder.anchorView;
        this.outsidetouchable=builder.outsidetouchable;
        context = anchorView.getContext();
        contentView = LayoutInflater.from(context).inflate(layoutId, null);
        contentView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
        if (isAutoSize){
           popupWindow=new PopupWindow(contentView, contentView.getMeasuredWidth(), contentView.getMeasuredHeight());
        }else {
            if (weidth==0&&height==0){
                popupWindow=new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            }else {
                int mwidth=LinearLayout.LayoutParams.WRAP_CONTENT;
                int mheight=LinearLayout.LayoutParams.WRAP_CONTENT;
                if (weidth!=0){
                    mwidth=weidth;
                }
                if (height!=0){
                    mheight=height;
                }
                popupWindow=new PopupWindow(contentView, DisplayUtil.dip2px(context,mwidth), DisplayUtil.dip2px(context,mheight));
            }
        }
        if (outsidetouchable){
            //  OutsideTouchable设置生效的前提是 Touchable(true)和 Focusable(false)
            popupWindow.setOutsideTouchable(true);

            // 设置为true之后，PopupWindow内容区域 才可以响应点击事件
            popupWindow.setTouchable(true);

            // true时，点击返回键先消失 PopupWindow
            // 但是设置为true时 OutsideTouchable， Touchable方法就失效了（点击外部不消失，内容区域也不响应事件）
            // false时PopupWindow不处理返回键
            popupWindow.setFocusable(false);
            popupWindow.setTouchInterceptor(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;   // 这里面拦截不到返回键
                }
            });
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable());

    }
    public void showlocation(Gravity gravity){
        //显示在父控件的具体位置
        int[] location=new int[2];
        //在整个屏幕的位置
        anchorView.getLocationOnScreen(location);
        //在除去标题栏的窗口位置
       // anchorView.getLocationInWindow(location);
         switch (gravity){
             case TOP:
                 //在整个窗口的某一个点显示
                 //popupWindow.showAtLocation(anchorView, Gravity.CENTER,0,0);
                 if (contentView.getMeasuredWidth()-anchorView.getWidth()>0){

                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]-(contentView.getMeasuredWidth()-anchorView.getWidth())/2,location[1]-contentView.getMeasuredHeight()- DisplayUtil.dip2px(context,8));

                 }if (contentView.getMeasuredWidth()-anchorView.getWidth()==0){
                 popupWindow.showAtLocation(anchorView,android.view.Gravity.NO_GRAVITY,location[0],location[1]-contentView.getMeasuredHeight()- DisplayUtil.dip2px(context,8));
             }
                 if (contentView.getMeasuredWidth()-anchorView.getWidth()<0){
                     popupWindow.showAtLocation(anchorView,android.view.Gravity.NO_GRAVITY,location[0]+(anchorView.getWidth()-contentView.getMeasuredWidth())/2,location[1]+anchorView.getHeight()+DisplayUtil.dip2px(context,8));
                 }
                 break;
             case RIGHT:
                 if (contentView.getMeasuredHeight()-anchorView.getHeight()>0){
                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]+anchorView.getWidth()+DisplayUtil.dip2px(context,8),location[1]-(contentView.getMeasuredHeight()-anchorView.getHeight())/2);
                 }
                 if (contentView.getMeasuredHeight()-anchorView.getHeight()==0){
                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]+anchorView.getWidth()+DisplayUtil.dip2px(context,8),location[1]);

                 }
                 if (contentView.getMeasuredHeight()-anchorView.getHeight()<0){
                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]+anchorView.getWidth()+DisplayUtil.dip2px(context,8),-(contentView.getMeasuredHeight()-anchorView.getHeight())/2+location[1]);

                 }
                 break;
             case BOTTOM:
                 if (contentView.getMeasuredWidth()-anchorView.getWidth()>0){

                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]-(contentView.getMeasuredWidth()-anchorView.getWidth())/2,location[1]+anchorView.getHeight()+DisplayUtil.dip2px(context,8));

                 }if (contentView.getMeasuredWidth()-anchorView.getWidth()==0){
                 popupWindow.showAtLocation(anchorView,android.view.Gravity.NO_GRAVITY,location[0],location[1]-contentView.getMeasuredHeight()- DisplayUtil.dip2px(context,8));
             }
                 if (contentView.getMeasuredWidth()-anchorView.getWidth()<0){
                     popupWindow.showAtLocation(anchorView,android.view.Gravity.NO_GRAVITY,location[0]+(anchorView.getWidth()-contentView.getMeasuredWidth())/2,location[1]+anchorView.getHeight()+DisplayUtil.dip2px(context,8));
                 }
                 break;
             case LEFT:
                 if (contentView.getMeasuredHeight()-anchorView.getHeight()>0){
                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]-contentView.getMeasuredWidth()-DisplayUtil.dip2px(context,8),location[1]-(contentView.getMeasuredHeight()-anchorView.getHeight())/2);
                 }
                 if (contentView.getMeasuredHeight()-anchorView.getHeight()==0){
                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]-contentView.getMeasuredWidth()-DisplayUtil.dip2px(context,8),location[1]);

                 }
                 if (contentView.getMeasuredHeight()-anchorView.getHeight()<0){
                     popupWindow.showAtLocation(anchorView, android.view.Gravity.NO_GRAVITY,location[0]-contentView.getMeasuredWidth()-DisplayUtil.dip2px(context,8),-(contentView.getMeasuredHeight()-anchorView.getHeight())/2+location[1]);

                 }
                 break;
         }
    };
    public static  PopupWindowBuilder builder(){
        return new PopupWindowBuilder();
    };
    public void showlocationcustome(int gravity,int offX,int offY){
        popupWindow.showAtLocation(anchorView,gravity,offX,offY);
    }
    public void showAsDropDown(int gravit ,int offX,int offY){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            popupWindow.showAsDropDown(anchorView,offX,offY,gravit);
        }
    }
    public View getContentView(){
        return contentView;
    }
    
}
