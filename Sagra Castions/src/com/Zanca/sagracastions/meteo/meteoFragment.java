package com.Zanca.sagracastions.meteo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.Tools;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.image.SmartImageView;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class meteoFragment extends Fragment{

	private TextView cityField, updatedField, detailsField, currentTemperatureField;
	private ProgressDialog pDialog;
	private SmartImageView weatherIcon;
	private String URL_ICON = "http://openweathermap.org/img/w/";
	public static meteoFragment newInstance()
	{
		return new meteoFragment();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View weather_view = inflater.inflate(R.layout.fragment_meteo, container, false);
		cityField = (TextView) weather_view.findViewById(R.id.city_field);
		updatedField = (TextView) weather_view.findViewById(R.id.updated_field);
		detailsField = (TextView) weather_view.findViewById(R.id.details_field);
		currentTemperatureField = (TextView) weather_view.findViewById(R.id.current_temperature_field);
		weatherIcon = (SmartImageView) weather_view.findViewById(R.id.weather_icon);
		getWeatherInformation();
		return weather_view;
	}
	
	private void getWeatherInformation()
	{
		AsyncHttpClient client = new AsyncHttpClient();
		if(Tools.isNetworkEnabled(getActivity())) 
		{
			pDialog = new ProgressDialog(getActivity());
			pDialog.setTitle("wait");
			pDialog.show();
			client.get(Tools.METEO_URL_NOW, new JsonHttpResponseHandler()
			{
				@Override
				public void onSuccess(int statusCode, Header[] headers,
						JSONObject response) {
					// TODO Auto-generated method stub
					pDialog.dismiss();
					try {
						cityField.setText(response.getString(Tools.METEO_CITTA).toUpperCase(Locale.ITALY) 
								+ ", " + response.getJSONObject(Tools.METEO_OBJECT).getString(Tools.METEO_NAZIONE));
						JSONObject details = response.getJSONArray("weather").getJSONObject(0);
						JSONObject main = response.getJSONObject(Tools.METEO_MAIN_OBJECT);
				        detailsField.setText(
				                details.getString(Tools.METEO_DESCRIPTION).toUpperCase(Locale.ITALY)
	//			                + "\n" + "Umidità: " + main.getString(Tools.METEO_UMIDITA) + "%"
	//			                + "\n" + "Pressione: " + main.getString(Tools.METEO_PRESSIONE) + " hPa"
				                );
				        weatherIcon.setImageUrl(URL_ICON + details.getString(Tools.METEO_ICON) + ".png");
				        currentTemperatureField.setText(
				                    String.format("%.2f", main.getDouble(Tools.METEO_TEMP))+ " ℃");
				 
				        DateFormat df = DateFormat.getDateTimeInstance();
				        String updatedOn = df.format(new Date(response.getLong("dt")*1000));
				        updatedField.setText("Ultimo aggiornamento: " + updatedOn);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				@Override
				public void onFailure(int statusCode, Header[] headers,
						String responseString, Throwable throwable) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(), "Errore nel recupero dati", Toast.LENGTH_LONG).show();
					super.onFailure(statusCode, headers, responseString, throwable);
				}

				@Override
				public void onFailure(int statusCode, Header[] headers,
						Throwable throwable, JSONArray errorResponse) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(), "Errore nel recupero dati", Toast.LENGTH_LONG).show();
					super.onFailure(statusCode, headers, throwable, errorResponse);
				}

				@Override
				public void onFailure(int statusCode, Header[] headers,
						Throwable throwable, JSONObject errorResponse) {
					// TODO Auto-generated method stub
					Toast.makeText(getActivity(), "Errore nel recupero dati", Toast.LENGTH_LONG).show();
					super.onFailure(statusCode, headers, throwable, errorResponse);
				}
			});
		}
		else
			Toast.makeText(getActivity(), "Nessuna connessione di rete", Toast.LENGTH_LONG).show();
	}
}
