package com.example.ariketa13listviewsql;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends ListActivity implements OnClickListener{

	private Button btnAceptar;
	private EditText etAsunto;
	private Spinner spDia, spMes, spAno;
	private List<String> listaArray = new ArrayList<String>();
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<Integer> arrayDia = new ArrayList<Integer>();
	private ArrayList<Integer> arrayAno = new ArrayList<Integer>();
	private ArrayAdapter<String> adaptador = null;
	private ArrayAdapter<Integer> adaptadorDia, adaptadorAno;
	private ArrayAdapter<CharSequence> adaptadorMes;
	private int i;
	private BBDD bbdd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnAceptar = (Button)findViewById(R.id.aceptar);
		etAsunto = (EditText)findViewById(R.id.editText);
		spDia = (Spinner)findViewById(R.id.sListaDia);
		spMes = (Spinner)findViewById(R.id.sListaMes);
		spAno = (Spinner)findViewById(R.id.sListaAno);
		
		btnAceptar.setOnClickListener(this);
		
		for (i=1; i<=31;i++)
			arrayDia.add(i);
		
		adaptadorDia = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, arrayDia);
		adaptadorDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spDia.setAdapter(adaptadorDia);
		
		adaptadorMes = ArrayAdapter.createFromResource(this, R.array.mes_array, android.R.layout.simple_spinner_item);
		adaptadorMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spMes.setAdapter(adaptadorMes);
		
		for (i=2000; i<=2100;i++)
			arrayAno.add(i);
		
		adaptadorAno = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, arrayAno);
		//adaptadorDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spAno.setAdapter(adaptadorAno);
		
		adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaArray);
		setListAdapter(adaptador);
		
		bbdd = new BBDD(this, "Tareas", null, 1);
		
		cargar();
	}

	@Override
	protected void onListItemClick(ListView l, View v, final int position, long id) {
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
		alertDialog.setTitle("Borrar Contacto");  
		alertDialog.setMessage("¿ Estas seguro de borrar el contacto ?");            
		alertDialog.setCancelable(false);  
		alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialogo1, int id) {
            	listaArray.remove(position);
            	bbdd.deleteTarea(position);
        		adaptador.notifyDataSetChanged();
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

	@Override
	public void onClick(View v) {
		String d = spDia.getSelectedItem().toString();
		String m = spMes.getSelectedItem().toString();
		String y = spAno.getSelectedItem().toString();
		String asunto = etAsunto.getText().toString();
		bbdd.saveTarea(d, m, y, asunto);
		
		listaArray.clear();
		list = bbdd.selectPlan();
		for(String l: list)
			listaArray.add(l);
		adaptador.notifyDataSetChanged();
		
	}
	
	public void cargar(){
		list = bbdd.selectPlan();
		for(String l: list)
			listaArray.add(l);
		adaptador.notifyDataSetChanged();
	}
}