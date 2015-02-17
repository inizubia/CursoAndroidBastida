package com.example.ariketa17animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnTranslate, btnRotate, btnScale, btnAlpha, btnGrupo;
	private Animation animation1, animation2, animation3, animation4, animation5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnTranslate = (Button)findViewById(R.id.button1);
		btnRotate = (Button)findViewById(R.id.button2);
		btnScale = (Button)findViewById(R.id.button3);
		btnAlpha = (Button)findViewById(R.id.button4);
		btnGrupo = (Button)findViewById(R.id.button5);
		
		btnTranslate.setOnClickListener(this);
		btnRotate.setOnClickListener(this);
		btnScale.setOnClickListener(this);
		btnAlpha.setOnClickListener(this);
		btnGrupo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		animation1 = AnimationUtils.loadAnimation(this, R.anim.translate);
		animation2 = AnimationUtils.loadAnimation(this, R.anim.rotate);
		animation3 = AnimationUtils.loadAnimation(this, R.anim.scale);
		animation4 = AnimationUtils.loadAnimation(this, R.anim.alpha);
		animation5 = AnimationUtils.loadAnimation(this, R.anim.grupo);
		
		btnTranslate.startAnimation(animation1);
		btnRotate.startAnimation(animation2);
		btnScale.startAnimation(animation3);
		btnAlpha.startAnimation(animation4);
		btnGrupo.startAnimation(animation5);
		
	}
	
}
