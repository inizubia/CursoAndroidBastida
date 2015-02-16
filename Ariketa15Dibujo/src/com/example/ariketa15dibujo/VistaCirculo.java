package com.example.ariketa15dibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class VistaCirculo extends View{
	
	public VistaCirculo (Context context){
		super(context);
	}
	
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		Paint circuloRojo = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloRojo.setColor(Color.RED);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/3, circuloRojo);
		
		Paint circuloVerde = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloVerde.setColor(Color.GREEN);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/6, circuloVerde);
		
	}

}
