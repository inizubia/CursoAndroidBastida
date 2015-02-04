package com.example.ariketa2implonclicklistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private TextView edt1;
	private TextView edt2;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edt1 = (TextView)findViewById(R.id.textView1);
		edt2 = (TextView)findViewById(R.id.textView2);
		
        Button boton = (Button)findViewById(R.id.button1);
        Button boton2 = (Button)findViewById(R.id.button2);
        Button boton3 = (Button)findViewById(R.id.button3);
        boton.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
    }
    
	public void onClick (View v){
    	if (v.getId()==R.id.button1)
    		reset();
    	else if (v.getId()==R.id.button2)
    		suma();
    	else if (v.getId()==R.id.button3)
    		resta();
    }

	private void reset() {
		String balioa = edt1.getText().toString();
		edt1.setText(0);
		edt2.setText(balioa);
	}

	private void suma() {
		int kont = Integer.parseInt(edt1.getText().toString()); 
		kont++;
		edt1.setText(String.valueOf(kont));
	}
	
	private void resta() {
		int kont = Integer.parseInt(edt1.getText().toString()); 
		kont--;
		edt1.setText(String.valueOf(kont));
	}
}
