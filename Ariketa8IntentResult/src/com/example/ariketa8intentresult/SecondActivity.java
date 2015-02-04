package com.example.ariketa8intentresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent it = getIntent();
		String pass = getIntent().getExtras().getString("clave");
		
		if(pass.equals("zubia"))
			setResult(RESULT_OK, it);
		else
			setResult(RESULT_CANCELED, it);
		
		finish();
	}
}
