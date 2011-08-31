package jp.namu.view;

import namu.taka.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {

	private Context mContext;
	private SurfaceHolder mHolder;
	private int counter = 0;

	public MySurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
	//	init();
		mContext = context;
	}

	public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
//		init();
		mContext = context;
	}

	public MySurfaceView(Context context) {
		// コンストラクタ
		super(context);
	//	init();
		mContext = context;
	}

	private void init() {
		// SurfaceHolderを取得するために、getHolderメソッドを呼び出す
		getHolder().setFormat(PixelFormat.TRANSPARENT);
		getHolder().addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// SurfaceViewのサイズなどが変更されたときに呼び出されるメソッド。
		Log.d("SampleSurView", "surfaceCreated called.");
		mHolder = holder;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// SurfaceViewが最初に生成されたときに呼び出されるメソッド
		Log.d("SampleSurView", "surfaceChanged called.");
		doDraw();
	}
	
	private void doDraw() {
		Log.v("SampleSurView", "drww called.");
		// SurfaceHolderからCanvasのインスタンスを取得する
		Canvas canvas = mHolder.lockCanvas();
		// Canvasの背景色を白で塗る
		// canvas.drawColor(Color.WHITE);
		 canvas.drawColor(0, PorterDuff.Mode.CLEAR);

		// Paintクラスのインスタンスを作る。これは、描画するときに使用する
		// 色は青、アンチエイリアスON、テキストサイズ24
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setAntiAlias(true);
		paint.setTextSize(24);
		paint.setAlpha(255);
		Bitmap image = BitmapFactory.decodeResource(
				mContext.getResources(), R.drawable.icon);
		counter++;
		// Canvasに文字を書く。ここでPaintクラスのインスタンスを用いる。
		// つまり、青色でテキストサイズが24でアンチエイリアスのかかった「Sample Text」を描画する
		canvas.drawText("Sample Test : " + counter, 0, paint.getTextSize(),				paint);
		canvas.drawBitmap(image, 10 + (counter % 10) * 10, 10+ (counter % 10) * 10, null);

		// 描画が終わったら呼び出すメソッド。
		mHolder.unlockCanvasAndPost(canvas);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// SurfaceViewが破棄されるときに呼び出されるメソッド
		// 今回は実装しない。
		Log.d("SampleSurView", "surfaceDestroyed");
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		
		Log.d("zzz", "disp");
		doDraw();
	}
	
}
