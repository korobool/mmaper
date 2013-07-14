package com.example.mmaper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class Panel extends SurfaceView implements Callback {
	
	private CanvasThread canvasthread;
	public Paint paint;
	
	 public Panel(Context context, AttributeSet attrs) {
			super(context, attrs); 
			// TODO Auto-generated constructor stub
		    getHolder().addCallback(this);
		    canvasthread = new CanvasThread(getHolder(), this);
		    setFocusable(true);
		 paint = new Paint();
		}
	
	public Panel(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		canvasthread = new CanvasThread(getHolder(), this);
		canvasthread.setRunning(true);
	    canvasthread.start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		boolean retry = true;
		canvasthread.setRunning(false);
		while (retry) {
			try {
				canvasthread.join();
				retry = false;
			} catch (InterruptedException e) {
				// we will try it again and again...
			}
		}

	}
	
	@Override
	public void onDraw(Canvas canvas) {

		paint.setARGB(255, 255, 255, 255);
		//canvas.drawColor(Color.BLACK);
		canvas.drawCircle(200f, 200f, 20, paint);
	}

}
