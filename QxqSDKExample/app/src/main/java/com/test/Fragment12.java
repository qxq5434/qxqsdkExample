package com.test;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TimePicker;

import com.qxq.base.QxqBaseFragment;
import com.qxq.views.ColorTrackTextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/3/27.
 */
public class Fragment12 extends QxqBaseFragment {

    private ColorTrackTextView mCttv1,mCttv2;

    @Override
    protected int setContentView() {
        return R.layout.fragment12;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initLayout(View view) {
        mCttv1 = (ColorTrackTextView) view.findViewById(R.id.text1);
        mCttv2 = (ColorTrackTextView) view.findViewById(R.id.text2);
        mCttv1.setCurrentProgress(1.0f);
    }

    @Override
    public void initListener(View view) {
        view.findViewById(R.id.left).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.left:
                left();
                break;
        }
    }

    private  float progress = 0.0f;

    // onClick事件写在了不居中  --> android:onClick="left"
    public void left() {
        // 设置朝向
        mCttv1.setDirection(ColorTrackTextView.Direction.DIRECTION_RIGHT);
        mCttv2.setDirection(ColorTrackTextView.Direction.DIRECTION_LEFT);


        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if(progress < 1.0f) {
                    progress += 0.1f;

                    handler.sendEmptyMessage(0);
                }
            }
        }, 0, 200);


    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    mCttv1.setCurrentProgress(1 - progress);
                    mCttv2.setCurrentProgress(progress);
                    break;
            }
        }
    };


}
