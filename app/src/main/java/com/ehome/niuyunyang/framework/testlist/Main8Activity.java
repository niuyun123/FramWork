package com.ehome.niuyunyang.framework.testlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.widget.commonrefreshview.DWRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main8Activity extends AppCompatActivity {

    @BindView(R.id.fresh)
    DWRefreshLayout fresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ButterKnife.bind(this);

    }
}
