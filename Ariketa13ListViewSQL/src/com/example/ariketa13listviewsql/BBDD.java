package com.example.ariketa13listviewsql;

import java.util.ArrayList;

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
		sqlDB.execSQL("CREATE TABLE if not exists Plan (_id INTEGER PRIMARY KEY AUTOINCREMENT, day varchar(30), mounth varchar(30), year varchar(30), issue varchar(30))");		
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlDB, int oldVersion, int newVersion) {
		sqlDB.execSQL("DROP TABLE IF EXISTS Plan");
		sqlDB.execSQL("CREATE TABLE Plan (_id INTEGER PRIMARY KEY AUTOINCREMENT, day varchar(30), mounth varchar(30), year varchar(30), issue varchar(30))");	
	}

	public ArrayList<String> selectPlan() {
	    sqlDB = getReadableDatabase();
	    ArrayList<String> lista = new ArrayList<String>();
	    
	    String[] valores_recuperar = {"_id", "day", "mounth", "year", "issue"};
	    Cursor c = sqlDB.query("Plan", valores_recuperar, null, null, null, null, null, null);
	    if (c.moveToFirst()){
		    do {
		    	lista.add(c.getString(1)+" "+c.getString(2)+" "+c.getString(3)+" "+c.getString(4));
		    } while (c.moveToNext());
	    }
	    c.close();
	    sqlDB.close();
	    return lista;
	}
	
	public void saveTarea(String d, String m, String y, String i) {
		sqlDB = getWritableDatabase();
        sqlDB.execSQL("INSERT INTO Plan VALUES ( null, '"+d+"', '"+m+"', '"+y+"', '"+i+"')");;
        sqlDB.close();
	}
	
	public void deleteTarea(int position) {
	    sqlDB = getReadableDatabase();
	    Cursor c = sqlDB.rawQuery("SELECT * FROM Plan", null);
	    c.moveToPosition(position);
	    int id = c.getInt(0);
	    sqlDB = getWritableDatabase();
	    sqlDB.execSQL("DELETE FROM Plan WHERE _id="+id);
	    c.close();
	    sqlDB.close();  
	}

}
