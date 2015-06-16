package com.Zanca.sagracastions.date;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.dettagliodata.DettaglioDataActivity;
import com.Zanca.sagracastions.models.Giornata;

public class dateFragment extends Fragment {

	private ListView dateList;
	private ArrayList<Giornata> date = new ArrayList<Giornata>();
	private dateAdapter adapter;
	public static final String datePosition = "date position";
	public static final String dateName = "date";
	public static dateFragment newInstance()
	{
		return new dateFragment();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View dateView = inflater.inflate(R.layout.fragment_date, container, false);
		dateList = (ListView) dateView.findViewById(R.id.dateList);
		initGiornateArrayList();
		adapter = new dateAdapter(getActivity(), date);
		dateList.setAdapter(adapter);
		dateList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), DettaglioDataActivity.class);
				Bundle bundle = new Bundle();
				bundle.putInt(datePosition, position);
				bundle.putString(dateName, date.get(position).data);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		return dateView;
	}
	
	private void initGiornateArrayList()
	{
		date.add(new Giornata(1, R.drawable.arcdisanmarc, "Giovedì 20.08.2015"));
		date.add(new Giornata(2, 0, "Venerdì 21.08.2015"));
		date.add(new Giornata(3, R.drawable.absolute5, "Sabato 22.08.2015"));
		date.add(new Giornata(4, R.drawable.collegium, "Domenica 23.08.2015"));
		date.add(new Giornata(5, R.drawable.siroliverskardy, "Giovedì 27.08.2015"));
		date.add(new Giornata(6, 0,"Venerdì 28.08.2015"));
		date.add(new Giornata(7, R.drawable.direstraitsovergold, "Sabato 29.08.2015"));
		date.add(new Giornata(8, R.drawable.gimmy, "Domenica 30.08.2015"));
//		date.add(new Giornata(1, R.drawable.arcdisanmarc, "Giovedì 20.08.2015"));
//		date.add(new Giornata(2, 0, "Venerdì 21.08.2015"));
//		date.add(new Giornata(3, R.drawable.absolute5, "Sabato 22.08.2015"));
//		date.add(new Giornata(4, R.drawable.collegium, "Domenica 23.08.2015"));
//		date.add(new Giornata(5, R.drawable.siroliverskardy, "Giovedì 27.08.2015"));
//		date.add(new Giornata(6, 0,"Venerdì 28.08.2015"));
//		date.add(new Giornata(7, R.drawable.direstraitsovergold, "Sabato 29.08.2015"));
//		date.add(new Giornata(8, R.drawable.gimmy, "Domenica 30.08.2015"));
	}
}
