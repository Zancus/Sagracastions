package com.Zanca.sagracastions.gallery;

import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

import com.Zanca.sagracastions.R;

public class galleryFragment extends Fragment {

	//private Gallery gallery;
	private LinearLayout scrollImages;
	private imageAdapter adapter;
	private ImageView image;
	private Integer [] pics = {R.drawable.parco1, R.drawable.parco2, R.drawable.parco3, R.drawable.parcoo16
							   , R.drawable.parcoo17, R.drawable.parcoo18, R.drawable.parcoo19};
	public static galleryFragment newInstance()
	{
		return new galleryFragment();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View gallery_view = inflater.inflate(R.layout.fragment_gallery, container, false);
		//gallery = (Gallery) gallery_view.findViewById(R.id.gallery1);
		scrollImages = (LinearLayout) gallery_view.findViewById(R.id.images);
		setScrollImages();
//		adapter = new imageAdapter(getActivity().getApplicationContext(), pics);
//		gallery.setAdapter(adapter);
		return gallery_view;
	}

	private void setScrollImages() {
		// TODO Auto-generated method stub
		LinearLayout.LayoutParams imagesLayout = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		imagesLayout.setMargins(5, 5, 5, 0);
		ImageView galleryImage;
		for(int i = 0; i < pics.length; i++)
		{
			galleryImage = new ImageView(getActivity());
			galleryImage.setLayoutParams(imagesLayout);
			galleryImage.setScaleType(ScaleType.CENTER_CROP);
			galleryImage.getLayoutParams().width = 100;
			galleryImage.setBackgroundResource(pics[i]);
			scrollImages.addView(galleryImage);
			final int imgpos = i;
			galleryImage.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					DialogImage dialogimage = DialogImage.newInstance(pics[imgpos]);
					dialogimage.show(getFragmentManager(), "img");
				}
			});
		}
	}
}
