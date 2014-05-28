package com.example.patient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class NextActivity6 extends Activity {
	private Button b;
	
	private RadioGroup ques;
	private RadioButton yes;
	private RadioButton no;
	
	private EditText allergy1;
	private EditText allergy2;
	private EditText allergy3;
	private EditText allergy4;
	private EditText allergy5;
	
	private TextView allergyT1;
	private TextView allergyT2;
	private TextView allergyT3;
	private TextView allergyT4;
	private TextView allergyT5;
	
	private EditText reaction1;
	private EditText reaction2;
	private EditText reaction3;
	private EditText reaction4;
	private EditText reaction5;
	
	private TextView reactionT1;
	private TextView reactionT2;
	private TextView reactionT3;
	private TextView reactionT4;
	private TextView reactionT5;

	
	int fromReview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen7);

		//gets the value 1 if this activity was started by the review page
		//otherwise the value is 0
		fromReview = getIntent().getIntExtra("review", 0);
		
		b = (Button) findViewById(R.id.button1);
		
		ques = (RadioGroup) findViewById(R.id.radioGroup_Allergy);
		yes = (RadioButton) findViewById(R.id.radioButton_yes);
		no = (RadioButton) findViewById(R.id.radioButton_no);
		
		allergy1 = (EditText) findViewById(R.id.editText_allergy1);
		allergy2 =  (EditText) findViewById(R.id.editText_allergy2);
		allergy3 =  (EditText) findViewById(R.id.editText_allergy3);
		allergy4 =  (EditText) findViewById(R.id.editText_allergy4);
		allergy5 =  (EditText) findViewById(R.id.editText_allergy5);
		
		allergyT1 = (TextView) findViewById(R.id.viewText_allergy1);
		allergyT2 = (TextView) findViewById(R.id.textView_allergy2);
		allergyT3 = (TextView) findViewById(R.id.textView_allergy3);
		allergyT4 = (TextView) findViewById(R.id.textView_allergy4);
		allergyT5 = (TextView) findViewById(R.id.textView_allergy5);
		
		reaction1 =  (EditText) findViewById(R.id.editText_reaction1);
		reaction2 =  (EditText) findViewById(R.id.editText_reaction2);
		reaction3 =  (EditText) findViewById(R.id.editText_reaction3);
		reaction4 =  (EditText) findViewById(R.id.editText_reaction4);
		reaction5 =  (EditText) findViewById(R.id.editText_reaction5);
		
		reactionT1 =  (TextView) findViewById(R.id.textView_reaction1);
		reactionT2 =  (TextView) findViewById(R.id.textView_reaction2);
		reactionT3 =  (TextView) findViewById(R.id.textView_reaction3);
		reactionT4 =  (TextView) findViewById(R.id.textView_reaction4);
		reactionT5 =  (TextView) findViewById(R.id.textView_reaction5);
		
		allergy1.setEnabled(false);
		allergy2.setEnabled(false);
		allergy3.setEnabled(false);
		allergy4.setEnabled(false);
		allergy5.setEnabled(false);
		
		allergyT1.setEnabled(false);
		allergyT2.setEnabled(false);
		allergyT3.setEnabled(false);
		allergyT4.setEnabled(false);
		allergyT5.setEnabled(false);

		reaction1.setEnabled(false);
		reaction2.setEnabled(false);
		reaction3.setEnabled(false);
		reaction4.setEnabled(false);
		reaction5.setEnabled(false);
		
		reactionT1.setEnabled(false);
		reactionT2.setEnabled(false);
		reactionT3.setEnabled(false);
		reactionT4.setEnabled(false);
		reactionT5.setEnabled(false);
		
		//tasks the activity performs when it is started by the review page
		if (fromReview == 1){
			
			//sets the next button to finish button 
			b.setText("Finish");
			
			//clear the indication that the user has no known allergies
			allergy1.clearComposingText();
			
			//gets the respective data through the review page in an array
			final String[] allergies = getIntent().getStringArrayExtra("allergies");
			
			//assigns the data to specific variables
			String sAllergy1 = allergies[0];
			String sAllergy2 = allergies[1];
			String sAllergy3 = allergies[2];
			String sAllergy4 = allergies[3];
			String sAllergy5 = allergies[4];
			
			String sReaction1 = allergies[5];
			String sReaction2 = allergies[6];
			String sReaction3 = allergies[7];
			String sReaction4 = allergies[8];
			String sReaction5 = allergies[9];
			
			//fill out the page with the retrieved data through the review page
			allergy1.setText(sAllergy1);
			allergy2.setText(sAllergy2);
			allergy3.setText(sAllergy3);
			allergy4.setText(sAllergy4);
			allergy5.setText(sAllergy5);
			
			reaction1.setText(sReaction1);
			reaction2.setText(sReaction2);
			reaction3.setText(sReaction3);
			reaction4.setText(sReaction4);
			reaction5.setText(sReaction5);
			
		}
				
		no.setChecked(true);
		yes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (yes.isChecked()) {
					allergy1.setEnabled(true);
        			allergy2.setEnabled(true);
        			allergy3.setEnabled(true);
        			allergy4.setEnabled(true);
        			allergy5.setEnabled(true);
        			
        			reaction1.setEnabled(true);
        			reaction2.setEnabled(true);
        			reaction3.setEnabled(true);
        			reaction4.setEnabled(true);
        			reaction5.setEnabled(true);
        			
        			allergyT1.setEnabled(true);
        			allergyT2.setEnabled(true);
        			allergyT3.setEnabled(true);
        			allergyT4.setEnabled(true);
        			allergyT5.setEnabled(true);
        			
        			reactionT1.setEnabled(true);
        			reactionT2.setEnabled(true);
        			reactionT3.setEnabled(true);
        			reactionT4.setEnabled(true);
        			reactionT5.setEnabled(true);
				}
			}
		});
		
		no.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (no.isChecked()) {
					allergy1.setEnabled(false);
					allergy2.setEnabled(false);
					allergy3.setEnabled(false);
					allergy4.setEnabled(false);
					allergy5.setEnabled(false);

					reaction1.setEnabled(false);
					reaction2.setEnabled(false);
					reaction3.setEnabled(false);
					reaction4.setEnabled(false);
					reaction5.setEnabled(false);
					
					allergyT1.setEnabled(false);
					allergyT2.setEnabled(false);
					allergyT3.setEnabled(false);
					allergyT4.setEnabled(false);
					allergyT5.setEnabled(false);

					reactionT1.setEnabled(false);
					reactionT2.setEnabled(false);
					reactionT3.setEnabled(false);
					reactionT4.setEnabled(false);
					reactionT5.setEnabled(false);
				}
			}
		});
		
		
		//Data of the Patient Details section from the previous activity
		final String[] patientDetails = getIntent().getStringArrayExtra("details");

		//Data of the employment history section from the previous activity
		final String[] employmentHist = getIntent().getStringArrayExtra("employment_history");

		//Data of the emergency contact section from the previous activity
		final String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");
		
		//Data of the insurance section from the previous activity
		final String[] insurance = getIntent().getStringArrayExtra("insurance_Data");
		
		//Data of the medical history section from the previous activity
		final String[] medHistory = getIntent().getStringArrayExtra("medical_History_Data");
		
        b.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		String sAllergy1 = null;
    			String sAllergy2 = null;
    			String sAllergy3 = null;
    			String sAllergy4 = null;
    			String sAllergy5 = null;
    			
    			String sReaction1 = null;
    			String sReaction2 = null;
    			String sReaction3 = null;
    			String sReaction4 = null;
    			String sReaction5 = null;
    			
        		if(yes.isChecked()) {
        			        			
        			sAllergy1 = allergy1.getText().toString();
        			sAllergy2 = allergy2.getText().toString();
        			sAllergy3 = allergy3.getText().toString();
        			sAllergy4 = allergy4.getText().toString();
        			sAllergy5 = allergy5.getText().toString();
        			
        			sReaction1 = reaction1.getText().toString();
        			sReaction2 = reaction2.getText().toString();
        			sReaction3 = reaction3.getText().toString();
        			sReaction4 = reaction4.getText().toString();
        			sReaction5 = reaction5.getText().toString();        			        		        			
        		}
        		if(no.isChecked()) {
        			sAllergy1 = "no allergies";
        		}
        		
        		final String[] allergies = { sAllergy1, sAllergy2, sAllergy3, 
						sAllergy4, sAllergy5, sReaction1, 
						sReaction2, sReaction3, sReaction4, 
						sReaction5 };
        		
        		Intent i = new Intent(NextActivity6.this, ReviewActivity.class);
        		
        		//pile all the received data on this activity to send it to the next one
        		
        		//This is a bad idea, because it Overflows the memory references and
        		//doing this takes a very large cluster of information and stores it,
        		//which uses a lot of memory. Hence, it crashes and goes back to the
        		//first activity.
        		
        		//A good method would be to store details per one INTENT.
        		
        		i.putExtra("details", patientDetails);

        		i.putExtra("employment_history", employmentHist);

        		i.putExtra("emergency_contact", emergencyContact);

        		i.putExtra("insurance_Data", insurance);
        		
        		i.putExtra("medical_History_Data", medHistory);
        		
        		i.putExtra("allergies", allergies);
        		
        		i.putExtra("selected_state", getIntent().getIntExtra("selected_state", -1));
        		
        		startActivity(i);
        	}
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_activity6, menu);
		return true;
	}

}
