package com.example.ariketa14agendasqlitecheckbox;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class BorrarActivity extends Activity implements OnClickListener{
	
	private Button btnVolver, btnTodo, btnNada, btnAceptar;
	private BBDD bbdd;
	private ArrayList<Persona> listPersona = new ArrayList<Persona>();
	private ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();
	private ListView lista = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_borrar);
		
		btnVolver = (Button)findViewById(R.id.volver3);
		btnTodo = (Button)findViewById(R.id.todo);
		btnNada = (Button)findViewById(R.id.nada);
		btnAceptar = (Button)findViewById(R.id.borrar3);
		lista = (ListView)findViewById(R.id.listcheck);
		
		btnVolver.setOnClickListener(this);
		btnTodo.setOnClickListener(this);
		btnNada.setOnClickListener(this);
		btnAceptar.setOnClickListener(this);
		
		bbdd = new BBDD(this, "AGENDA", null, 1);
		
		listPersona = bbdd.recuperarAGENDA();
		for(Persona l: listPersona)
			datos.add(new Lista_entrada(R.drawable.ic_launcher,l.getNombre(),l.getApellido(),Integer.toString(l.getId())));
		
		adaptador();
		
	}

	@Override
	public void onClick(View v) {
		
		if(v.getId()==btnVolver.getId()){
			finish();
		}
		else if (v.getId()==btnTodo.getId()){
			int size = lista.getChildCount();

			for (int i=0; i<size;i++)
			{
				LinearLayout layout = (LinearLayout) lista.getChildAt(i);
				CheckBox check = (CheckBox) layout.getChildAt(0);
				check.setChecked(true);
			}		
		}
		else if (v.getId()==btnNada.getId()) {
			int size = lista.getChildCount();
			
			for (int i=0; i<size;i++)
			{
				LinearLayout layout = (LinearLayout) lista.getChildAt(i);
				CheckBox check = (CheckBox) layout.getChildAt(0);
				check.setChecked(false);
			}
		}
		else if (v.getId()==btnAceptar.getId()) {
			int size = lista.getChildCount();
			for (int i=0; i<size;i++)
			{
				LinearLayout layout = (LinearLayout) lista.getChildAt(i);
				CheckBox check = (CheckBox) layout.getChildAt(0);
				if (check.isChecked())
				{
					LinearLayout layout2 = (LinearLayout) layout.getChildAt(2);
					TextView tv = (TextView) layout2.getChildAt(2);
					bbdd.borrarCONTACTO(Integer.parseInt(tv.getText().toString()));
				}
			}
			listPersona = bbdd.recuperarAGENDA();
			datos.clear();
			for(Persona l: listPersona)
				datos.add(new Lista_entrada(R.drawable.ic_launcher,l.getNombre(),l.getApellido(),Integer.toString(l.getId())));

			((Lista_adaptador)lista.getAdapter()).notifyDataSetChanged();

			for (int i=0; i<size;i++)
			{
				LinearLayout layout = (LinearLayout) lista.getChildAt(i);
				CheckBox check = (CheckBox) layout.getChildAt(0);
				check.setChecked(false);
			}
		}
		
	}
	
	private void adaptador() {
		lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos)
		{
			public void onEntrada(Object entrada, View view)
			{
				if (entrada!=null)
				{
					TextView name = (TextView)view.findViewById(R.id.tvFecha);
					if (name!=null)
					{
						name.setText(((Lista_entrada)entrada).getName());
					}
					TextView surname = (TextView)view.findViewById(R.id.tvAsunto);
					if (surname!=null)
					{
						surname.setText(((Lista_entrada)entrada).getSurname());
					}
					TextView id = (TextView)view.findViewById(R.id.tvId);
					if (id!=null)
					{
						id.setText(((Lista_entrada)entrada).getId());
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
