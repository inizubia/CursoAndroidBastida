package com.example.ariketa11listview;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity{

	private List<String> listaArray = null;
	private ArrayAdapter<String> adaptador = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listaArray = new ArrayList<String>();
		listaArray.add("Iphone");
		listaArray.add("Windows Phone");
		listaArray.add("Android");
		listaArray.add("BlackBerry");
		
		adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaArray);
		setListAdapter(adaptador);
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
	
	public void evento(View vista) {
		listaArray.add("Nuevo");
		adaptador.notifyDataSetChanged();
	}
}
