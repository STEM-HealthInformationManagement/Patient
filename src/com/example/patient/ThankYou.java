package com.example.patient;

import com.example.patient.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class ThankYou extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thank_you);
		
		TextView continueTextView = (TextView) findViewById(R.id.textView2);
		Animation continueBlinker = new AlphaAnimation(0.3f, 1.0f); // Alpha parameters, used for transparency (SCALE: 0.0 [Completely Transparent] - 1.0 [Fully Visible])
		continueBlinker.setDuration(500); //Time Of blink
		continueBlinker.setStartOffset(20);
		continueBlinker.setRepeatMode(Animation.REVERSE);
		continueBlinker.setRepeatCount(Animation.INFINITE);
		continueTextView.startAnimation(continueBlinker);
		
		continueTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i = new Intent(ThankYou.this, MainActivity.class);
            startActivity(i);
            }
        });
		
	}
	
	   @Override
	    public void onBackPressed() {

	       return;
	    }
}
