package br.com.android.defesa.form;

import br.com.android.defesa.Main;
import br.com.android.defesa.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intervencoes extends Activity {

	private Button bt_finalizar_inter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intervencoes);
		
		bt_finalizar_inter = (Button) findViewById(R.id.bt_finalizar_intervencoes);
		
		bt_finalizar_inter.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			
				startActivity(new Intent(getApplicationContext(),Main.class));
				finish();
			}
		});
		
	}
	
	
}
