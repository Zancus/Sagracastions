package com.Zanca.sagracastions;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Tools {

	//fragment
	public static final String FRAGMENT_DATE = "date";
	public static final String FRAGMENT_METEO = "meteo";
	public static final String FRAGMENT_STORIA = "storia";
	public static final String FRAGMENT_MAPPA = "mappa";
	public static final String FRAGMENT_GALLERY = "gallery";
	//dettaglio giornata
	public static final String DETTAGLIO_DESCRIZIONE = "dettaglio descrizione";
	public static final String DETTAGLIO_MENU = "dettaglio menu";
	//meteo
	public static final String METEO_URL_NOW = "http://api.openweathermap.org/data/2.5/weather?q=Castions&units=metric";
	public static final String METEO_URL_MORE_DAYS = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Castions&mode=json&units=metric&cnt=2";
	public static final String METEO_CITTA = "name";
	public static final String METEO_NAZIONE = "country";
	public static final String METEO_OBJECT = "sys";
	public static final String METEO_MAIN_OBJECT = "main";
	public static final String METEO_ARRAY = "weather";
	public static final String METEO_ICON = "icon";
	public static final String METEO_TEMP = "temp";
	public static final String METEO_DESCRIPTION = "description";
	public static final String METEO_DATETIME = "dt";
	public static final String METEO_UMIDITA = "humidity";
	public static final String METEO_PRESSIONE = "pressure";
	
	private static NetworkInfo networkInfo;
	private static ConnectivityManager connectivityManager;
	
	public static boolean isNetworkEnabled(Context context) {
		connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		networkInfo = connectivityManager.getActiveNetworkInfo();
		
		return networkInfo != null && networkInfo.isConnectedOrConnecting();
	}
}
