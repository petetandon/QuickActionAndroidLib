/**
 * 
 */
package net.londatiga.android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author petey
 * 
 */
public class TriangleView extends View {
	
	private static final int DIRECTION_UP = 0, DIRECTION_DOWN = 1;
	private Paint paint;

	private int direction = DIRECTION_UP;

	private void init(AttributeSet attrs) {
		paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		paint.setStrokeWidth(2);
		paint.setColor(Color.WHITE);
		if (attrs != null) {
			direction = attrs.getAttributeIntValue("qa3d", "direction", DIRECTION_UP);
		}
	}

	public void setColor(int color) {
		paint.setColor(color);
		invalidate();
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public TriangleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public TriangleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		int height = getHeight();
		int width = getWidth();

		float altitude = height;

		Path path = new Path();
		switch (direction) {
		case DIRECTION_UP:
			path.moveTo(0, altitude);
			path.lineTo(width / 2, 0);
			path.lineTo(width, altitude);
			break;
		case DIRECTION_DOWN:
			path.moveTo(0, 0);
			path.lineTo(width / 2, altitude);
			path.lineTo(width, 0);
			break;
		}
		path.close();
		canvas.drawPath(path, paint);

	}

}
