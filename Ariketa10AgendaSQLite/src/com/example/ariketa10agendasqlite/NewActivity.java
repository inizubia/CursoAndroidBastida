package com.example.ariketa10agendasqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnFocusChangeListener;

public class NewActivity extends Activity implements OnClickListener, OnFocusChangeListener{
	
	private EditText etNombre, etApellido, etTelefono, etObservacion;
	private Button btnSave, btnCancel;
	private Spinner sLista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new);
		
		btnSave = (Button)findViewById(R.id.guardar);
		btnCancel = (Button)findViewById(R.id.cancelar);
		
		etNombre = (EditText)findViewById(R.id.nombre);
        etApellido = (EditText)findViewById(R.id.apellido);
        etTelefono = (EditText)findViewById(R.id.tel);
        etObservacion = (EditText)findViewById(R.id.obs);
        
        sLista = (Spinner)findViewById(R.id.sLista);
        
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.pueblo_arrays, android.R.layout.simple_spinner_item);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sLista.setAdapter(adaptador);
		
		btnSave.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		
        etNombre.setEnabled(true);
        etApellido.setEnabled(true);
        etTelefono.setEnabled(true);
        etObservacion.setEnabled(true);
        
        etNombre.setOnFocusChangeListener(this);
        etApellido.setOnFocusChangeListener(this);
        etTelefono.setOnFocusChangeListener(this);
        etObservacion.setOnFocusChangeListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if ((v.getId()==R.id.guardar) && formularioBeteta())
		{
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
		else if (v.getId()==R.id.cancelar){
			Intent it = getIntent();
			setResult(RESULT_CANCELED, it);
			finish();
		}	
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if(v.getId()==R.id.nombre){
			if(hasFocus)
				etNombre.setText("");
			else 
	           etNombre.setText(etNombre.getText().toString().toUpperCase());
		}
		else if(v.getId()==R.id.apellido){
			if(hasFocus)
				etApellido.setText("");
			else 
				etApellido.setText(etApellido.getText().toString().toUpperCase());
		}
		else if(v.getId()==R.id.tel){
			if(hasFocus)
				etTelefono.setText("");
			else 
				etTelefono.setText(etTelefono.getText().toString().toUpperCase());
		}
		else if(v.getId()==R.id.obs){
			if(hasFocus)
				etObservacion.setText("");
			else 
				etObservacion.setText(etObservacion.getText().toString().toUpperCase());
		}
	}

	public boolean formularioBeteta(){
    	if(etNombre.getText().toString().equals("") || etApellido.getText().toString().equals("") || etTelefono.getText().toString().equals("") || etObservacion.getText().toString().equals("") )
    		return false;
    	else
    		return true;
    }
}
