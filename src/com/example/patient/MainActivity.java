package com.example.patient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {


	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Button b = (Button) findViewById(R.id.btn_Confirm);
		final Button update_Button = (Button) findViewById(R.id.update_Btn);

		final SlidingDrawer drawer = (SlidingDrawer) findViewById(R.id.drawer);
		final int downArrow = R.drawable.down_button;
		final int upArrow = R.drawable.up_button;
		final ImageView logo = (ImageView) findViewById(R.id.ImageView_logo);

		final TextView tv1 = (TextView) findViewById(R.id.textView2);
		final TextView slidingText = (TextView) findViewById(R.id.textView1);
		final ProgressBar sp = (ProgressBar) findViewById(R.id.progressBar1);
		final String textWhenClosed = slidingText.getText().toString();

		b.setVisibility(View.INVISIBLE);
		update_Button.setVisibility(View.INVISIBLE);

		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, NextActivity.class);
				startActivity(i);
			}
		});
		sp.animate();
		sp.setVisibility(View.VISIBLE);
		Handler handler = new Handler(); 
		handler.postDelayed(new Runnable() { 
			public void run() { 
				if(isNetworkAvailable())
				{
					sp.setVisibility(View.INVISIBLE);
					update_Button.setVisibility(View.VISIBLE);
					b.setVisibility(View.VISIBLE);
					tv1.setVisibility(View.GONE);
					tv1.setText("");
				}
				else
				{
					sp.setVisibility(View.INVISIBLE);
					update_Button.setVisibility(View.INVISIBLE);
					b.setVisibility(View.INVISIBLE);
					tv1.setVisibility(View.VISIBLE);
					tv1.setText("Internet Connection Required!");
				}
			} 
		}, 2000);

		//This if/else statement check when the drawer containing info about the HIS app is opened/closed
		//if it is closed, when the drawer is done scrolling the elements of the page disappear  
		//if it is opened, when the drawer is done scrolling the elements of the page appear  
		drawer.setOnDrawerScrollListener(new OnDrawerScrollListener() {
			
			@Override
			public void onScrollStarted() {
				// TODO Auto-generated method stub
				if(drawer.isOpened()){
					// TODO Auto-generated method stub
					slidingText.setText(textWhenClosed);
					slidingText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, upArrow, 0, 0);
					logo.animate().alpha(1);
					b.animate().alpha(1);
					update_Button.animate().alpha(1);

				}else {
					slidingText.setText("Close");
					slidingText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, downArrow, 0, 0);
					logo.animate().alpha(0);
					b.animate().alpha(0);
					update_Button.animate().alpha(0);
				}
			}
			
			@Override
			public void onScrollEnded() {
				// TODO Auto-generated method stub
				
			}
		});
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//Prevent BACK button from being pressed.
	//Therefore, the application will no longer quit when BACK button is pressed.
	//Also when application is submitted, pressing the BACK button will no longer
	//go to the previous activity.
	@Override
	public void onBackPressed() {

		return;
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager 
		= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}


} 


