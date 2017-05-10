package com.test;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.qxq.base.QxqBaseFragment;
import com.qxq.utils.ImageUtils;
import com.qxq.utils.QxqDialogUtil;

import java.io.File;

/**
 * 项目名称:QxqSDK
 * 创建人:覃湘泉
 * 创建时间:2017/4/17 11:33
 * 类描述:
 */
public class Fragment13 extends QxqBaseFragment {

    private Button mCombineCompress, mCompressBtn,mOriginalBtn,mAfterCompressBtn;
    private ImageView mImage;

    /** 图片存放根目录*/
    private final String mImageRootDir = Environment
            .getExternalStorageDirectory().getPath();

    @Override
    protected int setContentView() {
        return R.layout.fragment13;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initLayout(View view) {

        // 压缩后保存临时文件目录
        File tempFile = new File(mImageRootDir);
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }

        mCompressBtn = (Button) view.findViewById(R.id.compress_btn);
        mCombineCompress = (Button)  view.findViewById(R.id.size_quality_libjpeg_compress_btn);
        mAfterCompressBtn = (Button)  view.findViewById(R.id.after_compress_btn);
        mOriginalBtn = (Button)  view.findViewById(R.id.original_btn);
        mImage = (ImageView)  view.findViewById(R.id.image);


        mCompressBtn.setOnClickListener(this);
        mCombineCompress.setOnClickListener(this);
        mOriginalBtn.setOnClickListener(this);
        mAfterCompressBtn.setOnClickListener(this);

    }

    @Override
    public void initListener(View view) {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.compress_btn://直接jni libjpeg压缩

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        final File afterCompressImgFile = new File(mImageRootDir
                                + "/ttt2.jpg");

                        String tempCompressImgPath = mImageRootDir+File.separator+"ttt.png";//事先准备好的sd卡目录下的图片
                        //直接使用jni libjpeg压缩
                        Bitmap bitmap = BitmapFactory.decodeFile(tempCompressImgPath);
                        String codeString = ImageUtils.compressBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), 40, afterCompressImgFile.getAbsolutePath().getBytes(), true);
                        Log.e("code", "code "+codeString);

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mImage.setImageBitmap(BitmapFactory
                                        .decodeFile(afterCompressImgFile.getPath()));
                            }
                        });
                    }
                }).start();

                break;
            case R.id.size_quality_libjpeg_compress_btn://尺寸 质量 libjpeg结合压缩
                final ProgressDialog dialog = QxqDialogUtil.getInstance().progressDialog()
                        .setMessage("正在获取...")
                        .showProgressDialog(getActivity());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final File afterCompressImgFile = new File(mImageRootDir
                                + "/ttt2.jpg");

                        //先尺寸质量压缩后在用jni libjpeg压缩   (先保证SD卡目录下/jpeg_picture/temp.jpg存在)
                        String tempCompressImgPath = mImageRootDir+File.separator+"ttt.png";
                        ImageUtils.compressBitmap(tempCompressImgPath, afterCompressImgFile.getPath());

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mImage.setImageBitmap(BitmapFactory
                                        .decodeFile(afterCompressImgFile.getPath()));
                                dialog.dismiss();
                            }
                        });
                    }
                }).start();


                break;
            case R.id.after_compress_btn://压缩后

                final File afterCompressImgFile = new File(mImageRootDir
                        + "/ttt2.jpg");
                mImage.setImageBitmap(BitmapFactory
                        .decodeFile(afterCompressImgFile.getPath()));
                break;
            case R.id.original_btn://原图

                String tempCompressImgPath = mImageRootDir+File.separator+"ttt.png";
                mImage.setImageBitmap(BitmapFactory
                        .decodeFile(tempCompressImgPath));
                break;

            default:
                break;
        }

    }
}
