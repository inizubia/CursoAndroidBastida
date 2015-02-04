package com.example.ariketa1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	public void batu(View v){
		Button b = (Button)findViewById(R.id.button1);
	    String buttonText = b.getText().toString();
	    int cont = Integer.parseInt(buttonText);
	    cont++;
	    buttonText = String.valueOf(cont);
	    b.setText(buttonText);
	}
}
