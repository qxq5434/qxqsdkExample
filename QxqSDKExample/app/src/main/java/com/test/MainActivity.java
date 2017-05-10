package com.test;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.qxq.base.QxqBaseActivity;
import com.qxq.base.QxqSwipeBackActivity;
import com.qxq.photopick.ImageInfo;
import com.qxq.photopick.PhotoPickResult;
import com.qxq.photopick.PhotoPickUtil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/29.
 */
public class MainActivity extends QxqSwipeBackActivity {

    String[] strs = new String[]{"图片选择","文件上传下载","网络请求","检查更新","提示框",
            "RecyclerViewToLinearLayoutManager","RecyclerViewToStaggeredGridLayoutManager","RecyclerViewToGridLayoutManager","轮播广告位",
            "第三方登录","第三方分享","图片加载","变色字体","NDK图片压缩"};


    @Override
    protected int setContentViewId() {
        return R.layout.main;
    }


    @Override
    public void initLayout() {
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeBackEnable(false);
        SwipeBackHelper.getCurrentPage(this).setDisallowInterceptTouchEvent(true);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,20,0,0);
        for (int i = 1 ; i <= strs.length ; i++){
            final int num = i;

            Button button = new Button(getApplicationContext());
            button.setText(strs[i-1]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startAnimActivity(FragmentToActivity.class,new String[]{"type"},new String[]{num+""});
                }
            });
            button.setLayoutParams(params);
            layout.addView(button);
        }

    }

    @Override
    protected void initData() {
        String[] mPermissionList = new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CALL_PHONE};
        checkPermission(mPermissionList);
    }

    @Override
    public void initListener() {
    }


    @Override
    public void onClick(View view) {

    }
}
