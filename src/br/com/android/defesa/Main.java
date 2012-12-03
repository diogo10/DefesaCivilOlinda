package br.com.android.defesa;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import br.com.android.defesa.form.Vistoria;

public class Main extends Activity {

	private Button bt_mapa;
	private Button bt_vistoria;
	
	private String latitude;
	private String longitude;
	private String endereco;
	
	
	private static final String tag = "defesacivil";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	
	    bt_mapa = (Button) findViewById(R.id.bt2);
	    bt_vistoria = (Button) findViewById(R.id.bt1);
	    
	    
	    bt_vistoria.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				Intent intent = new Intent(getApplicationContext(),Vistoria.class);
				
				
				LocationManager LM = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
				String bestProvider = LM.getBestProvider(new Criteria(),true);
				Location l = LM.getLastKnownLocation(bestProvider);

				if(l!=null){
					
					latitude = String.valueOf(l.getLatitude());
					longitude = String.valueOf(l.getLongitude());
					
					
					String add = "";

					Geocoder geoCoder = new Geocoder(
		                    getApplicationContext(), Locale.getDefault());
		                try {
		                    List<Address> addresses = geoCoder.getFromLocation(l.getLatitude()/1E6,l.getLongitude()/1E6, 1);
		 
		                    
		                    if (addresses.size() > 0) 
		                    {
		                        for (int i=0; i<addresses.get(0).getMaxAddressLineIndex(); 
		                             i++)
		                           add += addresses.get(0).getAddressLine(i) + "\n";
		                    }
		 
		                    Log.i(tag,"add = " + add);
		                }
		                catch (IOException e) {                
		                    Log.i(tag, "e = " + e.getMessage());
		                }   
					
					
					
					
					Log.i(tag,"long = " + String.valueOf(l.getLongitude()));
					Log.i(tag,"lati = " + String.valueOf(l.getLatitude()));
				}else {
					Log.i(tag, "ta null");
					latitude = " ";
					longitude = " ";
					endereco = " ";
				}
				
				
				
				
			intent.putExtra("latitude", latitude);
			intent.putExtra("longitude", longitude);
			intent.putExtra("endereco", endereco);
				
				
				startActivity(intent);
				
			}
		});
	    
	    
	    
	    bt_mapa.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
			
				startActivity(new Intent(getApplicationContext(),MainActivity.class));
				
			}
		});
	    
	    
	
	}
	
	
	
}
