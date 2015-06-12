package com.Zanca.sagracastions.navigationdrawer;

import java.util.ArrayList;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.R.drawable;
import com.Zanca.sagracastions.R.string;

import android.content.res.Resources;

public class RowNavigationDrawer {
	public int icon;
    public String name;
    public int id;
 
    public RowNavigationDrawer(int id,String name,int icon) {
        this.icon = icon;
        this.name = name;
        this.id = id;
    }
    
    public static ArrayList<RowNavigationDrawer> createArray(Resources resources){	
    	ArrayList<RowNavigationDrawer> data = new ArrayList<RowNavigationDrawer>();
    	RowNavigationDrawer days= new RowNavigationDrawer(0,resources.getString(R.string.title_section1),R.drawable.ic_calendar);
    	data.add(days);
    	RowNavigationDrawer gallery = new RowNavigationDrawer(1,resources.getString(R.string.title_section3),R.drawable.ic_gallery_ook);
    	data.add(gallery);
    	RowNavigationDrawer maps = new RowNavigationDrawer(2,resources.getString(R.string.title_section4),R.drawable.ic_maps);
    	data.add(maps);
    	RowNavigationDrawer weather = new RowNavigationDrawer(3,resources.getString(R.string.title_section6),R.drawable.ic_weather);
    	data.add(weather);
    	RowNavigationDrawer history = new RowNavigationDrawer(4,resources.getString(R.string.title_section5),R.drawable.ic_storia);
    	data.add(history);
    	return data;
    	}
}
