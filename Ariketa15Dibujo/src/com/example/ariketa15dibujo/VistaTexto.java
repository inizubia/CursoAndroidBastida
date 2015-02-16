package com.example.ariketa15dibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class VistaTexto extends View{
	
	public VistaTexto (Context context){
		super(context);
	}
	
	protected void onDraw(Canvas canvas){
		canvas.drawColor(Color.BLACK);
		
		Paint pintar = new Paint(Paint.ANTI_ALIAS_FLAG);
		
		pintar.setColor(Color.MAGENTA);
		
		Typeface fuente = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
		pintar.setTextSize(28);
		pintar.setTypeface(fuente);
		
		canvas.drawText("Texto a dibujar", 140, 120, pintar);
	}

}
