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
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button) findViewById(R.id.btn_Confirm);
        final TextView tv1 = (TextView) findViewById(R.id.textView1);
        final ProgressBar sp = (ProgressBar) findViewById(R.id.progressBar1);
        b.setVisibility(View.INVISIBLE);
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
                	  b.setVisibility(View.VISIBLE);
                	  tv1.setText("");
                  }
                  else
                  {
                	  sp.setVisibility(View.INVISIBLE);
                	  b.setVisibility(View.INVISIBLE);
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


