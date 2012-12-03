package br.com.android.defesa.form;

import br.com.android.defesa.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Social extends Activity {

	private Button bt_proximo_social;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.social);
		
		bt_proximo_social = (Button) findViewById(R.id.bt_proximo_social);
		
		bt_proximo_social.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			
				startActivity(new Intent(getApplicationContext(),Intervencoes.class));
				
			}
		});
		
		
	}
	
	
}
