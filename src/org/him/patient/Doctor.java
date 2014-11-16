package org.him.patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.patient.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Doctor extends Activity {

	String dident;
	String pw;
	
	TextView dIDTextView;
	TextView dPasswordTextView;
	TextView rememberMeTextView;
	String responseContent;
	String content;
	JSONObject evaluator;
	String evaluatorValue;
	
	String dlg_niv;
	String dlg_niv2;
	String dlg_niv3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_screen);
		
		//##################################################//
		dIDTextView = (TextView) findViewById(R.id.textView2);
		dPasswordTextView = (TextView) findViewById(R.id.textView3);
		rememberMeTextView = (TextView) findViewById(R.id.textView4);
		//##################################################//
		
		final ProgressBar sp = (ProgressBar) findViewById(R.id.doctorLoginProgress);
		final EditText idField = (EditText) findViewById(R.id.idTextField);
		final EditText pwField = (EditText) findViewById(R.id.passwordTextField);
		final Button loginButton = (Button) findViewById(R.id.loginButton);
		final Button retryButton = (Button) findViewById(R.id.retryButton);
		final ToggleButton rememberToggle = (ToggleButton) findViewById(R.id.rememberToggle);
		final TextView afterLogin = (TextView) findViewById(R.id.afterDoctorLogin);
		sp.setVisibility(View.INVISIBLE);
		afterLogin.setVisibility(View.INVISIBLE);
		retryButton.setVisibility(View.INVISIBLE);
		
		rememberToggle.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				//Going to work on this later...
			}
		});
		
		loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				dident = idField.getText().toString();
				pw = pwField.getText().toString();
				afterLogin.setText("");
				if(dident.matches(""))
				{
					Toast.makeText(getBaseContext(), "Identity Code is Required!", Toast.LENGTH_LONG).show();
				}
				else if(pw.matches(""))
				{
					Toast.makeText(getBaseContext(), "Password is Required!", Toast.LENGTH_LONG).show();
				}
				else
				{
					idField.setVisibility(View.INVISIBLE);
					pwField.setVisibility(View.INVISIBLE);
					loginButton.setVisibility(View.INVISIBLE);
					rememberToggle.setVisibility(View.INVISIBLE);
					dIDTextView.setVisibility(View.INVISIBLE);
					dPasswordTextView.setVisibility(View.INVISIBLE);
					rememberMeTextView.setVisibility(View.INVISIBLE);
					afterLogin.setVisibility(View.VISIBLE);
					retryButton.setVisibility(View.INVISIBLE);
					
					//Initialize a JSON Object. JSON Allows us to store information in a smarter way
					//by shortening and simplifying the array, and most scripts are able to read JSON
					//very easily today.
					final JSONObject jObj = new JSONObject();
					//URL To the script which executes the information provided and stores in the database.
					final String url = "http://www.njcuacm.org/restricted/stem_test/doctor/getDoctorInfo.php";
					
					sp.setVisibility(View.VISIBLE);
					sp.animate();
					
					new Thread() {
						@Override
						public void run() {
							try
							{
	
								HttpClient httpclient = new DefaultHttpClient();
							     HttpPost httppost = new HttpPost(url);
							     	     
							   //Enter all information into a JSON ARRAY  
							    jObj.put("dident", dident);
							    jObj.put("password", pw);
							    
								JSONArray allJsonObjects = new JSONArray();
					            allJsonObjects.put(jObj);
					            
					            //This sets a custom header for PHP, to read it via
					            //$_SERVER['HTTP_JSON']; which is assigned to a variable
					            //and controlled later in the PHP script.
								httppost.setHeader("json", jObj.toString());
								httppost.getParams().setParameter("jsonpost", allJsonObjects);
					            
								/********************ORIGINAL CODE*******************************/
							     //httppost.setEntity(new UrlEncodedFormEntity(postParameters));
								/****************************************************************/
								System.out.print(jObj);
							     HttpResponse response = httpclient.execute(httppost);
							     
							     //response.getAllHeaders();
							   if(response != null)
							   {
							     InputStream is = response.getEntity().getContent();
							     
					                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
					                StringBuilder sb = new StringBuilder();
					 
					                String line = null;
					                
					                try {
					                    while ((line = reader.readLine()) != null) {
					                        sb.append(line + "\n");
					                    }
					                } catch (IOException e) {
					                    e.printStackTrace();
					                } finally {
					                    try {
					                        is.close();
					                    } catch (IOException e) {
					                        e.printStackTrace();
					                    }
					                }
					                responseContent = sb.toString();
					                
					                //Evaluate the response content to get the name and values from the JSON String.
					                evaluator = new JSONObject(responseContent);
					                dlg_niv3 = evaluator.getString("dlg_niv3");
					                
					                
					                /*DataInputStream input = new DataInputStream(response.getEntity().getContent());
					                JSONObject json = new JSONObject(input.readLine());
					                content = json.toString(2);*/
					                
					                //Below is used for testing response when data is delivered to PHP.
					                
					                //When Response Text View shows "{'good':'good'}", all information
					                //including all fields have been stored into the database.
					                
					                //When Response Text View shows "{'good':'good'}", some or none
					                //of the fields have been stored into the database and an ERROR
					                //statement MAY be show on top of this. If not, an internal server/
					                //database error probably occurred.
					                
					                //Un-comment below block of code ONLY for testing!
	/***********************************************************************************************************************				                
					                runOnUiThread(new Runnable(){
								    	 public void run() {
							                afterLogin.setText(responseContent);
								    	 }
								    	 });
	***********************************************************************************************************************/				                
							    if(dlg_niv3.equals("DLG_TRUE_IV_TRUE"))
							    {
					                //Store specific name related values in the String.
					                //In this case, I'm going to store the e-mail value from JSON name "good"
					                dlg_niv = evaluator.getString("dlg_niv");
					                
								    runOnUiThread(new Runnable(){
								    	 public void run() {
								    	    //Toast.makeText(getApplicationContext(), "Application Successfully Submitted!", Toast.LENGTH_LONG).show();
							                afterLogin.setText(dlg_niv);
							                sp.clearAnimation();
							        		sp.setVisibility(View.INVISIBLE);
								    	 }
								    });
							    }
							    else if(dlg_niv3.equals("DLG_TRUE_IV_FALSE"))
							    {
							    	dlg_niv = evaluator.getString("dlg_niv");
							    	dlg_niv2 = evaluator.getString("dlg_niv2");
							    	
							    	runOnUiThread(new Runnable(){
								    	 public void run() {
								    	    //Toast.makeText(getApplicationContext(), "An Error Occurred!", Toast.LENGTH_LONG).show();
								    		 afterLogin.setText(dlg_niv + "\n" + dlg_niv2);
								    		 sp.clearAnimation();
								    		 sp.setVisibility(View.INVISIBLE);
								    	 }
								    	 });
							    }
							    else if(dlg_niv3.equals("DLG_FALSE"))
							    {
							    	dlg_niv = evaluator.getString("dlg_niv");
							    	
							    	runOnUiThread(new Runnable(){
								    	 public void run() {
								    	    //Toast.makeText(getApplicationContext(), "An Error Occurred!", Toast.LENGTH_LONG).show();
								    		 afterLogin.setText(dlg_niv);
								    		 sp.clearAnimation();
								    		 sp.setVisibility(View.INVISIBLE);
								    		 retryButton.setVisibility(View.VISIBLE);
								    	 }
								    	 });
							    }
							    
							   }
							   else
							   {
								   runOnUiThread(new Runnable(){
								    	 public void run() {
								    		 afterLogin.setText("Fatal Error Occurred.\n\nsPlease try again.");
								    	    sp.clearAnimation();
								    	    sp.setVisibility(View.INVISIBLE);
								    	    retryButton.setVisibility(View.VISIBLE);
								    	 }
								    	 });
							   }
							}
							catch (final Exception e) 
							{
								 runOnUiThread(new Runnable(){
							    	 public void run() {
							    		 afterLogin.setText(e.getMessage() + "\n\nThere was an unexpected error...Please Try again.");
							    		 sp.clearAnimation();
							    		 sp.setVisibility(View.INVISIBLE);
							    		 retryButton.setVisibility(View.VISIBLE);
							    	 }
						    	 });
								e.printStackTrace();
							}
							
							super.run();
						}
						}.start();					
				}	//End else
				
			}		//End onClick()
			
		});			//End Click Listener
		
		
		retryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				idField.setVisibility(View.VISIBLE);
				pwField.setVisibility(View.VISIBLE);
				loginButton.setVisibility(View.VISIBLE);
				rememberToggle.setVisibility(View.VISIBLE);
				dIDTextView.setVisibility(View.VISIBLE);
				dPasswordTextView.setVisibility(View.VISIBLE);
				rememberMeTextView.setVisibility(View.VISIBLE);
				afterLogin.setVisibility(View.INVISIBLE);
				retryButton.setVisibility(View.INVISIBLE);
			}
		});
		
	}
}