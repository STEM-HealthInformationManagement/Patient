package com.example.patient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.btn_Confirm);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, NextActivity.class);
            startActivity(i);
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

    
    } 


