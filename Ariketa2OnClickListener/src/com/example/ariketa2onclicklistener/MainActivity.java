package com.example.ariketa2onclicklistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btreset = (Button)findViewById(R.id.button1);
        Button btplus = (Button)findViewById(R.id.button2);
        Button btminus = (Button)findViewById(R.id.button3);
        
        btreset.setOnClickListener(listenerBtnReset);
        btplus.setOnClickListener(listenerBtnPlus);
        btminus.setOnClickListener(listenerBtnMinus);
    }
    
    private Button.OnClickListener listenerBtnReset = new Button.OnClickListener(){  	
    	public void onClick(View v){
    		TextView edt1 = (TextView)findViewById(R.id.textView1);
        	TextView edt2 = (TextView)findViewById(R.id.textView2);
        	
        	String balioa = edt1.getText().toString();
        	edt1.setText("0");
        	edt2.setText(balioa); 
    	}
    	
    };
    
    private Button.OnClickListener listenerBtnPlus = new Button.OnClickListener(){  	
    	public void onClick(View v){
    		TextView edt1 = (TextView)findViewById(R.id.textView1);
        	int kont = Integer.parseInt(edt1.getText().toString()); 
        	kont++;
        	edt1.setText(String.valueOf(kont));
    	}
    	
    };
    
    private Button.OnClickListener listenerBtnMinus = new Button.OnClickListener(){  	
    	public void onClick(View v){
    		TextView edt1 = (TextView)findViewById(R.id.textView1);
        	int kont = Integer.parseInt(edt1.getText().toString()); 
        	kont--;
        	edt1.setText(String.valueOf(kont));
    	}
    	
    };
}
