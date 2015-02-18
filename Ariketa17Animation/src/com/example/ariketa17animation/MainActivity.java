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
	private Animation animation;

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
		
		if (v.getId()==btnTranslate.getId()){
			animation = AnimationUtils.loadAnimation(this, R.anim.translate);
			btnTranslate.startAnimation(animation);
		}
		else if (v.getId()==btnRotate.getId()) {
			animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
			btnRotate.startAnimation(animation);
		}
		else if (v.getId()==btnScale.getId()) {
			animation = AnimationUtils.loadAnimation(this, R.anim.scale);
			btnScale.startAnimation(animation);
		}
		else if (v.getId()==btnAlpha.getId()) {
			animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
			btnAlpha.startAnimation(animation);
		}
		else if (v.getId()==btnGrupo.getId()) {
			animation = AnimationUtils.loadAnimation(this, R.anim.grupo);
			btnGrupo.startAnimation(animation);
		}	
	}
	
}
