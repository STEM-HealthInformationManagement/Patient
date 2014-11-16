package org.him.patient;

import com.example.patient.R;

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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	SlidingDrawer sd;
	@SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button b = (Button) findViewById(R.id.btn_Confirm);
        final Button update_Button = (Button) findViewById(R.id.update_Btn);
        final Button doctorButton = (Button) findViewById(R.id.doctorLoginButton);
        final Button doctorRegButton = (Button) findViewById(R.id.doctorRegisterButton);
        
        final TextView tv1 = (TextView) findViewById(R.id.textView2);
        final TextView slidingText = (TextView) findViewById(R.id.slideUpTextView);
        final ProgressBar sp = (ProgressBar) findViewById(R.id.doctorLoginProgress);
        
        final TextView info = (TextView) findViewById(R.id.HIS_Info);
        
        final ImageView logo = (ImageView) findViewById(R.id.ImageView_logo);
        sd = (SlidingDrawer) findViewById(R.id.drawer);
        b.setVisibility(View.INVISIBLE);
		update_Button.setVisibility(View.INVISIBLE);
		tv1.setVisibility(View.INVISIBLE);
		logo.setVisibility(View.INVISIBLE);
		
		b.setVisibility(View.VISIBLE);
		update_Button.setVisibility(View.VISIBLE);
		tv1.setVisibility(View.VISIBLE);
		logo.setVisibility(View.VISIBLE);
 /*       sd.setOnTouchListener(new View.OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				b.setVisibility(View.INVISIBLE);
				update_Button.setVisibility(View.INVISIBLE);
				tv1.setVisibility(View.INVISIBLE);
				
				return false;
			}
		});
*/
		
		doctorButton.setVisibility(View.INVISIBLE);
		doctorRegButton.setVisibility(View.INVISIBLE);
        
        //Make the slider invisible till the internet connection is checked.
        sd.setVisibility(View.INVISIBLE);
        sd.setOnDrawerOpenListener(new OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                slidingText.setText("Slide down to begin");
                slidingText.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.down_button, 0, 0);
                runOnUiThread(new Runnable(){
			    	 public void run() {
			    	    if(isNetworkAvailable())
			    	    {
			    	    	doctorButton.setVisibility(View.VISIBLE);
							doctorRegButton.setVisibility(View.VISIBLE);
			    	    }
			    	    else
			    	    {
			    	    	
			    	    }
			    	 }
			    	 });
				b.setVisibility(View.INVISIBLE);
				update_Button.setVisibility(View.INVISIBLE);
				tv1.setVisibility(View.INVISIBLE);
				logo.setVisibility(View.INVISIBLE);
				/*doctorButton.setVisibility(View.VISIBLE);
				doctorRegButton.setVisibility(View.VISIBLE);*/

            }
        });
        sd.setOnDrawerCloseListener(new OnDrawerCloseListener(){

			@Override
			public void onDrawerClosed() {
				slidingText.setText("Slide up to learn more about HIS");
				slidingText.setCompoundDrawablesWithIntrinsicBounds( 0, R.drawable.up_button, 0, 0);
				runOnUiThread(new Runnable(){
					public void run() {
			    	    if(isNetworkAvailable())
			    	    {
			    	    	b.setVisibility(View.VISIBLE);
							update_Button.setVisibility(View.VISIBLE);
							doctorButton.setVisibility(View.INVISIBLE);
							doctorRegButton.setVisibility(View.INVISIBLE);
							logo.setVisibility(View.VISIBLE);
			    	    }
			    	    else
			    	    {
			    	    	tv1.setVisibility(View.VISIBLE);
			    	    	logo.setVisibility(View.VISIBLE);
			    	    }
			    	 }
					});
				

			}
        	
        });
        
        b.setVisibility(View.INVISIBLE);
        update_Button.setVisibility(View.INVISIBLE);
        
        //This when you press START button, goes to the next activity
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, NextActivity.class);
            startActivity(i);
            }
        });
        
        //The Login Button Action for doctors
        doctorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, Doctor.class);
            startActivity(i);
            }
        });
        //The registration button action for doctors
        doctorRegButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, DoctorRegister.class);
            startActivity(i);
            }
        });
        
        slidingText.setVisibility(View.INVISIBLE);
        
        //Start animating the spinner when checking for internet connection.
        sp.animate();
        sp.setVisibility(View.VISIBLE);
        //Start a THREAD Handler after a 2 second delay
        Handler handler = new Handler(); 
        handler.postDelayed(new Runnable() { 
        	//Run the thread
             public void run() { 
                  if(isNetworkAvailable())
                  {
                	  sp.setVisibility(View.INVISIBLE);
                	  update_Button.setVisibility(View.VISIBLE);
                	  b.setVisibility(View.VISIBLE);
                	  tv1.setVisibility(View.INVISIBLE);
                	  tv1.setText("");
                	  slidingText.setVisibility(View.VISIBLE);
                	  sp.setVisibility(View.GONE);
                	  //Make the slider visible if internet is available.
                      sd.setVisibility(View.VISIBLE);
                  }
                  else
                  {
                	  sp.setVisibility(View.INVISIBLE);
                	  update_Button.setVisibility(View.INVISIBLE);
                	  b.setVisibility(View.INVISIBLE);
                	  tv1.setVisibility(View.VISIBLE);
                	  slidingText.setVisibility(View.VISIBLE);
                	  tv1.setText("Internet Connection Required!");
                	  sp.setVisibility(View.GONE);
                	  //Make the slider visible even if internet is not available.
                      sd.setVisibility(View.VISIBLE);
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
    //You can also use this to clean up some of the resources not used for the time being.
    @Override
    public void onBackPressed() {
    	sd.close();
    	return;
    }
    
    /**Starts checking if the device is connected to internet or not.<br>
     * This includes Wi-Fi and 3G/4G
     * @return TRUE if connected to the network. FALSE otherwise.
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    
    } 


