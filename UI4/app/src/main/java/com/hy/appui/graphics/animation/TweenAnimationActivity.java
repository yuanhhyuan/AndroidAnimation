package com.hy.appui.graphics.animation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.hy.app.ui4.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 补间动画：平移、缩放、旋转、透明度、组合五种效果
 *
 http://www.jianshu.com/p/5d090270a4f5
 */
public class TweenAnimationActivity extends Activity {
    String tag = "060_TweenAnimation";

    @BindView(R.id.mcreateRotateAnimation)
    Button mcreateRotateAnimation;
    @BindView(R.id.mcreateScaleAnimation)
    Button mcreateScaleAnimation;
    @BindView(R.id.mcreateTranslateAnimation)
    Button mcreateTranslateAnimation;
    @BindView(R.id.mcreateAlphaAnimation)
    Button mcreateAlphaAnimation;
    @BindView(R.id.mcreateSetAnimation)
    Button mcreateSetAnimation;
    @BindView(R.id.mTv)
    ImageView mTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweenanimation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mcreateRotateAnimation,R.id.mcreateScaleAnimation,R.id.mcreateTranslateAnimation,R.id.mcreateAlphaAnimation,R.id.mcreateSetAnimation})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mcreateRotateAnimation:
                createRotateAnimation();
                break;
            case R.id.mcreateScaleAnimation:
                createScaleAnimation();
                break;
            case R.id.mcreateTranslateAnimation:
                createTranslateAnimation();
                break;
            case R.id.mcreateAlphaAnimation:
                createAlphaAnimation();
                break;
            case R.id.mcreateSetAnimation:
                createSetAnimation();
                break;
            default:
                break;
        }
    }
    /**
     * 创建旋转动画
     */
    private void createRotateAnimation() {
        // 步骤2:创建 动画对象 并传入设置的动画效果xml文件
        Animation ratateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_demo);
        // 步骤3:播放动画
        mTv.startAnimation(ratateAnimation);

        // 步骤4:监听动画
        ratateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e(tag, "1=================Start");
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.e(tag, "1=================Repeat");
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Log.e(tag, "1=================End");
            }
        });
    }

    /**
     * 创建缩放动画
     */
    private void createScaleAnimation() {
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_demo);
        mTv.startAnimation(scaleAnimation);
    }
    /**
     * 创建位移动画
     */
    private void createTranslateAnimation() {
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_demo);
        mTv.startAnimation(translateAnimation);
    }
    /**
     * 创建透明度渐变动画
     */
    private void createAlphaAnimation() {
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_demo);
        mTv.startAnimation(alphaAnimation);
    }
    /**
     * 创建组合动画，平移、缩放、旋转、透明度任意组合
     */
    private void createSetAnimation() {
        Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.set_demo);
        mTv.startAnimation(setAnimation);
    }


}
