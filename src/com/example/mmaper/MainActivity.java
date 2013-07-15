package com.example.mmaper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    float x;
    float y;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        x = e.getX();
        y = e.getY();
        
        StateHolder.LastX = x - 10; // TODO: Learn how to compensate properly
        StateHolder.LastY = y - 100; // TODO: Learn how to compensate properly
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.plus:
                addNew();
                return true;
            case R.id.undo:
                clearAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	private void clearAll() {
		// TODO Auto-generated method stub
		
	}

	private void addNew() {
		StateHolder.mmodel.LoadFrom("test_mmap.xml");
		
	}
    
}
