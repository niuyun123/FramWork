package com.ehome.niuyunyang.framework.testxmldimen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.util.DisplayUtil;

public class Main0Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.text);
        text.setLayoutParams(new RelativeLayout.LayoutParams(DisplayUtil.getXMLdimen(this,R.dimen.x200),
                DisplayUtil.getXMLdimen(this,R.dimen.x300)));

    }
}
