package com.ehome.niuyunyang.framework.testQRcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.qrcode.zxing.QRCodeEncoder;
import com.ehome.niuyunyang.nyylib.util.DisplayUtil;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main17Activity extends AppCompatActivity {

    @BindView(R.id.ivchinese)
    ImageView ivchinese;
    @BindView(R.id.ivenglish)
    ImageView ivenglish;
    @BindView(R.id.ivchineselog)
    ImageView ivchineselog;
    @BindView(R.id.ivenglishlog)
    ImageView ivenglishlog;
    @BindView(R.id.tvchinese)
    Button tvchinese;
    @BindView(R.id.tvenglish)
    Button tvenglish;
    @BindView(R.id.tvchineselog)
    Button tvchineselog;
    @BindView(R.id.tvenglishlog)
    Button tvenglishlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        ButterKnife.bind(this);
        initialQRview();
    }

    private void initialQRview() {
        new AsyncTask(this).execute(0+"","牛云杨");
        new AsyncTask(this).execute(1+"","newyuang");
        new AsyncTask(this).execute(2+"","牛云杨");
        new AsyncTask(this).execute(3+"","newyuang");
    }

    @OnClick({R.id.tvchinese, R.id.tvenglish, R.id.tvchineselog, R.id.tvenglishlog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvchinese:
                break;
            case R.id.tvenglish:
                break;
            case R.id.tvchineselog:
                break;
            case R.id.tvenglishlog:
                break;
        }
    }
    public static  class  AsyncTask extends android.os.AsyncTask<String,Integer,Bitmap>{
        private final WeakReference<Main17Activity> mActivity;
          private int type;

        public AsyncTask(Main17Activity activity ) {
            this.mActivity =new WeakReference<Main17Activity>(activity);
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            type=Integer.parseInt(params[0]);
            Bitmap bitmap =  bitmap = QRCodeEncoder.syncEncodeQRCode(params[1], DisplayUtil.getXMLdimen(mActivity.get(), R.dimen.x160));
            Bitmap decodeResource = BitmapFactory.decodeResource(mActivity.get().getResources(), R.drawable.ic_google_maps_icon);
            switch (type){
                case 0:
                    bitmap = QRCodeEncoder.syncEncodeQRCode(params[1], DisplayUtil.getXMLdimen(mActivity.get(), R.dimen.x160));
                    break;
                case 1:
                    bitmap = QRCodeEncoder.syncEncodeQRCode(params[1], DisplayUtil.getXMLdimen(mActivity.get(), R.dimen.x160));
                    break;
                case 2:
                    bitmap = QRCodeEncoder.syncEncodeQRCode(params[1], DisplayUtil.getXMLdimen(mActivity.get(), R.dimen.x160), Color.BLACK, decodeResource );
                    break;
                case 3:
                    bitmap = QRCodeEncoder.syncEncodeQRCode(params[1], DisplayUtil.getXMLdimen(mActivity.get(), R.dimen.x160), Color.BLACK, decodeResource );
                    break;
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            switch (type){
                case 0 :
                    mActivity.get().ivchinese.setImageBitmap(bitmap);

                    break;
                case 1:
                    mActivity.get().ivenglish.setImageBitmap(bitmap);
                    break;
                case 2:
                    mActivity.get().ivchineselog.setImageBitmap(bitmap);
                    break;
                case 3:
                    mActivity.get().ivenglishlog.setImageBitmap(bitmap);
                    break;
            }
        }
    }
}
