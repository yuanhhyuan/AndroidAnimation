package com.hy.appui.graphics.canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * 绘图级的动画，无用户交互
 * http://m.blog.csdn.net/lijizhi19950123/article/details/78222178
 *
 * 直接通过Canvas进行图像的绘制，并通过Thread实现动画的效果
 */
public class TestCanvasView1 extends View implements Runnable{
    private Paint mPaint;  //画笔
    private Context mContext;//上下文的引用
    private int radiu;//圆环半径

    MeasureUtil mMeasureUtil = new MeasureUtil();

    public TestCanvasView1(Context context){
        this(context,null);
    }
    public TestCanvasView1(Context context, AttributeSet attrs){
        super(context,attrs);
        mContext=context;

        initPaint();//初始化画笔
    }

    private void initPaint() {
        //实例化画笔，并打开抗锯齿
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        /*
         * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
         *
         * 画笔样式分三种：
         * 1.Paint.Style.STROKE：描边
         * 2.Paint.Style.FILL_AND_STROKE：描边并填充
         * 3.Paint.Style.FILL：填充
         */
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔颜色为浅灰色
        mPaint.setColor(Color.LTGRAY);
        /*
         * 设置描边的粗细，单位：像素px
         * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
         */
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //绘制圆环
        canvas.drawCircle(mMeasureUtil.getScreenSize((Activity) mContext)[0] / 2, mMeasureUtil.getScreenSize((Activity) mContext)[1] / 2, radiu, mPaint);
    }

    @Override
    public void run(){
        //确保线程不断执行不断刷新页面
        while(true){
            try{
                //如果半径小于100则自加，否则大于100后重置半径值以实现往复
                if(radiu<100){
                    radiu+=10;
                    // 刷新View
                    postInvalidate();
                }else{
                    radiu=0;
                }
                //每执行一次暂停40毫秒
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public final class MeasureUtil {
        /**
         * 获取屏幕尺寸
         *
         * @param activity
         *
         * @return 屏幕尺寸像素值，下标为0的值为宽，下标为1的值为高
         */
        public int[] getScreenSize(Activity activity){
            DisplayMetrics metrics=new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            return new int[]{metrics.widthPixels,metrics.heightPixels};
        }
    }
}
