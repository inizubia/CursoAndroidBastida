package com.example.ariketa14agendasqlitecheckbox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.example.ariketa14agendasqlitecheckbox.R;

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
	
	private Button btnReturn, btnAccept, btnSearch, btnVolcar, btnVisual, boton;
	private EditText etNombre, etApellido, etTelefono, etObservacion;
	private Spinner sLista;
	private RadioGroup rg;
	private RadioButton rbNombre, rbApellido, rbTelefono, rbObservacion;
	private ArrayList<Persona> buscaPersonaList = new ArrayList<Persona>(), listAgenda;
	private ArrayList<Button> listBoton = new ArrayList<Button>();
	private LinearLayout ll;
	private ArrayAdapter<CharSequence> adaptador;
	private BBDD bbdd;
	private int aukeratua, selectedId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		btnReturn = (Button)findViewById(R.id.volver);
		btnAccept = (Button)findViewById(R.id.aceptar);
		btnSearch = (Button)findViewById(R.id.buscar);
		btnVolcar = (Button)findViewById(R.id.volcar);
		btnVisual = (Button)findViewById(R.id.visualizar);
		
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
		btnVolcar.setOnClickListener(this);
		btnVisual.setOnClickListener(this);
		
		rg.setOnClickListener(this);
		rg.setOnCheckedChangeListener(this);
		
		ll = (LinearLayout)findViewById(R.id.linerLayoutBotoia);
		
		rbNombre.setOnClickListener(this);
		rbApellido.setOnClickListener(this);
		rbTelefono.setOnClickListener(this);
		rbObservacion.setOnClickListener(this);
		
		rbNombre.setChecked(true);
		btnAccept.setEnabled(false);
		
		bbdd = new BBDD(this, "AGENDA", null, 1);
		
	}

	@Override
	public void onClick(View v) {
		selectedId = rg.getCheckedRadioButtonId();

		if (v.getId()==btnSearch.getId()){
			
			ll.removeAllViews();
			buscaPersonaList.clear();
			listBoton.clear();
			btnAccept.setEnabled(false);
			
			switch(selectedId){
			
				case (R.id.buscar_nombre):	
					buscaPersonaList = bbdd.buscarCONTACTO(etNombre.getText().toString(), "nombre");		
					break;
					
				case (R.id.buscar_apellido):
					buscaPersonaList = bbdd.buscarCONTACTO(etApellido.getText().toString(), "apellido");
					break;
				
				case (R.id.buscar_telefono):
					buscaPersonaList = bbdd.buscarCONTACTO(etTelefono.getText().toString(), "telefono");	
					break;
				
				case (R.id.buscar_observaciones):
					buscaPersonaList = bbdd.buscarCONTACTO(etObservacion.getText().toString(),"observacion");	
					break;
					
				case (R.id.buscar_pueblos):
					buscaPersonaList = bbdd.buscarCONTACTO(sLista.getSelectedItem().toString(),"pueblo");	
					break;		
			}
			for(Persona person : buscaPersonaList)
				crearBoton(person.getId());
		}
		else if (v.getId()==btnAccept.getId()){
			Intent it = getIntent();
			it.putExtra("id", aukeratua);
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
		else if (v.getId()==btnVolcar.getId()) {
			try{
	            FileOutputStream fos = openFileOutput("textFile.txt", MODE_PRIVATE);
	            OutputStreamWriter osw = new OutputStreamWriter(fos);
	            
	            switch(selectedId){
		            case (R.id.buscar_nombre): listAgenda = bbdd.recuperarAGENDAordenado("nombre");
		            		break;
		            case (R.id.buscar_apellido): listAgenda = bbdd.recuperarAGENDAordenado("apellido");
            				break;
		            case (R.id.buscar_telefono): listAgenda = bbdd.recuperarAGENDAordenado("telefono");
            				break;
		            case (R.id.buscar_observaciones): listAgenda = bbdd.recuperarAGENDAordenado("observacion");
            				break;
		            case (R.id.buscar_pueblos): listAgenda = bbdd.recuperarAGENDAordenado("pueblo");
            				break;
	            }

	            for(Persona people: listAgenda){
	            	osw.write(people.toString());
	            	osw.write("\r\n");
	            }
	            osw.flush();
	            osw.close();
	             
	            // Mostramos que se ha guardado
	            Toast.makeText(getBaseContext(), "Guardado", Toast.LENGTH_SHORT).show();
	             
	        }catch (IOException ex){
	            ex.printStackTrace();
	        }
		}
		else if (v.getId()==btnVisual.getId()) {
			Intent i = new Intent(this, VisualActivity.class);
			startActivity(i);		
		}
	}

	public void crearBoton(int id) {
		boton = new Button(this);
		listBoton.add(boton);
		boton.setText(String.valueOf(listBoton.indexOf(boton)+1));
		boton.setId(listBoton.indexOf(boton));
		boton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				aukeratua = buscaPersonaList.get(view.getId()).getId();
				etNombre.setText(buscaPersonaList.get(view.getId()).getNombre());
				etApellido.setText(buscaPersonaList.get(view.getId()).getApellido());
				etTelefono.setText(buscaPersonaList.get(view.getId()).getTel());
				etObservacion.setText(buscaPersonaList.get(view.getId()).getObs());
				
				sLista.setSelection(adaptador.getPosition(buscaPersonaList.get(view.getId()).getPueblo()));
				
				btnAccept.setEnabled(true);
		    }
		});
		ll.addView(boton);
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

}
