package com.example.ariketa9agendaintent;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class SearchActivity extends Activity implements OnClickListener, OnCheckedChangeListener{
	
	private Button btnReturn, btnAccept, btnSearch, boton;
	private EditText etNombre, etApellido, etTelefono, etObservacion;
	private Spinner sLista;
	private RadioGroup rg;
	private RadioButton rbNombre, rbApellido, rbTelefono, rbObservacion;
	private ArrayList<Persona> listPersona, buscaPersonaList = new ArrayList<Persona>();
	private ArrayList<Button> listBoton = new ArrayList<Button>();
	private Persona person;
	private LinearLayout ll;
	private int j;
	private ArrayAdapter<CharSequence> adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		btnReturn = (Button)findViewById(R.id.volver);
		btnAccept = (Button)findViewById(R.id.aceptar);
		btnSearch = (Button)findViewById(R.id.buscar);
		
		etNombre = (EditText)findViewById(R.id.nom);
		etApellido = (EditText)findViewById(R.id.apel);
		etTelefono = (EditText)findViewById(R.id.tel);
		etObservacion = (EditText)findViewById(R.id.obs);
		
		rg = (RadioGroup)findViewById(R.id.radioGroup);
		
		rbNombre = (RadioButton)findViewById(R.id.buscar_nombre);
		rbApellido = (RadioButton)findViewById(R.id.buscar_apellido);
		rbTelefono = (RadioButton)findViewById(R.id.buscar_telefono);
		rbObservacion = (RadioButton)findViewById(R.id.buscar_observaciones);
		
		sLista = (Spinner)findViewById(R.id.sLista);
        
        adaptador = ArrayAdapter.createFromResource(this, R.array.pueblo_arrays, android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sLista.setAdapter(adaptador);
		
		btnReturn.setOnClickListener(this);
		btnAccept.setOnClickListener(this);
		btnSearch.setOnClickListener(this);
		
		rg.setOnClickListener(this);
		rg.setOnCheckedChangeListener(this);
		
		ll = (LinearLayout)findViewById(R.id.linerLayoutBotoia);
		
		rbNombre.setOnClickListener(this);
		rbApellido.setOnClickListener(this);
		rbTelefono.setOnClickListener(this);
		rbObservacion.setOnClickListener(this);
		
		listPersona = (ArrayList<Persona>)getIntent().getExtras().getSerializable("array");
		
		rbNombre.setChecked(true);
		btnAccept.setEnabled(false);
		
	}

	@Override
	public void onClick(View v) {
		int selectedId = rg.getCheckedRadioButtonId();

		if (v.getId()==btnSearch.getId()){
			
			ll.removeAllViews();
			buscaPersonaList.clear();
			listBoton.clear();
			j=1;
			btnAccept.setEnabled(false);
			
			person = new Persona(etNombre.getText().toString(), etApellido.getText().toString(), etTelefono.getText().toString(),etObservacion.getText().toString(), sLista.getSelectedItem().toString());
			
			switch(selectedId){
			
				case (R.id.buscar_nombre):			
					buscarPersonas(person.getNombre(),1);	
					break;
					
				case (R.id.buscar_apellido):
					buscarPersonas(person.getApellido(),2);	
					break;
				
				case (R.id.buscar_telefono):
					buscarPersonas(person.getTel(),3);	
					break;
				
				case (R.id.buscar_observaciones):
					buscarPersonas(person.getObs(),4);	
					break;
					
				case (R.id.buscar_pueblos):
					buscarPersonas(person.getPueblo(),5);	
					break;		
			}
		}
		else if (v.getId()==btnAccept.getId()){
			Intent it = getIntent();
			it.putExtra("izena", etNombre.getText().toString());
			it.putExtra("abizena", etApellido.getText().toString());
			it.putExtra("tel", etTelefono.getText().toString());
			it.putExtra("obj", etObservacion.getText().toString());
			
			String texto = sLista.getSelectedItem().toString();
			it.putExtra("herria", texto);
			
			setResult(RESULT_OK, it);
			finish();
		}
		else if (v.getId()==btnReturn.getId()){
			Intent it = getIntent();
			setResult(RESULT_CANCELED, it);
			finish();			
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		
		etNombre.setText("");
		etApellido.setText("");
		etTelefono.setText("");
		etObservacion.setText("");
		
		ll.removeAllViews();
		buscaPersonaList.clear();
		listBoton.clear();
		j=1;
		btnAccept.setEnabled(false);
		 
		if(checkedId == rbNombre.getId()) {
			Toast.makeText(getApplicationContext(), "choice: nombre", Toast.LENGTH_SHORT).show();
			
			etNombre.setEnabled(true);
			etApellido.setEnabled(false);
			etTelefono.setEnabled(false);
			etObservacion.setEnabled(false);
			sLista.setEnabled(false);
			
			etNombre.requestFocus();
			
		} else if(checkedId == R.id.buscar_apellido) {
			Toast.makeText(getApplicationContext(), "choice: Apellido", Toast.LENGTH_SHORT).show();
			
			etNombre.setEnabled(false);
			etApellido.setEnabled(true);
			etTelefono.setEnabled(false);
			etObservacion.setEnabled(false);
			sLista.setEnabled(false);
			
			etApellido.requestFocus();
			
		} else if(checkedId == R.id.buscar_telefono){
			Toast.makeText(getApplicationContext(), "choice: Telefono", Toast.LENGTH_SHORT).show();
			
			etNombre.setEnabled(false);
			etApellido.setEnabled(false);
			etTelefono.setEnabled(true);
			etObservacion.setEnabled(false);
			sLista.setEnabled(false);
			
			etTelefono.requestFocus();
			
		} else if(checkedId == R.id.buscar_observaciones){
			Toast.makeText(getApplicationContext(), "choice: Observacion", Toast.LENGTH_SHORT).show();
			
			etNombre.setEnabled(false);
			etApellido.setEnabled(false);
			etTelefono.setEnabled(false);
			etObservacion.setEnabled(true);
			sLista.setEnabled(false);
			
			etObservacion.requestFocus();
			
		} else if(checkedId == R.id.buscar_pueblos){
		Toast.makeText(getApplicationContext(), "choice: Pueblo", Toast.LENGTH_SHORT).show();
		
			etNombre.setEnabled(false);
			etApellido.setEnabled(false);
			etTelefono.setEnabled(false);
			etObservacion.setEnabled(false);
			sLista.setEnabled(true);
			
			sLista.requestFocus();
		}
	}
	
	public void buscarPersonas(String texto, int index){
		switch (index) {
		case 1:
			for(Persona people : listPersona)
				if ((people.getNombre().contains(texto.toString().toUpperCase())) || (people.getNombre().contains(texto.toString())))
					crearBoton(people);				
			break;
		case 2:
			for(Persona people : listPersona)
				if ((people.getApellido().contains(texto.toString().toUpperCase())) || (people.getApellido().contains(texto.toString())))
					crearBoton(people);	
			break;
		case 3:
			for(Persona people : listPersona)
				if ((people.getTel().contains(texto.toString().toUpperCase())) || (people.getTel().contains(texto.toString())))
					crearBoton(people);	
			break;
		case 4:
			for(Persona people : listPersona)
				if ((people.getObs().contains(texto.toString().toUpperCase())) || (people.getObs().contains(texto.toString())))
					crearBoton(people);	
			break;	
		case 5:
			for(Persona people : listPersona)
				if (people.getPueblo().contains(texto.toString()))
					crearBoton(people);	
			break;	
		default:
			break;
		}	
	}

	public void crearBoton(Persona people) {
		boton = new Button(this);
		listBoton.add(boton);
		buscaPersonaList.add(people);
		j = listBoton.indexOf(boton);
		boton.setText(String.valueOf(j+1));
		boton.setId(j);
		boton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				etNombre.setText(buscaPersonaList.get(view.getId()).getNombre());
				etApellido.setText(buscaPersonaList.get(view.getId()).getApellido());
				etTelefono.setText(buscaPersonaList.get(view.getId()).getTel());
				etObservacion.setText(buscaPersonaList.get(view.getId()).getObs());
				
				sLista.setSelection(adaptador.getPosition(buscaPersonaList.get(view.getId()).getPueblo()));
				
				/*for (int i=0;i < sLista.getCount(); i++){
					if(sLista.getItemAtPosition(i).equals(buscaPersonaList.get(view.getId()).getPueblo())){
						int index=i;
						break;
					}		
				}
				sLista.setSelection(index);*/
				
				btnAccept.setEnabled(true);
		    }
		});
		ll.addView(boton);
	}
}
