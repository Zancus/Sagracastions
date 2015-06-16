package com.Zanca.sagracastions.dettagliodata;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Zanca.sagracastions.R;
import com.Zanca.sagracastions.Tools;
import com.Zanca.sagracastions.date.dateFragment;
import com.Zanca.sagracastions.dialog.dialogGenerici;

public class DettaglioDataActivity extends Activity {

	private String titlePage;
	private int idData;
	private ImageView image_band;
	private TextView txtAperturaChioschi, txtOrarioCucina, txtBand, txtUrl, lblBand;
	private Button btnDescrizione, btnMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dettaglio_data);
		setupGUI();
		switch(idData)
		{
			case 0: {
						image_band.setBackgroundResource(R.drawable.arcdisanmarc);
						txtBand.setText("Arc di San Marc");
						txtUrl.setText("http://www.fitafriulivg.it/le-nostre-compagnie/pn-arc-di-san-marc/");
						setButtons("Primo giovedì", "cibo");
					} break;
			case 1: {
						txtBand.setText("Dj Carinz");
						setButtons("Primo venerdì", "cibo");
					} break;
			case 2: {
						image_band.setBackgroundResource(R.drawable.absolute5);
						txtBand.setText("Absolute 5");
						txtUrl.setText("http://www.absolutefive.it/");
						setButtons("Primo sabato", "cibo");
					} break;
			case 3: {
						image_band.setBackgroundResource(R.drawable.collegium);
						txtBand.setText("Collegium");
						txtUrl.setText("http://www.orchestracollegium.it/");
						setButtons("Prima domenica", "cibo");
					} break;
			case 4: {
						image_band.setBackgroundResource(R.drawable.siroliverskardy);
						txtBand.setText("Sound system ft. Skardy");
						txtUrl.setText("http://www.skardy.it/");
						setButtons("Secondo giovedì", "cibo");
					} break;
			case 5: {
						lblBand.setText("Djs: ");
						txtBand.setText("carinz, Galli, ecc...");
						setButtons("Secondo venerdì", "cibo");
					} break;
			case 6: {
						image_band.setBackgroundResource(R.drawable.direstraitsovergold);
						txtBand.setText("Dire straits over gold");
						txtUrl.setText("http://www.direstraitsovergold.com/");
						setButtons("Secondo sabato", "cibo");
					} break;
			case 7: {
						image_band.setBackgroundResource(R.drawable.gimmy_logo);
						txtBand.setText("Gimmy e i ricordi");
						txtUrl.setText("http://www.gimmyeiricordi.it/");
						setButtons("Seconda domenica", "cibo");
					} break;
		}
	}
	
	private void setupGUI() {
		// TODO Auto-generated method stub
		titlePage = getIntent().getExtras().getString(dateFragment.dateName);
		getActionBar().setTitle(titlePage);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		btnDescrizione = (Button) findViewById(R.id.btnDetail);
		btnMenu = (Button) findViewById(R.id.btnMenuOdierno);
		idData = getIntent().getExtras().getInt(dateFragment.datePosition);
		image_band = (ImageView) findViewById(R.id.imageBand);
		txtAperturaChioschi = (TextView) findViewById(R.id.txtOrarioAperturaChioschi);
		txtOrarioCucina = (TextView) findViewById(R.id.txtOrarioCucina);
		txtBand = (TextView) findViewById(R.id.txtBand);
		txtUrl = (TextView) findViewById(R.id.txtUrl);
		lblBand = (TextView) findViewById(R.id.lblBand);
		txtAperturaChioschi.setText("18");
		txtOrarioCucina.setText("19-23");
	}

	private void setButtons(final String descrizioneGiornata, final String menuOdierno)
	{
		btnDescrizione.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialogGenerici dialog = dialogGenerici.newInstance(Tools.DETTAGLIO_DESCRIZIONE, descrizioneGiornata);
				dialog.show(getFragmentManager(), null);
			}
		});
		
		btnMenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialogGenerici dialog = dialogGenerici.newInstance(Tools.DETTAGLIO_MENU, menuOdierno);
				dialog.show(getFragmentManager(), null);
			}
		});
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case android.R.id.home: 
				onBackPressed();
			return true; 
			default: return super.onOptionsItemSelected(item);
		}
	}
	
	
}
