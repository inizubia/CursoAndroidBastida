package com.example.ariketa7intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private Button btnSartu;
	private EditText edtPasahitza;
	private String pass= "zubia";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtPasahitza = (EditText)findViewById(R.id.pasahitza);
		
		btnSartu = (Button)findViewById(R.id.botoia);
		btnSartu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		String msg;
		
		if(edtPasahitza.getText().toString().equals(pass))
			msg = "ONARTUA";

		else		
			msg = "ERROREAAA!!!";
		
		Intent i = new Intent(this, SarreraActivity.class);
		i.putExtra("clave", msg);
		startActivity(i);
	}	
}
