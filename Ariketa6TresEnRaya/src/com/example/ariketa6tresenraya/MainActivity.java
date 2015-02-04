package com.example.ariketa6tresenraya;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnStart, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private int turno=1, kont=0;
	private String tablero[] = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnStart=(Button)findViewById(R.id.bStart);
    	btnStart.setOnClickListener(this);
    	
    	btn1=(Button)findViewById(R.id.b1);
    	btn1.setOnClickListener(this);
    	
    	btn2=(Button)findViewById(R.id.b2);
    	btn2.setOnClickListener(this);
    	
    	btn3=(Button)findViewById(R.id.b3);
    	btn3.setOnClickListener(this);
    	
    	btn4=(Button)findViewById(R.id.b4);
    	btn4.setOnClickListener(this);
    	
    	btn5=(Button)findViewById(R.id.b5);
    	btn5.setOnClickListener(this);
    	
    	btn6=(Button)findViewById(R.id.b6);
    	btn6.setOnClickListener(this);
    	
    	btn7=(Button)findViewById(R.id.b7);
    	btn7.setOnClickListener(this);
    	
    	btn8=(Button)findViewById(R.id.b8);
    	btn8.setOnClickListener(this);
    	
    	btn9=(Button)findViewById(R.id.b9);
    	btn9.setOnClickListener(this);
        
        inicializar();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void inicializar(){   	
    	
    	for(int i=0;i<=9;i++)
    		tablero[i]="";
    	
    	btn1.setText("");
    	btn2.setText("");
    	btn3.setText("");
    	btn4.setText("");
    	btn5.setText("");
    	btn6.setText("");
    	btn7.setText("");
    	btn8.setText("");
    	btn9.setText("");
    	
    	kont=0;
    	
    }
    
    public void estadoBotones(boolean estado){
    	btn1.setEnabled(estado);
    	btn2.setEnabled(estado);
    	btn3.setEnabled(estado);
    	btn4.setEnabled(estado);
    	btn5.setEnabled(estado);
    	btn6.setEnabled(estado);
    	btn7.setEnabled(estado);
    	btn8.setEnabled(estado);
    	btn9.setEnabled(estado);
    }
    
    public void meterFitxa(int a){
    	if(turno==1){	
    		tablero[a]="X";
    		turno=2;
    		kont++;
    	}
    	else{
    		tablero[a]="O";
    		turno=1;
    		kont++;
    	}
    	siGana();
    	if(kont==9)
    		empate();
    }
    
    public void siGana(){
    	if(((tablero[1].equals("X")) && (tablero[2].equals("X")) && (tablero[3].equals("X")))
    	|| ((tablero[4].equals("X")) && (tablero[5].equals("X")) && (tablero[6].equals("X")))
    	|| ((tablero[7].equals("X")) && (tablero[8].equals("X")) && (tablero[9].equals("X")))
    	|| ((tablero[1].equals("X")) && (tablero[4].equals("X")) && (tablero[7].equals("X")))
    	|| ((tablero[2].equals("X")) && (tablero[5].equals("X")) && (tablero[8].equals("X")))
    	|| ((tablero[3].equals("X")) && (tablero[6].equals("X")) && (tablero[9].equals("X")))
    	|| ((tablero[1].equals("X")) && (tablero[5].equals("X")) && (tablero[9].equals("X")))
    	|| ((tablero[3].equals("X")) && (tablero[5].equals("X")) && (tablero[7].equals("X"))))
    		gana(1);	
 
    	else if(((tablero[1].equals("O")) && (tablero[2].equals("O")) && (tablero[3].equals("O")))
    	|| ((tablero[4].equals("O")) && (tablero[5].equals("O")) && (tablero[6].equals("O")))
    	|| ((tablero[7].equals("O")) && (tablero[8].equals("O")) && (tablero[9].equals("O")))
    	|| ((tablero[1].equals("O")) && (tablero[4].equals("O")) && (tablero[7].equals("O")))
    	|| ((tablero[2].equals("O")) && (tablero[5].equals("O")) && (tablero[8].equals("O")))
    	|| ((tablero[3].equals("O")) && (tablero[6].equals("O")) && (tablero[9].equals("O")))
    	|| ((tablero[1].equals("O")) && (tablero[5].equals("O")) && (tablero[9].equals("O")))
    	|| ((tablero[3].equals("O")) && (tablero[5].equals("O")) && (tablero[7].equals("O"))))
    	    gana(2);	
    }
    
    public void gana(int g){
    	estadoBotones(false);
    	btnStart.setText("START");
    	mostrarMensaje("Irabazlea"+ g);
    }
    
    public void empate(){
    	estadoBotones(false);
    	btnStart.setText("START");
    	mostrarMensaje("EMPATE");
    }

    public void mostrarMensaje(String texto){
    	CharSequence mensaje = texto;
    	int duracion = Toast.LENGTH_SHORT;
    	
    	Toast toast = Toast.makeText(this, mensaje, duracion);
    	toast.show();
    }
    
	@Override
	public void onClick(View v) {
		
		if(v.getId()==R.id.bStart){
			if (btnStart.getText().equals("START")){
				btnStart.setText("CANCEL");
				estadoBotones(true);
				inicializar();
			}
			else if (btnStart.getText().equals("CANCEL")){
				btnStart.setText("START");
				estadoBotones(false);
				inicializar();
			}
		}
		else if ((v.getId()==R.id.b1) && (tablero[1].equals(""))){
			meterFitxa(1);
			btn1.setText(tablero[1]);
		}
		else if ((v.getId()==R.id.b2) && (tablero[2].equals(""))){
			meterFitxa(2);
			btn2.setText(tablero[2]);
		}
		else if ((v.getId()==R.id.b3) && (tablero[3].equals(""))){
			meterFitxa(3);
			btn3.setText(tablero[3]);
		}
		else if ((v.getId()==R.id.b4) && (tablero[4].equals(""))){
			meterFitxa(4);
			btn4.setText(tablero[4]);
		}
		else if ((v.getId()==R.id.b5) && (tablero[5].equals(""))){
			meterFitxa(5);
			btn5.setText(tablero[5]);
		}
		else if ((v.getId()==R.id.b6) && (tablero[6].equals(""))){
			meterFitxa(6);
			btn6.setText(tablero[6]);
		}
		else if ((v.getId()==R.id.b7) && (tablero[7].equals(""))){
			meterFitxa(7);
			btn7.setText(tablero[7]);
		}
		else if ((v.getId()==R.id.b8) && (tablero[8].equals(""))){
			meterFitxa(8);
			btn8.setText(tablero[8]);
		}
		else if ((v.getId()==R.id.b9) && (tablero[9].equals(""))){
			meterFitxa(9);
			btn9.setText(tablero[9]);
		}

	}
}
