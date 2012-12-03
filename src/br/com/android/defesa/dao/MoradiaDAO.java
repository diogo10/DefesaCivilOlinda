package br.com.android.defesa.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.com.android.defesa.db.DataBaseHelper;
import br.com.android.defesa.model.Moradia;

public class MoradiaDAO {
	
	private static Context ctx;
	DataBaseHelper myDbHelper;

	private static String DB_PATH = "/data/data/br.com.android.defesa/databases/";
	private static String DB_NAME = "defesacivil.db";
	private static String myPa = DB_PATH + DB_NAME;
	private SQLiteDatabase myDataBase;
	
	private static final String tag = "defesacivil";
	
	public MoradiaDAO(Context ctx) {
		this.ctx = ctx;
	}
	
	
	public List<Moradia> getALL() {

		myDataBase = SQLiteDatabase.openDatabase(myPa, null,
				SQLiteDatabase.OPEN_READONLY);
		Cursor rs = myDataBase.rawQuery("SELECT * FROM moradia", null);
		
		List<Moradia> lista;
		try {
			lista = new ArrayList<Moradia>();

			while (rs.moveToNext()) {
				Moradia vo = new Moradia(rs.getInt(0),rs.getDouble(1),rs.getDouble(2));
				lista.add(vo);
			}
			return lista;
			
		} catch (Exception e) {
			Log.i(tag, "e = " + e.getMessage());
		}finally {

			if (rs != null) {
				rs.close();
				myDataBase.close();
			}
		}
		return null;
		
		
	}

	
	
	
	
	
	
	

}
