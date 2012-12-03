package br.com.android.defesa;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import br.com.android.defesa.dao.MoradiaDAO;
import br.com.android.defesa.model.Moradia;
import br.com.android.defesa.util.BolaOverlayListener;
import br.com.android.defesa.util.Coordenada;
import br.com.android.defesa.util.ImagensOverlay;
import br.com.android.defesa.util.Ponto;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MainActivity extends MapActivity implements LocationListener{

	private MoradiaDAO moradiadao;
	List<Moradia> moradiavo = new ArrayList<Moradia>();
	private MapView mapa;

	private BolaOverlayListener bola;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setSatellite(true);
		mapa.setBuiltInZoomControls(true);
		mapa.getController().setZoom(16);
		mapa.setClickable(true);
		
		mapa.setOnTouchListener(new View.OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
			
				if (event.getAction() == 1) {                
	                GeoPoint p = mapa.getProjection().fromPixels(
	                    (int) event.getX(),
	                    (int) event.getY());
				
	                Log.i("defesacivil", "latitude = " + p.getLatitudeE6());
	                Log.i("defesacivil", "longitude = " + p.getLongitudeE6());
	                 
				}
			
	                
				return false;
			}
		});
		
		
		
		

		bola = new BolaOverlayListener(null, Color.BLUE);

		Drawable imagem = getResources().getDrawable(R.drawable.overlay);

		List<OverlayItem> pontos = new ArrayList<OverlayItem>();
		
		
		moradiadao = new MoradiaDAO(getApplicationContext());
		moradiavo = moradiadao.getALL();
		for (int i = 0; i < moradiavo.size(); i++) {
			Double x = moradiavo.get(i).getX();
			Double y = moradiavo.get(i).getY();

			pontos.add(new OverlayItem(new Coordenada(x.doubleValue(), y
					.doubleValue()), "massa", "bom"));

		}
		
		Location loc = getLocationManager().getLastKnownLocation(LocationManager.GPS_PROVIDER);
		
		if(loc != null){
			Ponto ponto = new Ponto(loc);
			bola.setGeoPoint(ponto);
			mapa.getController().setCenter(ponto);	
			
		}else {
			bola.setGeoPoint(new Ponto(-8.018597,-34.860950));
		}
		
		
		 mapa.getOverlays().add(bola);
			
			// Adiciona as imagens no mapa
			ImagensOverlay pontosOverlay = new ImagensOverlay(this, pontos, imagem);
			mapa.getOverlays().add(pontosOverlay);
			
			
			getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER,0, 0, this);
		
	}

	
	private LocationManager getLocationManager(){
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		return locationManager;
	}
	
	public void onLocationChanged(Location location) {
		GeoPoint geoPoint = new Ponto(location);
		
		bola.setGeoPoint(geoPoint);
		
		mapa.getController().animateTo(geoPoint);
		
		mapa.invalidate();
		
		
		
	}
	
	
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		getLocationManager().removeUpdates(this);
	
	}


	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
