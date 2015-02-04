package com.example.ariketa3calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends Activity implements OnClickListener{

	private TextView textView;
	private Button boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton0, botonPunto, botonMenos, botonMas, botonBider, botonZati, botonBerdin;
	private double emaitza = 0;
	private boolean operazioBerria = false, balioBerria = true;
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
    	
        switch(v.getId()){
        	case (R.id.button7): {
        		if(operazioa == 'a'){
        			textView.setText("1");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"1"); 
        		break;
        	}
        	case (R.id.button8): {        		
        		if(operazioa == 'a'){
        			textView.setText("2");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"2"); 
        		break;
        	}
        	case (R.id.button9): {
        		if(operazioa == 'a'){
        			textView.setText("3");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"3"); 
        		break;
        	}
        	case (R.id.button4): {
        		if(operazioa == 'a'){
        			textView.setText("4");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"4"); 
        		break;
        	}
        	case (R.id.button5): {
        		if(operazioa == 'a'){
        			textView.setText("5");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"5"); 
        		break;
        	}
        	case (R.id.button6): {
        		if(operazioa == 'a'){
        			textView.setText("6");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"6"); 
        		break;
        	}
        	case (R.id.button1): {
        		if(operazioa == 'a'){
        			textView.setText("7");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"7"); 
        		break;
        	}
        	case (R.id.button2): {
        		if(operazioa == 'a'){
        			textView.setText("8");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"8"); 
        		break;
        	}
        	case (R.id.button3): {
        		if(operazioa == 'a'){
        			textView.setText("9");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"9"); 
        		break;
        	}
        	case (R.id.button10): {
        		if(operazioa == 'a'){
        			textView.setText("0");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"0"); 
        		break;
        	}
        	case (R.id.button11): {
        		if(operazioa == 'a'){
        			textView.setText(".");
        			emaitza = 0;
        			balioBerria = true;
        		}
        		else
        			textView.setText(textView.getText()+"."); 
        		break;
        	}
        	case (R.id.button12): {
        		if(balioBerria)
        			emaitza=Double.valueOf(textView.getText().toString());
        		else
        			eragiketa();
        		
        		textView.setText("");
        		balioBerria = false;
        		operazioa = '/';
        		break;
        	}
        	case (R.id.button13): {
        		if(balioBerria)
        			emaitza=Double.valueOf(textView.getText().toString());
        		else
        			eragiketa();
        		
        		textView.setText("");
        		balioBerria = false;
        		operazioa = '*';
        		break;
        	}
        	case (R.id.button14): {
        		if(balioBerria)
        			emaitza=Double.valueOf(textView.getText().toString());
        		else
        			eragiketa();
        		
        		textView.setText("");
        		balioBerria = false;
        		operazioa = '-';
        		break;
        	}
        	case (R.id.button15): {
        		if(balioBerria)
        			emaitza=Double.valueOf(textView.getText().toString());
        		else
        			eragiketa();
        		
        		textView.setText("");
        		balioBerria = false;
        		operazioa = '+';
        		break;
        	}
        	case (R.id.button16): {
        		eragiketa();
        		textView.setText(String.valueOf(emaitza));
        		operazioa = 'a';
        		
        	}
        }	    	
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