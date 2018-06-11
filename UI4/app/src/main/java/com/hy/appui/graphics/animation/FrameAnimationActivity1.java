package com.hy.appui.graphics.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hy.app.ui4.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 Android中的动画（一）----AnimationDrawable帧动画
 http://blog.csdn.net/shibin1990_/article/details/51604361
 */
public class FrameAnimationActivity1 extends Activity{
    @BindView(R.id.start)
    Button start;
    @BindView(R.id.stop)
    Button stop;
    @BindView(R.id.mIvImg)
    ImageView mIvImg;

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationdrawable1);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.start,R.id.stop})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                start();
                break;
            case R.id.stop:
                stop();
                break;
            default:
                break;
        }
    }
    private void start(){
        //创建帧动画
        animationDrawable = new AnimationDrawable();
        //添加帧
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.l1), 300);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.l2), 300);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.l3), 300);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.l4), 300);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.l5), 300);
        //设置动画是否只播放一次， 默认是false
        animationDrawable.setOneShot(false);
        //根据索引获取到那一帧的时长
        int duration = animationDrawable.getDuration(2);
        //根据索引获取到那一帧的图片
        Drawable drawable = animationDrawable.getFrame(0);
        //判断是否是在播放动画
        boolean isRunning = animationDrawable.isRunning();
        //获取这个动画是否只播放一次
        boolean isOneShot = animationDrawable.isOneShot();
        //获取到这个动画一共播放多少帧
        int framesCount = animationDrawable.getNumberOfFrames();
        //把这个动画设置为background，兼容更多版本写下面那句
        mIvImg.setBackground(animationDrawable);
        mIvImg.setBackgroundDrawable(animationDrawable);

        animationDrawable.start();
    }

    private void stop(){
        animationDrawable.stop();
    }

}
