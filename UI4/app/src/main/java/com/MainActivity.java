package com;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hy.app.ui4.R;
import com.hy.appui.graphics.animation.FrameAnimationActivity;
import com.hy.appui.graphics.animation.FrameAnimationActivity1;
import com.hy.appui.graphics.animation.PropertyAnimationActivity;
import com.hy.appui.graphics.animation.TweenAnimationActivity;
import com.hy.appui.graphics.canvas.TestCanvasActivity;
import com.hy.appui.graphics.canvas.TestCanvasActivity1;
import com.hy.appui.graphics.canvas.TestCanvasActivity2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mTestCanvasActivity)
    Button mTestCanvasActivity;
    @BindView(R.id.mTestCanvasActivity1)
    Button mTestCanvasActivity1;
    @BindView(R.id.mTestCanvasActivity2)
    Button mTestCanvasActivity2;
    @BindView(R.id.mAnimationDrawableActivity)
    Button mAnimationDrawableActivity;
    @BindView(R.id.mAnimationDrawableActivity1)
    Button mAnimationDrawableActivity1;
    @BindView(R.id.mTweenAnimationActivity)
    Button mTweenAnimationActivity;
    @BindView(R.id.mPropertyAnimationActivity)
    Button mPropertyAnimationActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.mTestCanvasActivity,R.id.mTestCanvasActivity1,R.id.mTestCanvasActivity2,R.id.mAnimationDrawableActivity,R.id.mAnimationDrawableActivity1,R.id.mTweenAnimationActivity,R.id.mPropertyAnimationActivity})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mTestCanvasActivity:
                newTestCanvasActivity();
                break;
            case R.id.mTestCanvasActivity1:
                newTestCanvasActivity1();
                break;
            case R.id.mTestCanvasActivity2:
                newTestCanvasActivity2();
                break;
            case R.id.mAnimationDrawableActivity:
                newAnimationDrawableActivity();
                break;
            case R.id.mAnimationDrawableActivity1:
                newAnimationDrawableActivity1();
                break;
            case R.id.mTweenAnimationActivity:
                newTweenAnimationActivity();
                break;
            case R.id.mPropertyAnimationActivity:
                newPropertyAnimationActivity();
                break;
            default:
                break;
        }
    }

    private void newTestCanvasActivity(){
        Intent i = new Intent(MainActivity.this,TestCanvasActivity.class);
        startActivity(i);
    }

    private void newTestCanvasActivity1(){
        Intent i = new Intent(MainActivity.this,TestCanvasActivity1.class);
        startActivity(i);
    }

    private void newTestCanvasActivity2(){
        Intent i = new Intent(MainActivity.this,TestCanvasActivity2.class);
        startActivity(i);
    }

    private void newAnimationDrawableActivity(){
        Intent i = new Intent(MainActivity.this,FrameAnimationActivity.class);
        startActivity(i);
    }

    private void newAnimationDrawableActivity1(){
        Intent i = new Intent(MainActivity.this,FrameAnimationActivity1.class);
        startActivity(i);
    }

    private void newTweenAnimationActivity(){
        Intent i = new Intent(MainActivity.this,TweenAnimationActivity.class);
        startActivity(i);
        // 自定义的淡入淡出动画效果
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
    private void newPropertyAnimationActivity(){
        Intent i = new Intent(MainActivity.this,PropertyAnimationActivity.class);
        startActivity(i);
    }

}
