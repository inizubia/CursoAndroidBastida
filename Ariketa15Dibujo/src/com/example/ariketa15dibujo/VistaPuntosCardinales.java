package com.example.ariketa15dibujo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class VistaPuntosCardinales extends View{
	
	public VistaPuntosCardinales(Context context){
		super(context);
	}
	protected void onDraw(Canvas canvas){
		
		int R=canvas.getWidth()/4;
		canvas.drawColor(Color.BLACK);
		
		Paint circuloCentro = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloCentro.setColor(Color.CYAN);
		circuloCentro.setStyle(Paint.Style.STROKE);
		circuloCentro.setStrokeWidth(10);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/4, circuloCentro);
		
		Paint LineCruz = new Paint();
		LineCruz.setColor(Color.WHITE);
		canvas.drawLine(50, canvas.getHeight()/2, canvas.getWidth()-50, canvas.getHeight()/2, LineCruz);
		canvas.drawLine(canvas.getWidth()/2, 50, canvas.getWidth()/2, canvas.getHeight()-200, LineCruz);
		
		Paint LineDiagonal = new Paint();
		LineDiagonal.setColor(Color.GRAY);
		float cos=(float)Math.cos(Math.PI/4)*R;
		float sin=(float)Math.sin(Math.PI/4)*R;
		canvas.drawLine(canvas.getWidth()/2-cos, canvas.getHeight()/2-sin, canvas.getWidth()/2+cos, canvas.getHeight()/2+sin, LineDiagonal);
		canvas.drawLine(canvas.getWidth()/2-cos, canvas.getHeight()/2+sin, canvas.getWidth()/2+cos, canvas.getHeight()/2-sin, LineDiagonal);
	
		Paint circuloNorte = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloNorte.setColor(Color.WHITE);
		canvas.drawCircle(canvas.getWidth()/2, 50, canvas.getWidth()/20, circuloNorte);
		
		Paint circuloSur = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloSur.setColor(Color.RED);
		canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()-200, canvas.getWidth()/20, circuloSur);
		
		Paint circuloOeste = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloOeste.setColor(Color.BLUE);
		canvas.drawCircle(50, canvas.getHeight()/2, canvas.getWidth()/20, circuloOeste);
		
		Paint circuloEste = new Paint(Paint.ANTI_ALIAS_FLAG);
		circuloEste.setColor(Color.YELLOW);
		canvas.drawCircle(canvas.getWidth()-50, canvas.getHeight()/2, canvas.getWidth()/20, circuloEste);
		
		Paint punto = new Paint();
		punto.setColor(Color.BLACK);
		punto.setStyle(Paint.Style.STROKE);
		punto.setStrokeWidth(10);
		canvas.drawPoint(canvas.getWidth()/2, 50, punto);
		canvas.drawPoint(canvas.getWidth()/2, canvas.getHeight()-200, punto);
		canvas.drawPoint(50, canvas.getHeight()/2, punto);
		canvas.drawPoint(canvas.getWidth()-50, canvas.getHeight()/2, punto);
		
		float pc=(float)Math.sin(Math.PI/8)*R;
		float ps=(float)Math.cos(Math.PI/8)*R;
		canvas.drawPoint(canvas.getWidth()/2-pc, canvas.getHeight()/2-ps, punto);
		canvas.drawPoint(canvas.getWidth()/2+pc, canvas.getHeight()/2-ps, punto);
		canvas.drawPoint(canvas.getWidth()/2-pc, canvas.getHeight()/2+ps, punto);
		canvas.drawPoint(canvas.getWidth()/2+pc, canvas.getHeight()/2+ps, punto);
		
		float pc2=(float)Math.sin(Math.PI/3)*R;
		float ps2=(float)Math.cos(Math.PI/3)*R;
		canvas.drawPoint(canvas.getWidth()/2-pc2, canvas.getHeight()/2-ps2, punto);
		canvas.drawPoint(canvas.getWidth()/2+pc2, canvas.getHeight()/2-ps2, punto);
		canvas.drawPoint(canvas.getWidth()/2-pc2, canvas.getHeight()/2+ps2, punto);
		canvas.drawPoint(canvas.getWidth()/2+pc2, canvas.getHeight()/2+ps2, punto);
	}

}
