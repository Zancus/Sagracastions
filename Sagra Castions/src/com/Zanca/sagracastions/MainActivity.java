package com.Zanca.sagracastions;

import com.Zanca.sagracastions.date.dateFragment;
import com.Zanca.sagracastions.gallery.galleryFragment;
import com.Zanca.sagracastions.mappa.Parco_mappa_Activity;
import com.Zanca.sagracastions.navigationdrawer.NavigationDrawerFragment;
import com.Zanca.sagracastions.storia.storiaFragment;
import com.Zanca.sagracastions.weather.weatherFragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private dateFragment datefragment;
	private weatherFragment meteofragment;
	private storiaFragment storiafragment;
	private galleryFragment galleryfragment;
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		
//		AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		switch(position){
		
			case 0:
			{
				if(fragmentManager.findFragmentByTag(Tools.FRAGMENT_DATE) == null)
					datefragment = dateFragment.newInstance();
				else
					datefragment = (dateFragment) fragmentManager.findFragmentByTag(Tools.FRAGMENT_DATE);
				fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						datefragment, Tools.FRAGMENT_DATE).
					commit();
			}
				break;
			case 1:
			{
				if(fragmentManager.findFragmentByTag(Tools.FRAGMENT_GALLERY) == null)
					galleryfragment = galleryFragment.newInstance();
				else
					galleryfragment = (galleryFragment) fragmentManager.findFragmentByTag(Tools.FRAGMENT_GALLERY);
				fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						galleryfragment, Tools.FRAGMENT_GALLERY).addToBackStack(null).commit();
			}
				break;
			case 2: 
				Intent start_map = new Intent(this, Parco_mappa_Activity.class);
				startActivity(start_map);
				break;
			case 3:
			{
				if(fragmentManager.findFragmentByTag(Tools.FRAGMENT_METEO) == null)				
					meteofragment = weatherFragment.newInstance();
				else
					meteofragment = (weatherFragment) fragmentManager.findFragmentByTag(Tools.FRAGMENT_METEO);
				fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						meteofragment, Tools.FRAGMENT_METEO).addToBackStack(null).commit();
			}
				break;
			case 4:
			{
				if(fragmentManager.findFragmentByTag(Tools.FRAGMENT_STORIA) == null)
					storiafragment = storiaFragment.newInstance();
				else
					storiafragment = (storiaFragment) fragmentManager.findFragmentByTag(Tools.FRAGMENT_STORIA);
				fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						storiafragment , Tools.FRAGMENT_STORIA).addToBackStack(null).commit();
			}
				break;
			default: 
					fragmentManager
					.beginTransaction()
					.replace(R.id.container,
							PlaceholderFragment.newInstance(position + 1))
							.addToBackStack(null)
							.commit();
					break;
		}
	}

	public void onSectionAttached(int number) {
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		case 4:
			mTitle = getString(R.string.title_section4);
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
