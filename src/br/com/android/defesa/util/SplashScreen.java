package br.com.android.defesa.util;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.os.Handler;
import br.com.android.defesa.Main;
import br.com.android.defesa.R;
import br.com.android.defesa.db.DataBaseHelper;

public class SplashScreen extends Activity implements Runnable {

	// 5 segundos
	private final int DELAY = 5000;// variavel responsavel pela duração da Tela
	

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.layout_splash);
		Handler h = new Handler();
		
		DataBaseHelper myDbHelper = new DataBaseHelper(this);

		try {

			myDbHelper.createDataBase();

		} catch (IOException ioe) {

			throw new Error("Unable to create database");

		}

		try {

			myDbHelper.openDataBase();

		} catch (SQLException sqle) {

			throw sqle;

		}
		
		
			myDbHelper.close();
			h.postDelayed(this, DELAY);
		

	}

	public void run() {

		startActivity(new Intent(this, Main.class));

		finish();

	}

}
