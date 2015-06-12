package com.Zanca.sagracastions.mappa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class DialogInfoMappa extends DialogFragment {

	public static DialogInfoMappa newInstance()
	{
		return new DialogInfoMappa();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder infoDialog = new AlertDialog.Builder(getActivity());
		infoDialog.setTitle("Info");
		infoDialog.setMessage("Per raggiungerci, segui questi semplici passi! Avvia il GPS, clicca sul pulsante " +
				"rosso nella mappa, in seguito il pulsante con la freccia blu in basso a destra e segui le successive istruzioni! Buon viaggio!");
		infoDialog.setPositiveButton("Ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		Dialog realInfoDialog = infoDialog.create();
		return realInfoDialog;
	}
	
}
