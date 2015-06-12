package com.Zanca.sagracastions.gallery;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.ImageView;

public class DialogImage extends DialogFragment {

	public static DialogImage newInstance(int img)
	{
		DialogImage image = new DialogImage();
		Bundle image_bundle = new Bundle();
		image_bundle.putInt("image", img);
		image.setArguments(image_bundle);
		return image;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder image_dialog_builder = new AlertDialog.Builder(getActivity());
		ImageView image = new ImageView(getActivity());
		Bundle getBundle = getArguments();
		if(getBundle != null)
			image.setBackgroundResource(getBundle.getInt("image"));
        image_dialog_builder.setView(image);
		Dialog image_dialog = image_dialog_builder.create();
		return image_dialog;
	}
	
}
