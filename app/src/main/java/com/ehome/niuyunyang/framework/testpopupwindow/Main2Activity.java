package com.ehome.niuyunyang.framework.testpopupwindow;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.util.DisplayUtil;
import com.ehome.niuyunyang.nyylib.widget.popupwindow.basepopup.PopupWindowMaker;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.showpop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // initpopupWindow(v);
                //构造这模式创建的Popupwindow
                PopupWindowMaker.builder().LayoutId(R.layout.popup_menu).AutoSize(true).AnchorView(v)
                        .Outsidetouchable(true).builder().showlocation(PopupWindowMaker.Gravity.LEFT);
            }
        });
    }
   private PopupWindow initpopupWindow(View anchView){
       View contentView = LayoutInflater.from(this).inflate(R.layout.popup_menu, null);
       contentView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
       anchView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);
       PopupWindow popupWindow = new PopupWindow(contentView, contentView.getMeasuredWidth(), contentView.getMeasuredHeight());
       popupWindow.setBackgroundDrawable(new ColorDrawable());
       // setOutsideTouchable设置生效的前提是setTouchable(true)和setFocusable(false)
       popupWindow.setOutsideTouchable(true);
       // 设置为true之后，PopupWindow内容区域 才可以响应点击事件
       popupWindow.setTouchable(true);
       popupWindow.setFocusable(false);
       //正下方显示两个控件以垂直线性布局展示

      // popupWindow.showAsDropDown(anchView);
       //显示在父控件的具体位置
       int[] location=new int[2];
       //在整个屏幕的位置
       anchView.getLocationOnScreen(location);
       //在除去标题栏的窗口位置
       anchView.getLocationInWindow(location);
       //在整个窗口的某一个点显示
       //popupWindow.showAtLocation(anchView, Gravity.CENTER,0,0);
       if (contentView.getMeasuredWidth()-anchView.getWidth()>0){
           Log.e("Main2Activity"+":"+"initpopupWindow","======YUNYANG====="+"contentView.getMeasuredWidth()-anchView.getMeasuredWidth()"+contentView.getMeasuredWidth()+"--"+anchView.getWidth());

           popupWindow.showAtLocation(anchView,Gravity.NO_GRAVITY,location[0]-(contentView.getMeasuredWidth()-anchView.getWidth())/2,location[1]-contentView.getMeasuredHeight()- DisplayUtil.dip2px(this,8));

       }if (contentView.getMeasuredWidth()-anchView.getWidth()==0){
           popupWindow.showAtLocation(anchView,Gravity.RIGHT,location[0],location[1]-contentView.getMeasuredHeight()- DisplayUtil.dip2px(this,8));
       }
       if (contentView.getMeasuredWidth()-anchView.getWidth()<0){
           popupWindow.showAtLocation(anchView,Gravity.NO_GRAVITY,location[0]+(anchView.getWidth()-contentView.getMeasuredWidth())/2,location[1]-contentView.getMeasuredHeight()- DisplayUtil.dip2px(this,8));
       }
      // popupWindow.showAsDropDown(anchView,-200,0, Gravity.RIGHT);
       return popupWindow;
   }
}
