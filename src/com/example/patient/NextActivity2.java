//Goes with screen3.xml
package com.example.patient;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NextActivity2 extends Activity {
	
	
	private EditText employerName;
	private EditText employerPhone;
	private EditText occupation;
	private EditText employerAddress;
	
	private EditText c1Name;
	private EditText c1Phone;
	private EditText c1Relation;
	private EditText c2Name;
	private EditText c2Phone;
	private EditText c2Relation;
	int fromReview;
	
	String empName;
    String empPhone;
    String occup;
    String empAddress;
    
    final String[] employment = null;
    
    //gets the data from the emergency contact section
    String cName1;
    String cPhone1;
    String cRelation1;
    
    String cName2;
    String cPhone2;
    String cRelation2;
    
    final String[] emergency = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen3);
		//next page button
		Button b = (Button) findViewById(R.id.btn_Confirm);
		//gets the value 1 if this activity was started by the review page
		//otherwise the value is 0
		fromReview = getIntent().getIntExtra("review", 0);
		
		//Data of the Patient Details section from the previous activity
		final String[] patientDetails = getIntent().getStringArrayExtra("details");
		
		//employment history 
		employerName = (EditText) findViewById(R.id.editText_employercompany);
		employerPhone = (EditText) findViewById(R.id.editText_employerphone);
		occupation = (EditText) findViewById(R.id.editText_occupation);
		employerAddress = (EditText) findViewById(R.id.editText_employeradress);
		
		//emergency contacts
		//final TextView contact1 = (TextView) findViewById(R.id.textView_contact1);
		c1Name = (EditText) findViewById(R.id.editText_contact1name);
		c1Phone = (EditText) findViewById(R.id.editText_contact1phone);
		c1Relation = (EditText) findViewById(R.id.editText_contact1relationship);
		
		//final TextView contact2 = (TextView) findViewById(R.id.textView_contact2);
		c2Name = (EditText) findViewById(R.id.editText_contact2name);
		c2Phone = (EditText) findViewById(R.id.editText_contact2phone);
		c2Relation = (EditText) findViewById(R.id.editText_contact2relationship);
		//tasks the activity performs when it is started by the review page
		if (fromReview == 1){
			//sets the next button to finish button 
			b.setText("Finish");
			//gets the respective data through the review page in an array 
			String[] employmentHist = getIntent().getStringArrayExtra("employment_history");
			//assigns the data to specific variables
			final String empName = employmentHist[0];
			final String empPhone = employmentHist[1];
			final String occup = employmentHist[2];
			final String empAddress = employmentHist[3];
			//gets the respective data through the review page in an array
			String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");
			//assigns the data to specific variables
			final String cName1 = emergencyContact[0];
			final String cPhone1 = emergencyContact[1];
			final String cRelation1 = emergencyContact[2];

			final String cName2 = emergencyContact[3];
			final String cPhone2 = emergencyContact[4];
			final String cRelation2 = emergencyContact[5];
			
			//fill out the page with the retrieved data through the review page
			employerName.setText(empName);
			employerPhone.setText(empPhone);
			occupation.setText(occup);
			employerAddress.setText(empAddress);
			
			c1Name.setText(cName1);
			c1Phone.setText(cPhone1);
			c1Relation.setText(cRelation1);
			
			c2Name.setText(cName2);
			c2Phone.setText(cPhone2);
			c2Relation.setText(cRelation2);
		}
		
		// when the next page button is clicked
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //gets the data from the employment history section
            empName = employerName.getText().toString();
            empPhone = employerPhone.getText().toString();
            occup = occupation.getText().toString();
            empAddress = employerAddress.getText().toString();
            
          
            
            //gets the data from the emergency contact section
            cName1 = c1Name.getText().toString();
            cPhone1 = c1Phone.getText().toString();
            cRelation1 = c1Relation.getText().toString();
            
            cName2 = c2Name.getText().toString();
            cPhone2 = c2Phone.getText().toString();
            cRelation2 = c2Relation.getText().toString();
            
            if (fromReview == 1){
            	//if this activity is started by the review page 
    			//the intent is assigned with a value that starts the review page
            	 Intent i = new Intent(NextActivity2.this, ReviewActivity.class);
            	
            	//Data of the patient details section from the review page
        		final String[] patientDetails = getIntent().getStringArrayExtra("details");
        		
            	//Data of the insurance section from the review page
    			final String[] insurance = getIntent().getStringArrayExtra("insurance_Data");

    			//Data of the medical history section from the review page
    			final String[] medHistory = getIntent().getStringArrayExtra("medical_History_Data");
    			
    			//Data of the allergy section from the review page
    			final String[] allergies = getIntent().getStringArrayExtra("allergies");
    			
        		
        	
        		
        		i.putExtra("selected_state", getIntent().getIntExtra("selected_state", -1));
        		
    			//put the data from the other activities in the intent for the review page
    			final String[] employment = { empName, empPhone, occup, empAddress };
    			i.putExtra("employment_history", employment);
            final String[] emergency = {cName1, cPhone1, cRelation1, 
            							cName2, cPhone2, cRelation2 };	
            	i.putExtra("emergency_contact", emergency);
            	
    			i.putExtra("details", patientDetails);

        		i.putExtra("insurance_Data", insurance);
        		
        		i.putExtra("medical_History_Data", medHistory);
        		
        		i.putExtra("allergies", allergies);
        		startActivity(i);
            }
            else {
            
            	/*if(empPhone.equals("")||empName.equals("")||occup.equals("")||empAddress.equals("")||
            			cName1.equals("")||cPhone1.equals("")||cRelation1.equals("")){
            		
            		runOnUiThread(new Runnable(){
            			public void run(){
            				Toast.makeText(getApplicationContext(), "Some Required Fields Were Left Blank", Toast.LENGTH_LONG).show();
            			}
            		});
            		}*/// Yesterday Only God I knew what it does now only God knows 
            	//else{ need more beer
            	//the intent is assigned with a value that start the next activity
            	 Intent i = new Intent(NextActivity2.this, NextActivity3.class);
            	
            	//put the data from the previous activities in the intent to preserve them through the next activity 
            	i.putExtra("details", patientDetails);
        		final String[] employment = { empName, empPhone, occup, empAddress };
    			i.putExtra("employment_history", employment);
            final String[] emergency = {cName1, cPhone1, cRelation1, 
            							cName2, cPhone2, cRelation2 };	
            	i.putExtra("emergency_contact", emergency);
            	startActivity(i);
            }
            
            
            
        
            
            //pile all the received data on this activity to send it to the next one            
    		
    		
            }
          //  }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_activity2, menu);
		return true;
	}

}
