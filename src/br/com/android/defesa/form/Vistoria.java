package br.com.android.defesa.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.android.defesa.R;

public class Vistoria extends Activity {
	
	
	//private Spinner sp1_orgao,sp2_nacionalidade,sp3_orgao,sp4_nacionalidade;
	private Button bt_proximo;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vistoria);
		
		bt_proximo = (Button) findViewById(R.id.bt_proximo_vistoria);
		
		bt_proximo.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			
				startActivity(new Intent(getApplicationContext(),Social.class));
				
			}
		});
		
		
	}
	
	
	
	
}
