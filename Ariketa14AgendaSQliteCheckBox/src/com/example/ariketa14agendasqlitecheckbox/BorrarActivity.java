package com.example.ariketa14agendasqlitecheckbox;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BorrarActivity extends Activity implements OnClickListener{
	
	private Button btnVolver, btnTodo, btnNada, btnAceptar;
	private BBDD bbdd;
	private ArrayList<Persona> listPersona = new ArrayList<Persona>();
	private ArrayList<Lista_entrada> datos = new ArrayList<Lista_entrada>();
	private ListView lista = null;
	private CheckBox cb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_borrar);
		
		btnVolver = (Button)findViewById(R.id.volver3);
		btnTodo = (Button)findViewById(R.id.todo);
		btnNada = (Button)findViewById(R.id.nada);
		btnAceptar = (Button)findViewById(R.id.aceptar3);
		lista = (ListView)findViewById(R.id.listcheck);
		
		cb = (CheckBox)findViewById(R.id.checkbox);
		
		btnVolver.setOnClickListener(this);
		btnTodo.setOnClickListener(this);
		btnNada.setOnClickListener(this);
		btnAceptar.setOnClickListener(this);
		
		bbdd = new BBDD(this, "AGENDA", null, 1);
		
		listPersona = bbdd.recuperarAGENDA();
		for(Persona l: listPersona)
			datos.add(new Lista_entrada(R.drawable.ic_launcher,l.getNombre(),l.getApellido()));
		
		adaptador();
		

	}
	
	/*private class ViewHolder {
		TextView code;
		CheckBox name;
	}*/

	@Override
	public void onClick(View v) {
		
		if(v.getId()==btnVolver.getId()){
			finish();
		}
		else if (v.getId()==btnTodo.getId()){
			//ViewHolder holder = new ViewHolder();
			/*LayoutInflater inflator = context.getLayoutInflater();
		      view = inflator.inflate(R.layout.rowbuttonlayout, null);*/
			/*LayoutInflater vi = (LayoutInflater)getSystemService(
				     Context.LAYOUT_INFLATER_SERVICE);
				   convertView = vi.inflate(R.layout.entrada, null);
			
			holder.code = (TextView) convertView.findViewById(R.id.code);
			holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
			convertView.setTag(holder);*/
			//holder.name = (CheckBox) findViewById(R.id.listcheck);
			//holder.name.setSelected(true);
			
		}
		else if (v.getId()==btnNada.getId()) {
			
		}
		else if (v.getId()==btnAceptar.getId()) {
			
		}
		
	}
	
	private void adaptador() {
		lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos)
		{
			public void onEntrada(Object entrada, View view)
			{
				if (entrada!=null)
				{
					CheckBox box = (CheckBox)view.findViewById(R.id.checkbox);
					if (box!=null)
					{
						box.setSelected((((Lista_entrada)entrada).isSelected()));
					}
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
