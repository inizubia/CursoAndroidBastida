package com.example.ariketa3calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private TextView textView;
	private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0, botonPunto, botonMenos, botonMas, botonBider, botonZati, botonBerdin;
	private double emaitza = 0;
	private boolean balioBerria = true, azkenaOperazioa = false;
	private char operazioa;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        boton1 = (Button)findViewById(R.id.button7);
        boton2 = (Button)findViewById(R.id.button8);
        boton3 = (Button)findViewById(R.id.button9);
        boton4 = (Button)findViewById(R.id.button4);
        boton5 = (Button)findViewById(R.id.button5);
        boton6 = (Button)findViewById(R.id.button6);
        boton7 = (Button)findViewById(R.id.button1);
        boton8 = (Button)findViewById(R.id.button2);
        boton9 = (Button)findViewById(R.id.button3);
        boton0 = (Button)findViewById(R.id.button10);
        botonPunto = (Button)findViewById(R.id.button11);
        botonMenos = (Button)findViewById(R.id.button14);
        botonMas = (Button)findViewById(R.id.button15);
        botonBider = (Button)findViewById(R.id.button13);
        botonZati = (Button)findViewById(R.id.button12);
        botonBerdin = (Button)findViewById(R.id.button16);
        
        textView = (TextView)findViewById(R.id.textView1);
        
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
        boton3.setOnClickListener(this);
        boton4.setOnClickListener(this);
        boton5.setOnClickListener(this);
        boton6.setOnClickListener(this);
        boton7.setOnClickListener(this);
        boton8.setOnClickListener(this);
        boton9.setOnClickListener(this);
        boton0.setOnClickListener(this);
        botonPunto.setOnClickListener(this);
        botonMenos.setOnClickListener(this);
        botonMas.setOnClickListener(this);
        botonBider.setOnClickListener(this);
        botonZati.setOnClickListener(this);
        botonBerdin.setOnClickListener(this);   
    }     
    
    public void onClick(View v){
    	
    	String num = ((Button)v).getText().toString();
    	char op = ((Button)v).getText().toString().charAt(0);
    	
        switch(v.getId()){
        	case (R.id.button7): { saveNum(num); break;} //1
        	case (R.id.button8): { saveNum(num); break;} //2
        	case (R.id.button9): { saveNum(num); break;} //3
        	case (R.id.button4): { saveNum(num); break;} //4
        	case (R.id.button5): { saveNum(num); break;} //5
        	case (R.id.button6): { saveNum(num); break;} //6
        	case (R.id.button1): { saveNum(num); break;} //7 
        	case (R.id.button2): { saveNum(num); break;} //8 
        	case (R.id.button3): { saveNum(num); break;} //9 
        	case (R.id.button10): { saveNum(num); break;} //0
        	case (R.id.button11): { saveNum(num); break;} //.
        	
/////////////////////OPERAZIOAK//////////////////////////
        	case (R.id.button12): { saveEragiketa(op); break;} //-/
        	case (R.id.button13): { saveEragiketa(op); break;} //*
        	case (R.id.button14): { saveEragiketa(op); break;} //-
        	case (R.id.button15): { saveEragiketa(op); break;} //+
        	
/////////////////////BERDIN//////////////////////////        	
        	case (R.id.button16): {
        		eragiketa();
        		textView.setText(String.valueOf(emaitza));
        		operazioa = 'a';
        		break;
        	}
        }	    	
    }

	private void saveEragiketa(char op) {
		if(balioBerria){
			emaitza=Double.valueOf(textView.getText().toString());
			textView.setText("");}
		else{
			eragiketa();
			textView.setText(String.valueOf(emaitza));}
		//textView.setText("");
		balioBerria = false;
		operazioa = op;
		azkenaOperazioa = true;
	}

	private void saveNum(String num) {
		if(operazioa == 'a'){
			textView.setText(num);
			emaitza = 0;
			balioBerria = true;
			operazioa = 'h';
		}
		else if (azkenaOperazioa){
			textView.setText(num);
			azkenaOperazioa = false;
		}
		else
			textView.setText(textView.getText()+num);
	}
    
    public void eragiketa(){
    		switch (operazioa){
    			case '+': { 
    				emaitza+=Double.valueOf(textView.getText().toString()); 
    				break;
    			}
    			case '-': { 
    				emaitza-=Double.valueOf(textView.getText().toString()); 
    				break;
    			}
    			case '*': { 
    				emaitza*=Double.valueOf(textView.getText().toString()); 
    				break;
    			} 
    			case '/': { 
    				emaitza/=Double.valueOf(textView.getText().toString()); 
    				break;
    			}
    			default:break;
    		}
    }        
}