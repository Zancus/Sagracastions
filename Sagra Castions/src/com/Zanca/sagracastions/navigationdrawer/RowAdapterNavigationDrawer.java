package com.Zanca.sagracastions.navigationdrawer;

import java.util.ArrayList;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.R.id;
import com.Zanca.sagracastions.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowAdapterNavigationDrawer extends BaseAdapter {

	Context context;
	ArrayList<RowNavigationDrawer> items;

	public RowAdapterNavigationDrawer(Context context, ArrayList<RowNavigationDrawer> data) {
		this.context = context;
		this.items = data;
	}

	@Override
	public int getCount() {

		return items.size();
	}

	@Override
	public RowNavigationDrawer getItem(int index) {
		return items.get(index);
	}

	@Override
	public long getItemId(int index) {
		RowNavigationDrawer items = getItem(index);
		return items.id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view;
		ViewHolder myHolder;
		if (convertView != null)
			view = convertView;
		 else 
		{
			LayoutInflater inflater = LayoutInflater.from(context);
			view = inflater.inflate(R.layout.drawer_list_item, null);
			myHolder = new ViewHolder();
			myHolder.imageView = (ImageView) view.findViewById(R.id.img_item_nav_draw);
			myHolder.textViewValore = (TextView) view.findViewById(R.id.txt_item_title_nav_draw);
			view.setTag(myHolder);
		}

		RowNavigationDrawer myItems = items.get(position);

		ViewHolder holder = (ViewHolder) view.getTag();

		holder.textViewValore.setText("" + myItems.name);
		holder.imageView.setImageResource(myItems.icon);

		return view;
	}

	private class ViewHolder {
		TextView textViewValore;
		ImageView imageView;
	}

}
