package com.example.ariketa13listviewsql;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class Lista_adaptador extends BaseAdapter{
	
	private ArrayList<?> entradas;
	private int R_layout_IdView;
	private Context contexto;
	
	public Lista_adaptador(Context contexto, int R_layout_IdView, ArrayList<?> entradas)
	{
		super();
		this.contexto=contexto;
		this.R_layout_IdView=R_layout_IdView;
		this.entradas=entradas;
	}
	public View getView(int posicion, View view, ViewGroup pariente)
	{
		if (view==null)
		{
			LayoutInflater vi = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R_layout_IdView, null);
		}
		onEntrada(entradas.get(posicion), view);
		return view;
	}
	public int getCount()
	{
		return entradas.size();
	}
	public Object getItem(int posicion)
	{
		return entradas.get(posicion);
	}
	public long getItemId(int posicion)
	{
		return posicion;
	}
	public abstract void onEntrada(Object entrada, View view);
}
