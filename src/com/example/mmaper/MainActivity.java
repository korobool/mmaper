package com.example.mmaper;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    float x;
    float y;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        // Canvas c = new Canvas(b);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        x = e.getX();
        y = e.getY();
      
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}