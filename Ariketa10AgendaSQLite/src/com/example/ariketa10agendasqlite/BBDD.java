package com.example.ariketa10agendasqlite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BBDD extends SQLiteOpenHelper{
	
	private SQLiteDatabase sqlDB;
	
	public BBDD(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}	
	
	@Override
	public void onCreate(SQLiteDatabase sqlDB) {
		sqlDB.execSQL("CREATE TABLE if not exists Personas (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre varchar(30), apellido varchar(30), telefono varchar(30), observacion varchar(30), pueblo varchar(30))");		
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlDB, int oldVersion, int newVersion) {
		sqlDB.execSQL("DROP TABLE IF EXISTS Personas");
		sqlDB.execSQL("CREATE TABLE Personas (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre varchar(30), apellido varchar(30), telefono varchar(30), observacion varchar(30), pueblo varchar(30))");	
	}

	public ArrayList<Persona> recuperarAGENDA() {
	    sqlDB = getReadableDatabase();
	    ArrayList<Persona> lista_contactos = new ArrayList<Persona>();
	    
	    String[] valores_recuperar = {"_id", "nombre", "apellido", "telefono", "observacion", "pueblo"};
	    Cursor c = sqlDB.query("Personas", valores_recuperar, null, null, null, null, null, null);
	    if (c.moveToFirst()){
		    do {
		    	Persona contactos = new Persona(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
		    	lista_contactos.add(contactos);
		    } while (c.moveToNext());
	    }
	    c.close();
	    sqlDB.close();
	    return lista_contactos;
	}	
	
	public Persona recuperarCONTACTO(int id) {
	    sqlDB = getReadableDatabase();
	    
	    String[] valores_recuperar = {"_id", "nombre", "apellido", "telefono", "observacion", "pueblo"};
	    Cursor c = sqlDB.query("Personas", valores_recuperar, "_id=" + id, null, null, null, null, null);
	    if(c != null) {
	        c.moveToFirst();
	    }
	    Persona contactos = new Persona(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
	    c.close();
	    sqlDB.close();
	    return contactos;
	}
	
	public int guardarCONTACTO(String nombre, String apellido, String telefono, String observacion, String pueblo) {
		 sqlDB = getWritableDatabase();
        sqlDB.execSQL("INSERT INTO Personas VALUES ( null, '"+nombre+"', '"+apellido+"', '"+telefono+"', '"+observacion+"', '"+pueblo+"')");
        
        String[] valores_recuperar = {"_id"};
        Cursor c = sqlDB.query("Personas", valores_recuperar, null, null, null, null, null, null);
        c.moveToLast();
        int id = c.getInt(0);
        
        c.close();
        sqlDB.close();
        
        return id;
	}
	
	public void modificarCONTACTO(int id, String nom, String apel, String tlf, String obs, String pu){
	    sqlDB = getWritableDatabase();
	    ContentValues valores = new ContentValues();
	    valores.put("_id", id);
	    valores.put("nombre", nom);
	    valores.put("apellido", apel);
	    valores.put("telefono", tlf);
	    valores.put("observacion", obs);
	    valores.put("pueblo", pu);
	    sqlDB.update("Personas", valores, "_id=" + id, null);
	    sqlDB.close();   
	}
	
	public void borrarCONTACTO(int id) {
	    sqlDB = getWritableDatabase();
	    //db.execSQL("DELETE FROM Personas WHERE _id="+id);
	    sqlDB.delete("Personas", "_id="+id, null);
	    sqlDB.close();  
	}

	public ArrayList<Persona> buscarCONTACTO(String nom, String aukera) {
		sqlDB = getReadableDatabase();
	    ArrayList<Persona> busca_contactos = new ArrayList<Persona>();
	   
	    String sqlQuery = "SELECT * FROM Personas where "+aukera+" like '%" + nom + "%'";
	    Cursor c = sqlDB.rawQuery(sqlQuery, null);
	    
	    if (c.moveToFirst()){
		    do {
		    	Persona contactos = new Persona(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
		    	busca_contactos.add(contactos);
		    } while (c.moveToNext());
	    }
	    c.close();
	    sqlDB.close();
	       
	    return busca_contactos;	
	}
	
	public ArrayList<Persona> recuperarAGENDAordenado(String aukera) {
		sqlDB = getReadableDatabase();
	    ArrayList<Persona> busca_contactos = new ArrayList<Persona>();
	   
	    String sqlQuery = "SELECT * FROM Personas GROUP BY "+aukera;
	    Cursor c = sqlDB.rawQuery(sqlQuery, null);
	    
	    if (c.moveToFirst()){
		    do {
		    	Persona contactos = new Persona(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
		    	busca_contactos.add(contactos);
		    } while (c.moveToNext());
	    }
	    c.close();
	    sqlDB.close();
	       
	    return busca_contactos;	
	}
}
