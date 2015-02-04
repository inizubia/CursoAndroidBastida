package com.example.ariketa5agenda;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnSave, btnNew, btnEdit, btnDelete, boton;
	private EditText etNombre, etApellido, etTelefono, etObservacion;
	private LinearLayout ll;
	private ArrayList<Persona> listPersona = new ArrayList<Persona>();
	private Persona people;
	private ArrayList<Button> listBoton = new ArrayList<Button>();
	private int i=1, aukeratua;
	private boolean editado=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnSave = (Button)findViewById(R.id.guardar);
        btnNew = (Button)findViewById(R.id.nuevo);
        btnEdit = (Button)findViewById(R.id.editar);
        btnDelete = (Button)findViewById(R.id.borrar);
        
        etNombre = (EditText)findViewById(R.id.nombre);
        etApellido = (EditText)findViewById(R.id.apellido);
        etTelefono = (EditText)findViewById(R.id.tel);
        etObservacion = (EditText)findViewById(R.id.obs);
        
        ll=(LinearLayout)findViewById(R.id.botones);
        
        btnSave.setOnClickListener(this);
        btnNew.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        
        btnDelete.setEnabled(false);
        btnEdit.setEnabled(false);
        btnNew.setEnabled(true);
        btnSave.setEnabled(false);
        
        etNombre.setEnabled(false);
        etApellido.setEnabled(false);
        etTelefono.setEnabled(false);
        etObservacion.setEnabled(false);

    }
    
    @Override
	public void onClick(View v) {
		
		if ((v.getId()==R.id.guardar) && formularioBeteta())
		{
			btnNew.setText("NUEVO");
			people = new Persona(etNombre.getText().toString(), etApellido.getText().toString(), etTelefono.getText().toString(), etObservacion.getText().toString());
			
			if(editado){
				listPersona.set(aukeratua,people);
				editado=false;
				
				btnSave.setEnabled(false);
				
				etNombre.setEnabled(false);
            	etApellido.setEnabled(false);
            	etTelefono.setEnabled(false);
            	etObservacion.setEnabled(false);
			}
			else{
				listPersona.add(people);
				
				etNombre.setText("");		
				etApellido.setText("");
				etTelefono.setText("");
				etObservacion.setText("");
			
				boton = new Button(this);
				listBoton.add(boton);
				i = listBoton.indexOf(boton);
				boton.setText(String.valueOf(i+1));
				boton.setId(i);
				boton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View view) {
						aukeratua= view.getId();
						etNombre.setText(listPersona.get(view.getId()).getNombre());
						etApellido.setText(listPersona.get(view.getId()).getApellido());
						etTelefono.setText(listPersona.get(view.getId()).getTel());
						etObservacion.setText(listPersona.get(view.getId()).getObs());
	            	
		            	btnEdit.setEnabled(true);
		            	btnDelete.setEnabled(true);
		            	btnSave.setEnabled(false);
	            	
		            	etNombre.setEnabled(false);
		            	etApellido.setEnabled(false);
		            	etTelefono.setEnabled(false);
		            	etObservacion.setEnabled(false);
		            }
		        });
				ll.addView(boton);
				
            	btnEdit.setEnabled(false);
            	btnDelete.setEnabled(false);
				btnSave.setEnabled(false);
				
				etNombre.setEnabled(false);
            	etApellido.setEnabled(false);
            	etTelefono.setEnabled(false);
            	etObservacion.setEnabled(false);
			}
		}
		else if (v.getId()==R.id.nuevo)
		{
			if(btnNew.getText().equals("CANCEL")){
				etNombre.setText("");
				etApellido.setText("");
				etTelefono.setText("");
				etObservacion.setText("");
				
				btnSave.setEnabled(false);
		        etNombre.setEnabled(false);
		        etApellido.setEnabled(false);
		        etTelefono.setEnabled(false);
		        etObservacion.setEnabled(false);
		        btnNew.setText("NUEVO");
		        editado=false;
			}
			else {
				etNombre.setText("");
				etApellido.setText("");
				etTelefono.setText("");
				etObservacion.setText("");
				btnSave.setEnabled(true);
				btnDelete.setEnabled(false);
				btnEdit.setEnabled(false);
				
		        etNombre.setEnabled(true);
		        etApellido.setEnabled(true);
		        etTelefono.setEnabled(true);
		        etObservacion.setEnabled(true);        
		        btnNew.setText("CANCEL");
			}

		}
		else if (v.getId()==R.id.borrar){
			/*Button botoia=new Button(this);
			botoia = listBoton.get(aukeratua);
			listPersona.remove(aukeratua);
			listBoton.remove(aukeratua);
			ll.removeView(botoia);*/
			
			etNombre.setText("");
			etApellido.setText("");
			etTelefono.setText("");
			etObservacion.setText("");
			btnSave.setEnabled(false);
        	btnEdit.setEnabled(false);
        	btnDelete.setEnabled(false);
	        etNombre.setEnabled(false);
	        etApellido.setEnabled(false);
	        etTelefono.setEnabled(false);
	        etObservacion.setEnabled(false);
	        
	        listPersona.remove(aukeratua);
			listBoton.remove(aukeratua);
			ll.removeAllViews();
			
			for(int j = 0; j < listBoton.size(); j++){
				boton=listBoton.get(j);
				boton.setText(String.valueOf(j+1));
				boton.setId(j);
				ll.addView(boton);
			}
		}
		else if(v.getId()==R.id.editar){
        	etNombre.setEnabled(true);
        	etApellido.setEnabled(true);
        	etTelefono.setEnabled(true);
        	etObservacion.setEnabled(true);
        	
        	btnSave.setEnabled(true);
        	btnEdit.setEnabled(false);
        	btnDelete.setEnabled(false);
        	
        	editado=true;
        	btnNew.setText("CANCEL");
		}
		
	}
    
    public boolean formularioBeteta(){
    	if(etNombre.getText().toString().equals("") || etApellido.getText().toString().equals("") || etTelefono.getText().toString().equals("") || etObservacion.getText().toString().equals("") )
    		return false;
    	else
    		return true;
    }

}
