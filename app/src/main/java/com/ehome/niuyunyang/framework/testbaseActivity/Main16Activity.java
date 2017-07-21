package com.ehome.niuyunyang.framework.testbaseActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.util.statusbar.SystemBarTintManager;
import com.ehome.niuyunyang.nyylib.widget.LoadingLayout;
import com.ehome.niuyunyang.nyylib.widget.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
 没用工具类设置沉溺式菜单
 */
public class Main16Activity extends AppCompatActivity {

    @BindView(R.id.tvcontent)
    TextView tvcontent;
    @BindView(R.id.title)
    TitleBar titleBar;
    private ImageView mCollectView;
    private boolean mIsSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main16);
        ButterKnife.bind(this);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.hide();
        // StatusBarUtil.setColor(this,Color.WHITE,150);
        //StatusBarCompat.setStatusBarColor(this,Color.WHITE,10);
        //setTranslucentStatus();
        final LoadingLayout wrap = LoadingLayout.wrap(tvcontent);
        wrap.setErrorImage(R.drawable.ic_google_messenger_icon);
        wrap.setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main16Activity.this, "retry!!", Toast.LENGTH_SHORT).show();
                wrap.showContent();
            }
        });
       // wrap.showError();

       setTranslucentStatus2();
        titleBar.setImmersive(true);
       // titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

       // titleBar.setLeftImageResource(R.mipmap.back_green);
       // titleBar.setLeftText("返回");
       // titleBar.setLeftTextColor(Color.WHITE);
       /* titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        titleBar.setTitle("文章详情\n副标题");
       /* titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);*/

       // titleBar.setActionTextColor(Color.WHITE);
      /*  mCollectView = (ImageView) titleBar.addAction(new TitleBar.ImageAction(R.mipmap.collect) {
            @Override
            public void performAction(View view) {
                Toast.makeText(Main16Activity.this, "点击了收藏", Toast.LENGTH_SHORT).show();
                mCollectView.setImageResource(R.mipmap.fabu);
                titleBar.setTitle(mIsSelected ? "文章详情\n朋友圈" : "帖子详情");
                mIsSelected = !mIsSelected;
            }
        });

        titleBar.addAction(new TitleBar.TextAction("发布") {
            @Override
            public void performAction(View view) {
                Toast.makeText(Main16Activity.this, "点击了发布", Toast.LENGTH_SHORT).show();
            }
        });*/
    }


    /**
     * 设置状态栏背景状态
     */
    private void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            //透明状态栏
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            win.setAttributes(winParams);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintColor(Color.WHITE);//状态栏无背景
        }
    }
    private void setTranslucentStatus2(){
        boolean isImmersive = false;
        if (hasKitKat() && !hasLollipop()) {
            isImmersive = true;
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else if (hasLollipop()) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            isImmersive = true;
        }
    }
    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
