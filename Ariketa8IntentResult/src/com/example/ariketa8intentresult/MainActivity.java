package com.example.ariketa8intentresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnSartu;
	private EditText edtPasahitza;
	private TextView tvLog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtPasahitza = (EditText)findViewById(R.id.pasahitza);
		tvLog = (TextView)findViewById(R.id.emaitza);
		
		btnSartu = (Button)findViewById(R.id.botoia);
		btnSartu.setOnClickListener(this);
	
	}
	
	@Override
	public void onClick(View v) {
		
		String password = edtPasahitza.getText().toString();
		
		Intent i = new Intent(this, SecondActivity.class);
		i.putExtra("clave", password);
		startActivityForResult(i, 1);
	}

	@Override
	protected void onActivityResult(int id, int result, Intent data) {
		if (result == RESULT_OK){
			tvLog.setText("EDERTO");
		}
		else{
			tvLog.setText("ERROREA!");
		}
	}
	
}
