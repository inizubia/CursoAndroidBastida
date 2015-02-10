package com.example.ariketa13listviewsql;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private Button btnAceptar;
	private EditText etAsunto;
	private Spinner spDia, spMes, spAno;
	private ArrayList<Integer> arrayDia = new ArrayList<Integer>();
	private ArrayList<Integer> arrayAno = new ArrayList<Integer>();
	private ArrayAdapter<Integer> adaptadorDia, adaptadorAno;
	private ArrayAdapter<CharSequence> adaptadorMes;
	private int i;
	private BBDD bbdd;
	private ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();
	private ArrayList<String[]> list = new ArrayList<String[]>();
	private ListView lista = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnAceptar = (Button)findViewById(R.id.aceptar);
		etAsunto = (EditText)findViewById(R.id.editText);
		spDia = (Spinner)findViewById(R.id.sListaDia);
		spMes = (Spinner)findViewById(R.id.sListaMes);
		spAno = (Spinner)findViewById(R.id.sListaAno);
		lista = (ListView)findViewById(R.id.list);
		
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
		
		//adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaArray);
		//setListAdapter(adaptador);
		
		bbdd = new BBDD(this, "Tareas", null, 1);
		
		cargar();		
		adaptador();
		
		lista.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id)
			{
				datos.remove(posicion);
				((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();
				bbdd.deleteTarea(posicion);
			}
		});
	}

	@Override
	public void onClick(View v) {
		String d = spDia.getSelectedItem().toString();
		String m = spMes.getSelectedItem().toString();
		String y = spAno.getSelectedItem().toString();
		String asunto = etAsunto.getText().toString();
		bbdd.saveTarea(d, m, y, asunto);
		
		datos.clear();
		list = bbdd.selectPlan();
		for(String[] l: list)
			datos.add(new Lista_entrada(R.drawable.ic_launcher,l[0],l[1]));

		((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();
		etAsunto.setText("");
	}
	
	public void cargar(){
		list = bbdd.selectPlan();
		for(String[] l: list)
			datos.add(new Lista_entrada(R.drawable.ic_launcher,l[0],l[1]));
	}
	
	private void adaptador() {
		lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos)
		{
			public void onEntrada(Object entrada, View view)
			{
				if (entrada!=null)
				{
					TextView fecha = (TextView)view.findViewById(R.id.tvFecha);
					if (fecha!=null)
					{
						fecha.setText(((Lista_entrada)entrada).getFecha());
					}
					TextView asunto = (TextView)view.findViewById(R.id.tvAsunto);
					if (asunto!=null)
					{
						asunto.setText(((Lista_entrada)entrada).getAsunto());
					}
					ImageView imagen = (ImageView)view.findViewById(R.id.imagen);
					if (imagen!=null)
					{
						imagen.setImageResource(((Lista_entrada)entrada).getIdImagen());
					}
				}
			}
		});
		
	}
}