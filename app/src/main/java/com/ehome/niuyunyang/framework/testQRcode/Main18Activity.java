package com.ehome.niuyunyang.framework.testQRcode;

import android.Manifest;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.qrcode.core.QRCodeView;
import com.ehome.niuyunyang.nyylib.qrcode.zxing.ZXingView;
import com.ehome.niuyunyang.nyylib.util.easypermissions.AfterPermissionGranted;
import com.ehome.niuyunyang.nyylib.util.easypermissions.EasyPermissions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main18Activity extends AppCompatActivity implements QRCodeView.Delegate ,EasyPermissions.PermissionCallbacks{
    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;

    @BindView(R.id.zxingview)
    ZXingView zxingview;
    private QRCodeView qrCodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        ButterKnife.bind(this);
        qrCodeView = zxingview;
        qrCodeView.setDelegate(this);
    }


    public void viblicator() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    protected void onStart() {
        super.onStart();
        qrCodeView.startCamera();
        qrCodeView.showScanRect();
        requestCodeQRCodePermissions();
    }
    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        qrCodeView.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        qrCodeView.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        viblicator();
        qrCodeView.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(this, "打开相机不错检查是否打开相机权限", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.start_spot, R.id.stop_spot, R.id.show_rect, R.id.hidden_rect, R.id.start_spot_showrect, R.id.stop_spot_hiddenrect, R.id.start_preview, R.id.stop_preview, R.id.scan_barcode, R.id.scan_qrcode, R.id.open_flashlight, R.id.close_flashlight, R.id.choose_qrcde_from_gallery})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_spot:
                qrCodeView.startSpot();
                break;
            case R.id.stop_spot:
                qrCodeView.stopSpot();
                break;
            case R.id.show_rect:
                qrCodeView.startSpotAndShowRect();
                break;
            case R.id.hidden_rect:
                qrCodeView.stopSpotAndHiddenRect();
                break;
            case R.id.start_spot_showrect:
                qrCodeView.showScanRect();
                break;
            case R.id.stop_spot_hiddenrect:
                qrCodeView.hiddenScanRect();
                break;
            case R.id.start_preview:
                qrCodeView.startCamera();
                break;
            case R.id.stop_preview:
                qrCodeView.stopCamera();
                break;
            case R.id.scan_barcode:

                break;
            case R.id.scan_qrcode:

                break;
            case R.id.open_flashlight:
                qrCodeView.openFlashlight();
                break;
            case R.id.close_flashlight:
                qrCodeView.closeFlashlight();
                break;
            case R.id.choose_qrcde_from_gallery:
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }
}
