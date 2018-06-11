package com.hy.appui.graphics.animation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
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
public class FrameAnimationActivity extends Activity{
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
        setContentView(R.layout.activity_animationdrawable);

        ButterKnife.bind(this);

        mIvImg.setBackgroundResource(R.drawable.anim_drawable);
        animationDrawable = (AnimationDrawable)mIvImg.getBackground();
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
        animationDrawable.start();
    }
    private void stop(){
        animationDrawable.stop();
    }

}
