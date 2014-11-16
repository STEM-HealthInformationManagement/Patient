package org.him.patient;

import java.io.BufferedReader;
import java.io.DataInputStream;
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
import com.example.patient.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorRegister extends Activity {

	String name = null;
	String dob = null;
	String email = null;
	//int phoneNumber;
	String phoneNumber;
	String password = null;
	
	String responseContent;
	String content;
	//TextView afterRegister;
	JSONObject evaluator;
	String evaluatorValue;
	
	CheckBox spw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dc_register_screen);
		final ProgressBar reg_progress = (ProgressBar) findViewById(R.id.reg_progressBar);
		
		///////////////////////////////////////////////////////////
		final TextView t1 = (TextView) findViewById(R.id.textView1);
		final TextView t2 = (TextView) findViewById(R.id.textView2);
		final TextView t3 = (TextView) findViewById(R.id.textView3);
		final TextView t4 = (TextView) findViewById(R.id.textView4);
		final TextView t5 = (TextView) findViewById(R.id.textView5);
		final TextView t6 = (TextView) findViewById(R.id.textView6);
		final TextView t7 = (TextView) findViewById(R.id.textView7);
		////////////////////////////////////////////////////////////
		
		spw = (CheckBox) findViewById(R.id.reg_checkbox_spw);
		
		final EditText reg_name = (EditText) findViewById(R.id.reg_nameField);
		final EditText reg_dob = (EditText) findViewById(R.id.reg_dob);
		final EditText reg_email = (EditText) findViewById(R.id.reg_emailField);
		final EditText reg_phone = (EditText) findViewById(R.id.reg_phNumber);
		final EditText reg_pass = (EditText) findViewById(R.id.reg_desiredPassword);
		final Button reg_button = (Button) findViewById(R.id.doctorRegisterButton);
		final TextView afterRegister = (TextView) findViewById(R.id.afterRegister);
		reg_progress.setVisibility(View.INVISIBLE);
		afterRegister.setVisibility(View.INVISIBLE);
		
		spw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(spw.isChecked())
				{
					reg_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
				}
				else
				{
					reg_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
				}
			}
		});
		
		reg_button.setOnClickListener(new View.OnClickListener() 
		{
            public void onClick(View v) 
            {
            	/*Intent i = new Intent(MainActivity.this, DoctorRegister.class);
            	startActivity(i);*/
            	name = reg_name.getText().toString();
				dob = reg_dob.getText().toString();
				email = reg_email.getText().toString();
				//String numberText = reg_phone.getText().toString();
				//phoneNumber = Integer.parseInt(numberText);
				phoneNumber = reg_phone.getText().toString();
				password = reg_pass.getText().toString();
				
				afterRegister.setText("");
				afterRegister.setVisibility(View.VISIBLE);
				
				if(name.matches("") || dob.matches("") || email.matches("") || phoneNumber.matches("") || password.matches(""))
				{
					Toast.makeText(getBaseContext(), "All fields are required!", Toast.LENGTH_LONG).show();
				}
				else
				{
				
					reg_name.setVisibility(View.INVISIBLE);
					reg_dob.setVisibility(View.INVISIBLE);
					reg_email.setVisibility(View.INVISIBLE);
					reg_phone.setVisibility(View.INVISIBLE);
					reg_pass.setVisibility(View.INVISIBLE);
					reg_button.setVisibility(View.INVISIBLE);
					t1.setVisibility(View.INVISIBLE);
					t2.setVisibility(View.INVISIBLE);
					t3.setVisibility(View.INVISIBLE);
					t4.setVisibility(View.INVISIBLE);
					t5.setVisibility(View.INVISIBLE);
					t6.setVisibility(View.INVISIBLE);
					t7.setVisibility(View.INVISIBLE);
					spw.setVisibility(View.INVISIBLE);
					
					//Initialize a JSON Object. JSON Allows us to store information in a smarter way
					//by shortening and simplifying the array, and most scripts are able to read JSON
					//very easily today.
					final JSONObject jObj = new JSONObject();
					//URL To the script which executes the information provided and stores in the database.
					final String url = "http://www.njcuacm.org/restricted/stem_test/doctor/put_doctor_info.php";
					Toast.makeText(getBaseContext(), "Submitting Form...", Toast.LENGTH_LONG).show();
					
					reg_progress.setVisibility(View.VISIBLE);
					reg_progress.animate();
					
					new Thread() {
						@Override
						public void run() {
							try
							{
	
								HttpClient httpclient = new DefaultHttpClient();
							     HttpPost httppost = new HttpPost(url);
							     
				/*
				 * From Saurabh: I am trying this new way to enter everything into a JSON Array and Encode it through Java.
				 * Then, take the information in PHP and Decode it there, as well as output everything there.
				 */			     
							   //Enter all information into a JSON ARRAY  
							    jObj.put("name", name);
							    jObj.put("dob", dob);
							    jObj.put("email", email);
							    jObj.put("phoneNumber", phoneNumber);
							    jObj.put("password", password);
							    
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
							                afterRegister.setText(responseContent);
								    	 }
								    	 });
	***********************************************************************************************************************/				                
							    if(responseContent.contains("good"))
							    {
					                //Store specific name related values in the String.
					                //In this case, I'm going to store the e-mail value from JSON name "good"
					                evaluatorValue = evaluator.getString("good");
					                
								    runOnUiThread(new Runnable(){
								    	 public void run() {
								    	    //Toast.makeText(getApplicationContext(), "Application Successfully Submitted!", Toast.LENGTH_LONG).show();
							                afterRegister.setText("Your form was successfully submitted!\n" +
							                		"Please check your e-mail for the Identification Code at " + evaluatorValue);
							                reg_progress.clearAnimation();
							        		reg_progress.setVisibility(View.INVISIBLE);
								    	 }
								    });
							    }
							    else if(responseContent.contains("bad"))
							    {
							    	runOnUiThread(new Runnable(){
								    	 public void run() {
								    	    //Toast.makeText(getApplicationContext(), "An Error Occurred!", Toast.LENGTH_LONG).show();
							                afterRegister.setText("We're sorry, an error occured submitting your application.\n"
							                								+ "Please try again.\n\n"
							                								+ "If error persists, please try again an hour later.");
							                reg_progress.clearAnimation();
							        		reg_progress.setVisibility(View.INVISIBLE);
								    	 }
								    	 });
							    }
							   }
							   else
							   {
								   runOnUiThread(new Runnable(){
								    	 public void run() {
								    	    Toast.makeText(getApplicationContext(), "Submission "
								    	    		+ "Unsuccessful! Please Try Again.", Toast.LENGTH_LONG).show();
								    	    reg_progress.clearAnimation();
								    		reg_progress.setVisibility(View.INVISIBLE);
								    	 }
								    	 });
							   }
							}
							catch (final Exception e) 
							{
								// TODO Auto-generated catch block
								 runOnUiThread(new Runnable(){
							    	 public void run() {
							    		 Toast.makeText(getBaseContext(), e.getMessage()+"...There was an unexpected error...Please Try again.", Toast.LENGTH_SHORT).show();
							    		 reg_progress.clearAnimation();
							    			reg_progress.setVisibility(View.INVISIBLE);
							    	 }
						    	 });
								e.printStackTrace();
							}
							
							super.run();
						}
						}.start();
					
				}
				

            }
		});
		
		
		
		
	}
}