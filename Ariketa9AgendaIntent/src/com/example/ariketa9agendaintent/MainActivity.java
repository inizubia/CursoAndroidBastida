package com.example.ariketa9agendaintent;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnNew, btnEdit, btnDelete, btnSearch, boton;
	private EditText etNombre, etApellido, etTelefono, etObservacion, etPueblo;
	private Persona people;
	private ArrayList<Persona> listPersona = new ArrayList<Persona>();
	private ArrayList<Button> listBoton = new ArrayList<Button>();
	private LinearLayout ll;
	private int i=1, aukeratua;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnNew = (Button) findViewById(R.id.nuevo);
        btnEdit = (Button)findViewById(R.id.editar);
        btnDelete = (Button)findViewById(R.id.borrar);
        btnSearch = (Button)findViewById(R.id.buscar);
        
        etNombre = (EditText)findViewById(R.id.nombre);
        etApellido = (EditText)findViewById(R.id.apellido);
        etTelefono = (EditText)findViewById(R.id.tel);
        etObservacion = (EditText)findViewById(R.id.obs);
        etPueblo = (EditText)findViewById(R.id.pueblo);
        
        ll=(LinearLayout)findViewById(R.id.botones);
        
        etNombre.setEnabled(false);
        etApellido.setEnabled(false);
        etTelefono.setEnabled(false);
        etObservacion.setEnabled(false);
        etPueblo.setEnabled(false);
        
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        
		btnNew.setOnClickListener(this);
		btnEdit.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		btnSearch.setOnClickListener(this);	
		
	}

	@Override
	public void onClick(View v) {
		
		if (v.getId()==R.id.nuevo){
			Intent i = new Intent(this, NewActivity.class);
			startActivityForResult(i, 1);
		}
		else if (v.getId()==R.id.editar){
			Intent i = new Intent(this, EditActivity.class);
			i.putExtra("persona", listPersona.get(aukeratua));
			startActivityForResult(i, 2);
		}
		else if (v.getId()==R.id.borrar){
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("Borrar Contacto");  
			alertDialog.setMessage("¿ Estas seguro de borrar el contacto "+ listPersona.get(aukeratua).getNombre()+" ?");            
			alertDialog.setCancelable(false);  
			alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	            	vaciarCampos();
	    			
	    			btnEdit.setEnabled(false);
	    			btnDelete.setEnabled(false);
	    	        
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
	        });  
			alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	                //EZER EZ;
	            }  
	        });
			alertDialog.setIcon(R.drawable.ic_launcher);
			alertDialog.show();		
		}
		else if (v.getId()==R.id.buscar){
			Intent i = new Intent(this, SearchActivity.class);			
			i.putExtra("array", listPersona);
			startActivityForResult(i, 3);
		}
	}

	@Override
	protected void onActivityResult(int id, int result, Intent data) {
		
		switch(id){
		
		case 1:
			if (result == RESULT_OK){			
				people = new Persona(data.getExtras().getString("izena"), data.getExtras().getString("abizena"), data.getExtras().getString("tel"), data.getExtras().getString("obj"), data.getExtras().getString("herria"));
				listPersona.add(people);
				
				vaciarCampos();
				
				boton = new Button(this);
				listBoton.add(boton);
				i = listBoton.indexOf(boton);
				boton.setText(String.valueOf(i+1));
				boton.setId(i);
				boton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View view) {
						aukeratua=view.getId();
						etNombre.setText(listPersona.get(view.getId()).getNombre());
						etApellido.setText(listPersona.get(view.getId()).getApellido());
						etTelefono.setText(listPersona.get(view.getId()).getTel());
						etObservacion.setText(listPersona.get(view.getId()).getObs());
						etPueblo.setText(listPersona.get(view.getId()).getPueblo());
						
						btnEdit.setEnabled(true);
						btnDelete.setEnabled(true);
		            }
		        });

            	btnEdit.setEnabled(false);
            	btnDelete.setEnabled(false);
				
				ll.addView(boton);
			}
			else{
				vaciarCampos();
			}
			break;
		case 2:
			if (result == RESULT_OK){	
				/*etNombre.setText(data.getExtras().getString("izena"));
				etApellido.setText(data.getExtras().getString("abizena"));
				etTelefono.setText(data.getExtras().getString("tel"));
				etObservacion.setText(data.getExtras().getString("obj"));
				etPueblo.setText(data.getExtras().getString("herria"));*/
				//people = new Persona(etNombre.getText().toString(), etApellido.getText().toString(), etTelefono.getText().toString(), etObservacion.getText().toString(), etPueblo.getText().toString());
				people = (Persona) data.getSerializableExtra("persona");
				listPersona.set(aukeratua,people);
				
				etNombre.setText(people.getNombre());
				etApellido.setText(people.getApellido());
				etTelefono.setText(people.getTel());
				etObservacion.setText(people.getObs());
				etPueblo.setText(people.getPueblo());
				
				//vaciarCampos();
            	//btnEdit.setEnabled(false);
            	//btnDelete.setEnabled(false);
			}
			break;
		case 3:
			if (result == RESULT_OK){
				etNombre.setText(data.getExtras().getString("izena"));
				etApellido.setText(data.getExtras().getString("abizena"));
				etTelefono.setText(data.getExtras().getString("tel"));
				etObservacion.setText(data.getExtras().getString("obj"));
				etPueblo.setText(data.getExtras().getString("herria"));
				
				for (int i=0; i < listPersona.size(); i++)
					if(listPersona.get(i).getNombre().equals(etNombre.getText().toString())){
						aukeratua = i;
						break;
					}
				}
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);
		}
	}

	public void vaciarCampos() {
		etNombre.setText("");
		etApellido.setText("");
		etTelefono.setText("");
		etObservacion.setText("");
		etPueblo.setText("");
	}	

}
