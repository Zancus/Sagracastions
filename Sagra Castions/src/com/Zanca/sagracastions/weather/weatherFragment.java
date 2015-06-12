package com.Zanca.sagracastions.weather;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.Zanca.sagracastions.R;
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

public class weatherFragment extends Fragment{

	private TextView cityField, updatedField, detailsField, currentTemperatureField;
	private ProgressDialog pDialog;
	private SmartImageView weatherIcon;
	private String URL_ICON = "http://openweathermap.org/img/w/";
	public static weatherFragment newInstance()
	{
		return new weatherFragment();
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
		View weather_view = inflater.inflate(R.layout.fragment_weather, container, false);
		cityField = (TextView) weather_view.findViewById(R.id.city_field);
		updatedField = (TextView) weather_view.findViewById(R.id.updated_field);
		detailsField = (TextView) weather_view.findViewById(R.id.details_field);
		currentTemperatureField = (TextView) weather_view.findViewById(R.id.current_temperature_field);
		weatherIcon = (SmartImageView) weather_view.findViewById(R.id.weather_icon);
		pDialog = new ProgressDialog(getActivity());
		pDialog.setTitle("wait");
		pDialog.show();
		getWeatherInformation();
		return weather_view;
	}
	
	private void getWeatherInformation()
	{
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("http://api.openweathermap.org/data/2.5/weather?q=Castions&units=metric", new JsonHttpResponseHandler()
		{
		
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				// TODO Auto-generated method stub
				pDialog.dismiss();
				try {
					cityField.setText(response.getString("name").toUpperCase(Locale.ITALY) 
							+ ", " + response.getJSONObject("sys").getString("country"));
					JSONObject details = response.getJSONArray("weather").getJSONObject(0);
					JSONObject main = response.getJSONObject("main");
//					switch(details.getString("description").toUpperCase(Locale.ITALY))
//					{
//						case "SCATTERED CLOUDS": detailsField.setText(
//			                "NUBI SPARSE" +
//			                "\n" + "Umidità: " + main.getString("humidity") + "%" +
//			                "\n" + "Pressione: " + main.getString("pressure") + " hPa");
//						default: detailsField.setText(
//				                details.getString("description").toUpperCase(Locale.ITALY) +
//				                "\n" + "Umidità: " + main.getString("humidity") + "%" +
//				                "\n" + "Pressione: " + main.getString("pressure") + " hPa");
//					}
			        detailsField.setText(
			                details.getString("description").toUpperCase(Locale.ITALY)
//			                + "\n" + "Umidità: " + main.getString("humidity") + "%"
//			                + "\n" + "Pressione: " + main.getString("pressure") + " hPa"
			                );
			        weatherIcon.setImageUrl(URL_ICON + details.getString("icon") + ".png");
			        currentTemperatureField.setText(
			                    String.format("%.2f", main.getDouble("temp"))+ " ℃");
			 
			        DateFormat df = DateFormat.getDateTimeInstance();
			        String updatedOn = df.format(new Date(response.getLong("dt")*1000));
			        updatedField.setText("Ultimo aggiornamento: " + updatedOn);
			 
//			        setWeatherIcon(details.getInt("id"),
//			                response.getJSONObject("sys").getLong("sunrise") * 1000,
//			                response.getJSONObject("sys").getLong("sunset") * 1000);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
//	private void setWeatherIcon(int actualId, long sunrise, long sunset){
//	    int id = actualId / 100;
//	    String icon = "";
//	    if(actualId == 800){
//	        long currentTime = new Date().getTime();
//	        if(currentTime>=sunrise && currentTime<sunset) {
//	            icon = getActivity().getString(R.string.weather_sunny);
//	        } else {
//	            icon = getActivity().getString(R.string.weather_clear_night);
//	        }
//	    } else {
//	        switch(id) {
//	        case 2 : icon = getActivity().getString(R.string.weather_thunder);
//	                 break;         
//	        case 3 : icon = getActivity().getString(R.string.weather_drizzle);
//	                 break;     
//	        case 7 : icon = getActivity().getString(R.string.weather_foggy);
//	                 break;
//	        case 8 : icon = getActivity().getString(R.string.weather_cloudy);
//	                 break;
//	        case 6 : icon = getActivity().getString(R.string.weather_snowy);
//	                 break;
//	        case 5 : icon = getActivity().getString(R.string.weather_rainy);
//	                 break;
//	        }
//	    }
//	    weatherIcon.setText(icon);
//	}
}
