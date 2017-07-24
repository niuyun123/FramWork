package com.ehome.niuyunyang.framework.testPhoterpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.photopicker.PhotoPicker;
import com.ehome.niuyunyang.nyylib.photopicker.PhotoPreview;
import com.ehome.niuyunyang.nyylib.util.log.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main19Activity extends AppCompatActivity {

    @BindView(R.id.ivpicker)
    ImageView ivpicker;
    private List<String> selectedPhotos=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ivpicker)
    public void onViewClicked() {
        PhotoPicker.builder().setGridColumnCount(4)
                .setPhotoCount(9)
                .setShowCamera(true)
                .setShowGif(true)
                .setPreviewEnabled(true)
                .start(Main19Activity.this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK &&
                (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {

            List<String> photos = null;
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
            }
            selectedPhotos.clear();

            if (photos != null) {

                selectedPhotos.addAll(photos);
            }
            LogUtil.json(selectedPhotos);
            Glide.with(this).load(selectedPhotos.get(0)).into(ivpicker);
        }
    }
}
