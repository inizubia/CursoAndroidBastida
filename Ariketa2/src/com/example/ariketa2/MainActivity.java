package com.example.ariketa2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void batu (View v){
    	EditText edt1 = (EditText)findViewById(R.id.editText1);
    	int kont = Integer.parseInt(edt1.getText().toString()); 
    	kont++;
    	edt1.setText(String.valueOf(kont));
    }
    
    public void kendu (View v){
    	EditText edt1 = (EditText)findViewById(R.id.editText1);
    	int kont = Integer.parseInt(edt1.getText().toString()); 
    	kont--;
    	edt1.setText(String.valueOf(kont));
    }
    
    public void reset (View v){
    	EditText edt1 = (EditText)findViewById(R.id.editText1);
    	EditText edt2 = (EditText)findViewById(R.id.editText2);
    	
    	String balioa = edt1.getText().toString();
    	edt1.setText("0");
    	edt2.setText(balioa);    	
    }
}
