package com.example.ariketa14agendasqlitecheckbox;

import com.example.ariketa14agendasqlitecheckbox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditActivity extends Activity implements OnClickListener{
	
	private EditText etNombre, etApellido, etTelefono, etObservacion;
	private Button btnSave, btnCancel;
	private Spinner sLista;
	private Persona persona = new Persona();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		
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
        
        persona = (Persona) getIntent().getExtras().getSerializable("persona");
		
        etNombre.setText(persona.getNombre());
		etApellido.setText(persona.getApellido());
		etTelefono.setText(persona.getTel());
		etObservacion.setText(persona.getObs());
		sLista.setSelection(adaptador.getPosition(persona.getPueblo()));	
	}

	@Override
	public void onClick(View v) {
		if ((v.getId()==R.id.guardar) && formularioBeteta())
		{
			persona.setNombre(etNombre.getText().toString());
			persona.setApellido(etApellido.getText().toString());
			persona.setTel(etTelefono.getText().toString());
			persona.setObs(etObservacion.getText().toString());
			persona.setPueblo(sLista.getSelectedItem().toString());
			
			Intent it = getIntent();	
			it.putExtra("persona", persona);
			
			setResult(RESULT_OK, it);
			finish();
		}
		else if (v.getId()==R.id.cancelar){
			Intent it = getIntent();
			setResult(RESULT_CANCELED, it);
			finish();
		}	
	}
	
	public boolean formularioBeteta(){
    	if(etNombre.getText().toString().equals("") || etApellido.getText().toString().equals("") || etTelefono.getText().toString().equals("") || etObservacion.getText().toString().equals("") )
    		return false;
    	else
    		return true;
    }
	
}
