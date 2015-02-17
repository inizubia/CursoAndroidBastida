package com.example.ariketa16dibujoconbotones;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.Button;

public class MiBoton extends Button{
	
	public MiBoton(Context context){
		super(context);
	}
	
	public int color=Color.GREEN;
	
	protected void onDraw(Canvas lienzo){
		super.onDraw(lienzo);
		lienzo.drawColor(Color.WHITE);
		
		Paint pincel = new Paint();
		
		int w=getWidth();
		int h=getHeight();
		
		pincel.setColor(color);
		pincel.setStyle(Style.STROKE);
		pincel.setStrokeWidth(2);
		lienzo.drawRect(0, 0, w, h, pincel);
	}
	
	public void cambio(){
		color=Color.BLACK;
	}
	
	public void restaurar(){
		color=Color.GREEN;
	}
}
