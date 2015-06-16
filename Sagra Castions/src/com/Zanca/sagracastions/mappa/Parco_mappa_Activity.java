package com.Zanca.sagracastions.mappa;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.R.id;
import com.Zanca.sagracastions.R.layout;
import com.Zanca.sagracastions.R.menu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Parco_mappa_Activity extends Activity implements OnMapReadyCallback{

	private GoogleMap parcoMap;
	private ActionBar map_parco_actionBar;
	private LatLng ParcoBurgos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parco_mappa_);
		map_parco_actionBar = getActionBar();
		map_parco_actionBar.setTitle("Parco Burgos");
		map_parco_actionBar.setDisplayHomeAsUpEnabled(true);
		MapFragment mappa = (MapFragment) getFragmentManager().findFragmentById(R.id.map_parco);
		mappa.getMapAsync(this);
	}

	@Override
	public void onMapReady(GoogleMap arg0) {
		// TODO Auto-generated method stub
		parcoMap = arg0;
		if(parcoMap != null)
		{
			drawMarker();
			parcoMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ParcoBurgos, 10));
			parcoMap.getUiSettings().setScrollGesturesEnabled(true);
			parcoMap.getUiSettings().setRotateGesturesEnabled(true);
			parcoMap.setMyLocationEnabled(true);
			parcoMap.getUiSettings().setZoomControlsEnabled(
					true);
			parcoMap.getUiSettings().setMapToolbarEnabled(true);
		}
	}
	
	private void drawMarker(){
		ParcoBurgos = new LatLng(45.97554, 12.801089);
		MarkerOptions parco = new MarkerOptions().position(
				ParcoBurgos).title("Parco burgos");
		parcoMap.addMarker(parco).showInfoWindow();
		
//		Marker Pn = parcoMap.addMarker(new MarkerOptions().title("Parco Burgos")
//				.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
//				.position(ParcoBurgos));
		
	}
}
