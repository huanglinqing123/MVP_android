package mvp.com.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import mvp.com.widget.TitleBar;


/**
 * Created by huanglinqing on 2018/3/16.
 */

public abstract class BaseActivity extends Activity {

    public TitleBar titleBar;
    public Activity mActivity;

    private final static int RUNTIME_PERMISSION_REQUEST_CODE = 0x1;



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        mActivity = this;

        boolean isImmersive = false;
        if (hasKitKat() && !hasLollipop()) {
            isImmersive = true;
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
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

//    public void ChoosePhoto() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {//检查是否有写入SD卡的授权
//                Log.i(TAG, "granted permission!");
//                turnOnCamera();
//            } else {
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                    Log.i(TAG, "should show request permission rationale!");
//                }
//                requestPermission();
//            }
//        } else {
//            turnOnCamera();
//        }
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CapturePhotoHelper.CAPTURE_PHOTO_REQUEST_CODE) {
//            File photoFile = null;
//            try {
//                photoFile= mCapturePhotoHelper.getPhoto();
//                if (photoFile != null) {
//                    if (resultCode == RESULT_OK) {
//                        int requestWidth = (int) (RuleUtils.getScreenWidth(this) * RATIO);
//                        int requestHeight = (int) (RuleUtils.getScreenHeight(this) * RATIO);
//                        Bitmap bitmap = BitmapUtils.decodeBitmapFromFile(photoFile, requestWidth, requestHeight);//按照屏幕宽高的3/4比例进行缩放显示
//                        if (bitmap != null) {
//                            int degree = BitmapUtils.getBitmapDegree(photoFile.getAbsolutePath());//检查是否有被旋转，并进行纠正
//                            if (degree != 0) {
//                                bitmap = BitmapUtils.rotateBitmapByDegree(bitmap, degree);
//                            }
//                            //缩放
//                            //Bitmap bitmapScale= ByScale(bitmap);
//                            //赋值
//                            onReturnBmp(bitmap);
//                            //updata
//                            UpdataImage(bitmap);
//                        }
//                    } else {
//                        if (photoFile.exists()) {
//                            photoFile.delete();
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }

//    public void UpdataImage(final Bitmap bitmapScale) {
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                byte[] byte1= ImageUtils.bitmap2Bytes(bitmapScale, Bitmap.CompressFormat.JPEG);
//                String base64= EncodeUtils.base64Encode2String(byte1);
//                FileApi authApi = ServiceFactory.createNewRetrofitService(FileApi.class,mActivity);
//                if (authApi != null) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            dialogInterface = DialogUIUtils.showLoading(mActivity, "正在上传", true, true, false, false).show();
//                        }
//                    });
//                    authApi.uploadimage_2(UpLoadImage.JPG,"fuck",base64)
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Subscriber<UploadImgRespData>() {
//                                @Override
//                                public void onCompleted() {
//
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//                                    DialogUIUtils.dismiss(dialogInterface);
//                                    DialogUIUtils.showToastLong("上传失败,请重新上传!");
//                                }
//
//                                @Override
//                                public void onNext(UploadImgRespData uploadImgRespData) {
//                                    DialogUIUtils.dismiss(dialogInterface);
//                                    if (uploadImgRespData.success) {
//                                        DialogUIUtils.showToastLong("上传成功!");
//                                        onUploadBmp(uploadImgRespData.data.imgurl);
//                                    }else {
//                                        DialogUIUtils.showToastLong(uploadImgRespData.msg);
//                                    }
//                                }
//                            });
//
//                }
//            }
//        }.start();
//    }

//    public Bitmap ByScale(Bitmap bitmap) {
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        Bitmap thumb = null;
//        if (width >= 1000) {
//            float scal = width / 1000;
//            int prineHeight = (int) (height / scal);
//            int prineWidth = (int) (width / scal);
//            thumb = ImageUtils.compressByScale(bitmap, prineWidth, prineHeight);
//        } else {
//            thumb = ImageUtils.compressByScale(bitmap, width, height);
//        }
//        return thumb;
//    }

// --Commented out by Inspection START (2018/5/23 15:48):
//    protected void onReturnBmp(Bitmap bitmap) {
//
//    }
// --Commented out by Inspection STOP (2018/5/23 15:48)

// --Commented out by Inspection START (2018/5/23 15:48):
//    protected void onUploadBmp(String imgUrl) {
//
//    }
// --Commented out by Inspection STOP (2018/5/23 15:48)

//    /**
//     * 开启相机
//     */
//    public void turnOnCamera() {
//        if (mCapturePhotoHelper == null) {
//            mCapturePhotoHelper = new CapturePhotoHelper(this, FolderManager.getPhotoFolder());
//        }
//        mCapturePhotoHelper.capture();
//    }

// --Commented out by Inspection START (2018/5/23 15:48):
//    /**
//     * 申请写入sd卡的权限
//     */
//    public void requestPermission() {
//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, RUNTIME_PERMISSION_REQUEST_CODE);
//    }
// --Commented out by Inspection STOP (2018/5/23 15:48)

//    @Override
//    protected void onResume() {
//        super.onResume();
//        MobclickAgent.onResume(this);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        MobclickAgent.onPause(this);
//    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    protected abstract int getLayoutId();
}
