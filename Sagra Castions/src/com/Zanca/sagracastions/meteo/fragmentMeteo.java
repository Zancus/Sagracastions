package com.Zanca.sagracastions.meteo;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import com.Zanca.sagracastions.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class fragmentMeteo extends PreferenceFragment {

	private AsyncHttpClient client;
	public static fragmentMeteo newInstance()
	{
		return new fragmentMeteo();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View meteo_view = inflater.inflate(R.layout.fragment_meteo, null);
		getResponseMeteo();
		return meteo_view;
	}

	private void getResponseMeteo() {
		// TODO Auto-generated method stub
		client = new AsyncHttpClient();
		client.get("https://api.metwit.com/v2/weather/?location_lat=45.98&location_lng=12.80", new JsonHttpResponseHandler(){

			

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				// TODO Auto-generated method stub
				Log.d("meteo", response.toString());
				super.onSuccess(statusCode, headers, response);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					String responseString, Throwable throwable) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Errore nella ricezione dei dati", Toast.LENGTH_LONG).show();
				super.onFailure(statusCode, headers, responseString, throwable);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					Throwable throwable, JSONArray errorResponse) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Errore nella ricezione dei dati", Toast.LENGTH_LONG).show();
				super.onFailure(statusCode, headers, throwable, errorResponse);
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,
					Throwable throwable, JSONObject errorResponse) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Errore nella ricezione dei dati", Toast.LENGTH_LONG).show();
				super.onFailure(statusCode, headers, throwable, errorResponse);
			}
			
		});
	}
	
}
