package com.example.ariketa14agendasqlitecheckbox;

import java.util.ArrayList;

import com.example.ariketa14agendasqlitecheckbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	private Button btnNew, btnEdit, btnDelete, btnSearch, boton;
	private EditText etNombre, etApellido, etTelefono, etObservacion, etPueblo;
	private Persona people = new Persona();
	private ArrayList<Persona> listPersona = new ArrayList<Persona>();
	private ArrayList<Button> listBoton = new ArrayList<Button>();
	private LinearLayout ll;
	private int aukeratua;
	private BBDD bbdd;

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
        
		btnNew.setOnClickListener(this);
		btnEdit.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
		
		bbdd = new BBDD(this, "AGENDA", null, 1);
		
		cargarBotones();
	}

	@Override
	public void onClick(View v) {
		
		if (v.getId()==R.id.nuevo){
			Intent i = new Intent(this, NewActivity.class);
			startActivityForResult(i, 1);
		}
		else if (v.getId()==R.id.editar){
			people = bbdd.recuperarCONTACTO(aukeratua);
			
			Intent i = new Intent(this, EditActivity.class);
			i.putExtra("persona", people);
			startActivityForResult(i, 2);
		}
		else if (v.getId()==R.id.borrar){
	    			
			Intent i = new Intent(this, BorrarActivity.class);
			startActivityForResult(i, 3);	
		}
		else if (v.getId()==R.id.buscar){
			Intent i = new Intent(this, SearchActivity.class);			
			//i.putExtra("array", listPersona);
			startActivityForResult(i, 4);
		}
	}

	@Override
	protected void onActivityResult(int id, int result, Intent data) {
		
		switch(id){
		
		case 1:
			if (result == RESULT_OK){
				int key = bbdd.guardarCONTACTO(data.getExtras().getString("izena"), data.getExtras().getString("abizena"), data.getExtras().getString("tel"), data.getExtras().getString("obj"), data.getExtras().getString("herria"));
				people = new Persona(key, data.getExtras().getString("izena"), data.getExtras().getString("abizena"), data.getExtras().getString("tel"), data.getExtras().getString("obj"), data.getExtras().getString("herria"));
				listPersona.add(people);
					
				vaciarCampos();
				
				boton = new Button(this);
				listBoton.add(boton);
				boton.setText(String.valueOf(listBoton.indexOf(boton)+1));
				boton.setId(people.getId());
				boton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View view) {
						aukeratua=view.getId();
						people = bbdd.recuperarCONTACTO(aukeratua);
						etNombre.setText(people.getNombre());
						etApellido.setText(people.getApellido());
						etTelefono.setText(people.getTel());
						etObservacion.setText(people.getObs());
						etPueblo.setText(people.getPueblo());
						Toast.makeText(getApplicationContext(), "id: "+aukeratua, Toast.LENGTH_SHORT).show();
						
						btnEdit.setEnabled(true);
		            }
		        });
				
            	btnEdit.setEnabled(false);
				
				ll.addView(boton);
			}
			else{
				vaciarCampos();
			}
			break;
		case 2:
			if (result == RESULT_OK){	
				
				people = (Persona) data.getSerializableExtra("persona");
						
				bbdd.modificarCONTACTO(people.getId(), people.getNombre(), people.getApellido(), people.getTel(), people.getObs(), people.getPueblo());
				listPersona = bbdd.recuperarAGENDA();
				
				etNombre.setText(people.getNombre());
				etApellido.setText(people.getApellido());
				etTelefono.setText(people.getTel());
				etObservacion.setText(people.getObs());
				etPueblo.setText(people.getPueblo());
			}
			break;
		case 3:
			ll.removeAllViews();
			listPersona.clear();
			listBoton.clear();
			cargarBotones();
			vaciarCampos();
			break;
		case 4:
			if (result == RESULT_OK){
				people = new Persona(data.getExtras().getInt("id"), data.getExtras().getString("izena"), data.getExtras().getString("abizena"), data.getExtras().getString("tel"), data.getExtras().getString("obj"), data.getExtras().getString("herria"));
				aukeratua = data.getExtras().getInt("id");
				etNombre.setText(data.getExtras().getString("izena"));
				etApellido.setText(data.getExtras().getString("abizena"));
				etTelefono.setText(data.getExtras().getString("tel"));
				etObservacion.setText(data.getExtras().getString("obj"));
				etPueblo.setText(data.getExtras().getString("herria"));
			}
			btnEdit.setEnabled(true);
			
			break;
		}
	}

	public void vaciarCampos() {
		etNombre.setText("");
		etApellido.setText("");
		etTelefono.setText("");
		etObservacion.setText("");
		etPueblo.setText("");
	}
	
	private void cargarBotones() {
		listPersona = bbdd.recuperarAGENDA();
		for(Persona person : listPersona)
			crearBoton(person.getId());
	}
	
	public void crearBoton(int id) {
		boton = new Button(this);
		listBoton.add(boton);
		boton.setText(String.valueOf(listBoton.indexOf(boton)+1));
		boton.setId(id);
		boton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				aukeratua=view.getId();
				people = bbdd.recuperarCONTACTO(aukeratua);
				etNombre.setText(people.getNombre());
				etApellido.setText(people.getApellido());
				etTelefono.setText(people.getTel());
				etObservacion.setText(people.getObs());
				etPueblo.setText(people.getPueblo());
				Toast.makeText(getApplicationContext(), "id: "+aukeratua+ " etNombre: "+people.getNombre(), Toast.LENGTH_SHORT).show();
				
				btnEdit.setEnabled(true);
		    }
		});
		ll.addView(boton);
	}
}
