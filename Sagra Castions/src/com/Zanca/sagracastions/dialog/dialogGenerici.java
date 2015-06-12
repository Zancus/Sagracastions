package com.Zanca.sagracastions.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class dialogGenerici extends DialogFragment {

	private static final String keyMessage = "message";
	private static final String keyTitle = "title";
	
	public static dialogGenerici newInstance(String title, String message)
	{
		dialogGenerici dialog = new dialogGenerici();
		Bundle bundle = new Bundle();
		bundle.putString(keyMessage, message);
		bundle.putString(keyTitle, title);
		dialog.setArguments(bundle);
		return dialog;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		Bundle getBundle = getArguments();
		if(getBundle != null)
		{
			builder.setTitle(getBundle.getString(keyTitle));
			builder.setMessage(getBundle.getString(keyMessage));
		}
		
		builder.setPositiveButton("Ok", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		
		Dialog dialog = builder.create();
		return dialog;
	}
	
}
