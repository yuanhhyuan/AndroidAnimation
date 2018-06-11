package com.hy.appui.graphics.canvas;

import android.app.Activity;
import android.os.Bundle;

import com.hy.app.ui4.R;

public class TestCanvasActivity1 extends Activity {
    private TestCanvasView1 mTestCanvasView1; //我们自定义View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testcanvas1);

        // 获取控件
        mTestCanvasView1=(TestCanvasView1)findViewById(R.id.mTestCanvasView1);
        // 开线程
        new Thread(mTestCanvasView1).start();
    }
}
