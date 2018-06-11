package com.hy.appui.graphics.canvas;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.hy.app.ui4.R;


/**

 */
public class TestCanvasActivity2 extends Activity {

    private TestCanvasView2 mTestCanvasView2;

    private int tableWidth; // 桌面的宽度
    private int tableHeight; // 桌面的高度
    private int racketY; // 球拍的垂直位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_testcanvas2);
        // 全屏显示
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final TestCanvasView2 gameView = new TestCanvasView2(this);
        setContentView(gameView);
        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        // 获得屏幕宽和高
        tableWidth = metrics.widthPixels;
        tableHeight = metrics.heightPixels;
        racketY = tableHeight - 80;

//        gameView.initListener(gameView);
//        gameView.initTimer();
    }

}
