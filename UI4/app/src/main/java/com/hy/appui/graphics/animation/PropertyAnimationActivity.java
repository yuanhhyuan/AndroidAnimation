package com.hy.appui.graphics.animation;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.hy.app.ui4.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 安卓进阶第五篇之常见动画的使用
 * http://www.jianshu.com/p/5d090270a4f5
 */
public class PropertyAnimationActivity extends Activity {
    String tag = "060_PropertyAnim";
//    Button btn1;
//    Button btn2;
//    ImageView m1;

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.m1)
    ImageView m1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertyanimation);

        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn1,R.id.btn2})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                doAnimator();
                break;
            case R.id.btn2:
                paowuxian(m1);
                break;
            default:
                break;
        }
    }
    private void doAnimator() {
        final int top = m1.getTop();
        final int left = m1.getLeft();
        final int width = m1.getMeasuredWidth();
        final int height = m1.getMeasuredHeight();
        ValueAnimator animator = ValueAnimator.ofInt(0, 400,0,300,0,200,0,100,0,50,0,40,0,30,0,20,0,10,0,5,0);
        // 设置动画运行的时长
        animator.setDuration(4000);
        //多久后开始动画
        animator.setStartDelay(0);
        //无穷循环
        animator.setRepeatCount(5);
        //无穷循环
//        animator.setRepeatCount(ValueAnimator.INFINITE);
        //repeat的时候正向重新计算
        animator.setRepeatMode(ValueAnimator.RESTART);
        //repeat的时候反向重新计算
//        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                // 获得改变后的值
                int value = (int) valueAnimator.getAnimatedValue();
                // 将改变后的值赋给对象的属性值
                m1.layout(left,top-value,left+width,top-value+height);
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.e(tag,"onAnimation   Start");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.e(tag,"onAnimation   End");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.e(tag,"onAnimation   Cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.e(tag,"onAnimation   Repeat");
            }
        });
        animator.start();
    }


    /**
     * 抛物线
     * @param view
     */
    public void paowuxian(View view)
    {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue)
            {
                Log.e(tag, fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.x = 200 * fraction * 3;
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                m1.setX(point.x);
                m1.setY(point.y);

            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.e(tag,"onAnimation   Start");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.e(tag,"onAnimation   End");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.e(tag,"onAnimation   Cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.e(tag,"onAnimation   Repeat");
            }
        });
    }
}
