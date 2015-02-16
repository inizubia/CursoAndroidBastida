package com.example.ariketa15dibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class VistaPunto extends View{
	
	public VistaPunto (Context context){
		super(context);
	}

	protected void onDraw(Canvas canvas){	
		Paint paintLine = new Paint();
		paintLine.setColor(Color.GREEN);
		//paintLine.setStyle(Paint.Style.STROKE);
		//paintLine.setStrokeWidth(10);
		canvas.drawLine(20, 20, 50, 50, paintLine);
		canvas.drawLine(50, 50, 100, 100, paintLine);
		
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(10);
		canvas.drawPoint(20, 20, paint);
		canvas.drawPoint(50, 50, paint);
		canvas.drawPoint(100, 100, paint);
	}
}
