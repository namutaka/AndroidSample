package jp.namu;

import jp.namu.view.MySurfaceView;
import namu.taka.R;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class HelloWorld extends Activity {
	
	private Thread mThread = null;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		MySurfaceView view = (MySurfaceView)findViewById(R.id.MySurfaceView01);
		view.setZOrderOnTop(true);
		SurfaceHolder h = view.getHolder();
		h.setFormat(PixelFormat.TRANSPARENT);
//		h.addCallback(new MySurfaceView(this));
		h.addCallback(view);
		
	}
	
	protected void onResume() {
		super.onResume();
		mHandler.sendEmptyMessageDelayed(1, 3000);
	}
	
	protected void onDestroy() {
		if (mThread != null) {
		mThread.interrupt();
		}
		mThread = null;
	}
	
	
	
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			MySurfaceView view = (MySurfaceView)findViewById(R.id.MySurfaceView01);
			switch(msg.what) {
			case 0:
				Log.v("AAA", "redraw");
				//findViewById(R.id.root).invalidate();

				view.doDraw();
				sendEmptyMessageDelayed(0, 3000);
				break;
				
			case 1:
				mThread = new Thread(view);
				mThread.start();
				break;
			}
		}
	};
	
	public void tryGroovy() {
		try {
//			GroovyShell gs = new GroovyShell();
//			Log.v("A", "" + gs.evaluate("def i = 1; return i;"));
//			Class clazz = (Class) gs
//					.evaluate("class MyClass { def method () {\"value\"}};return MyClass");
//			Log.v("A", clazz.toString());
//			GroovyObject obj = (GroovyObject) clazz.newInstance();
//			Log.v("A", "val = " + obj.invokeMethod("method", null));
		} catch (Exception e) {
			Log.e("a", "error", e);
		}
	}
	
	
}