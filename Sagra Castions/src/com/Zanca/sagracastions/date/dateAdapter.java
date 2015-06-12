package com.Zanca.sagracastions.date;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.models.Giornata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class dateAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Giornata> date;
	
	public dateAdapter(Context context, ArrayList<Giornata> date) {
		super();
		this.context = context;
		this.date = date;
	}
	
	private class DataViewHolder
	{
		ImageView img;
		TextView data;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return date.size();
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return date.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		Giornata giornata = (Giornata) getItem(position);
		return giornata.id;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View data_Cella_view;
		DataViewHolder holder;
		LayoutInflater inflater = LayoutInflater.from(context);
		if(convertView != null)
			data_Cella_view = convertView;
		else
		{
			data_Cella_view = inflater.inflate(R.layout.celladate, null);
			holder = new DataViewHolder();
			holder.img = (ImageView) data_Cella_view.findViewById(R.id.imgListData);
			holder.data = (TextView) data_Cella_view.findViewById(R.id.txtData);
			data_Cella_view.setTag(holder);
		}
		Giornata giornata = (Giornata) getItem(position);
		DataViewHolder getHolder = (DataViewHolder) data_Cella_view.getTag();
		getHolder.img.setBackgroundResource(giornata.img);
		getHolder.data.setText(giornata.data);
		return data_Cella_view;
	}
	
}
