package com.example.patient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button) findViewById(R.id.btn_Confirm);
        final Button update_Button = (Button) findViewById(R.id.update_Btn);
        		
        final TextView tv1 = (TextView) findViewById(R.id.textView2);
        final TextView slidingText = (TextView) findViewById(R.id.slideUpTextView);
        final ProgressBar sp = (ProgressBar) findViewById(R.id.progressBar1);
        SlidingDrawer sd = (SlidingDrawer) findViewById(R.id.drawer);
        sd.setOnDrawerOpenListener(new OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                slidingText.setText("Slide down to begin");
            }
        });
        sd.setOnDrawerCloseListener(new OnDrawerCloseListener(){

			@Override
			public void onDrawerClosed() {
				slidingText.setText("Slide up to learn more about HIS");
				
			}
        	
        });
        
        b.setVisibility(View.INVISIBLE);
        update_Button.setVisibility(View.INVISIBLE);
        
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, NextActivity.class);
            startActivity(i);
            }
        });
        slidingText.setVisibility(View.INVISIBLE);
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
                	  slidingText.setVisibility(View.VISIBLE);
                  }
                  else
                  {
                	  sp.setVisibility(View.INVISIBLE);
                	  update_Button.setVisibility(View.INVISIBLE);
                	  b.setVisibility(View.INVISIBLE);
                	  tv1.setVisibility(View.VISIBLE);
                	  slidingText.setVisibility(View.VISIBLE);
                	  tv1.setText("Internet Connection Required!");
                  }
             } 
        }, 2000);
	        

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


