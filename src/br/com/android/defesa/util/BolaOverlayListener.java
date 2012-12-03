package br.com.android.defesa.util;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;

public class BolaOverlayListener extends BolaOverlay implements LocationListener {
	public BolaOverlayListener(GeoPoint geoPoint, int cor) {
		super(geoPoint, cor);
	}
	public void onLocationChanged(Location location) {
		// Atualiza a coordenada do CirculoOverlay
		setGeoPoint(new Coordenada(location));
	}
	public void onProviderDisabled(String s) {}
	public void onProviderEnabled(String s) {}
	public void onStatusChanged(String s, int i, Bundle bundle) {}
}
