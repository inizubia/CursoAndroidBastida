package com.example.ariketa10agendasqlite;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VisualActivity extends Activity implements OnClickListener{

	private Button btnVolver2;
	private TextView textoView;
	private LinearLayout ll;
	private String linea;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visual);
		
		btnVolver2 = (Button)findViewById(R.id.volver2);
		
		btnVolver2.setOnClickListener(this);
		
		ll=(LinearLayout)findViewById(R.id.datuak);
		
		cargar();
	}
	
	@Override
	public void onClick(View v) {	
		if (v.getId()==R.id.volver2){
			finish();	
		}
	}
	
	public void cargar(){
	    try{
	        FileInputStream fis = openFileInput("textFile.txt");
	        InputStreamReader isr = new InputStreamReader(fis);
	        
	        BufferedReader br = new BufferedReader(isr);
            
            do{
            	linea = br.readLine();
                textoView = new TextView(this);
                textoView.setText(linea);
                ll.addView(textoView);
            	
            }while (linea !=null);
            
            br.close();
            isr.close();
	        
	        // Mostramos un Toast con el proceso completado
	        Toast.makeText(getBaseContext(), "Cargado", Toast.LENGTH_SHORT).show();

	    }catch (IOException ex){
	        ex.printStackTrace();
	    }
	}
}
