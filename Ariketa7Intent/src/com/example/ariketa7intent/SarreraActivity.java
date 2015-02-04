package com.example.ariketa7intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SarreraActivity extends Activity {
	
	private String mensaje;
	private TextView tvMensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sarrera);
		
		mensaje = getIntent().getExtras().getString("clave");
		
		tvMensaje = (TextView)findViewById(R.id.textView2);
		
		tvMensaje.setText(mensaje);
	}
}
