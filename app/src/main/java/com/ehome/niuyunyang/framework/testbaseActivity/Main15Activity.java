package com.ehome.niuyunyang.framework.testbaseActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.ui.activitty.BaseAppCompatActivity;
import com.ehome.niuyunyang.nyylib.util.netstatus.NetUtils;
import com.ehome.niuyunyang.nyylib.widget.LoadingLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main15Activity extends BaseAppCompatActivity {


    @BindView(R.id.tvbackground)
    TextView tvbackground;


    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main15;
    }

    @Override
    protected void initViewsAndEvents() {
        ButterKnife.bind(this);
        //tvbackground.setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {
        final LoadingLayout loadingLayout = LoadingLayout.wrap(tvbackground);
        loadingLayout.setErrorImage(R.drawable.ic_google_messenger_icon);
        loadingLayout.setErrorText("网络连接异常请重试");
        loadingLayout.setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "网络连接", Toast.LENGTH_SHORT).show();
                loadingLayout.showContent();
            }
        });
        loadingLayout.showError();
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected int setDefaultStatusBarColor() {
        return 0;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.TOP;
    }


}
