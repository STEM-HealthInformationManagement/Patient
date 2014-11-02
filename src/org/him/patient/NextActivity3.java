//screen4.xml
package org.him.patient;

import com.example.patient.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;

public class NextActivity3 extends Activity {
	
	int fromReview;
	
	//declaration of the checkboxes
	CheckBox C_covered, C_self_insured, C_secondary;
	//the textViews
	TextView ins_Comp, phone, group_Num, policy_Num, holder_Name, rel_Holder, 
	         ins_Comp_Sec, phone_Sec, group_Num_Sec, policy_Num_Sec;
	//the editTexts
	EditText ins_Comp_In, phone_In, group_Num_In, policy_Num_In, holder_Name_In, rel_Holder_In, 
             ins_Comp_Sec_In, phone_Sec_In, group_Num_Sec_In, policy_Num_Sec_In;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen4);
		
		Button b = (Button) findViewById(R.id.loginButton);
		
		//gets the value 1 if this activity was started by the review page
		//otherwise the value is 0
		fromReview = getIntent().getIntExtra("review", 0);
		
		//Data of the Patient Details section from the previous activity
		final String[] patientDetails = getIntent().getStringArrayExtra("details");
		
		//Data of the employment history section from the previous activity
		final String[] employmentHist = getIntent().getStringArrayExtra("employment_history");
		
		//Data of the emergency contact section from the previous activity
		final String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");
		
		//link the checkboxes, textViews, and editTexts declared earlier
		//to the ones in screen4
		C_covered=(CheckBox) findViewById(R.id.ChB_covered);
		
		ins_Comp = (TextView)findViewById(R.id.textView_insurancecompany); 
		phone = (TextView)findViewById(R.id.textView_insurancecompanynumber);
		group_Num = (TextView)findViewById(R.id.textView_insurancecompanygroup); 
		policy_Num = (TextView)findViewById(R.id.textView_insurancecompanypolicy);
		
		ins_Comp_In = (EditText) findViewById(R.id.editText_insurancecompany);
        phone_In = (EditText) findViewById(R.id.editText_insurancephone);
        group_Num_In = (EditText) findViewById(R.id.editText_insurancegroupnumber);
        policy_Num_In = (EditText) findViewById(R.id.editText_insurancepolicy);
        
		C_self_insured=(CheckBox) findViewById(R.id.ChB_self_insured);
		
		holder_Name = (TextView)findViewById(R.id.textView_policyholder);
		rel_Holder = (TextView)findViewById(R.id.textView_policyrelationship);              
        
        holder_Name_In = (EditText) findViewById(R.id.editText_policyholdername);
        rel_Holder_In = (EditText) findViewById(R.id.editText_holderrelationship);
        
        C_secondary=(CheckBox) findViewById(R.id.ChB_secondary);
        
        ins_Comp_Sec = (TextView)findViewById(R.id.textView_insurancecompany2);
        phone_Sec = (TextView)findViewById(R.id.textView_insurancecompanyphone2);
        group_Num_Sec = (TextView)findViewById(R.id.textView_insurancecompanygroup2);
        policy_Num_Sec = (TextView)findViewById(R.id.textView_insurancecompanypolicy2); 
        
        ins_Comp_Sec_In = (EditText) findViewById(R.id.editText_insurancecompany2);
        phone_Sec_In = (EditText) findViewById(R.id.editText_insurancephone2);
        group_Num_Sec_In = (EditText) findViewById(R.id.editText_insurancegroupnumber2);
        policy_Num_Sec_In = (EditText) findViewById(R.id.editText_insurancepolicynumber2);
        
        // makes labels GONE
        //disables all the textViews, and editTexts
		ins_Comp.setVisibility(View.GONE);
		phone.setVisibility(View.GONE);
		group_Num.setVisibility(View.GONE); 
		policy_Num.setVisibility(View.GONE);
		
		
		// makes input fields GONE
		// ins_Comp_In.setEnabled(false);
		ins_Comp_In.setVisibility(View.GONE);
		phone_In.setVisibility(View.GONE);
		group_Num_In.setVisibility(View.GONE);
		policy_Num_In.setVisibility(View.GONE);
		
		holder_Name.setVisibility(View.GONE); 
		rel_Holder.setVisibility(View.GONE);
		holder_Name_In.setVisibility(View.GONE); 
		rel_Holder_In.setVisibility(View.GONE); 
		
		ins_Comp_Sec.setVisibility(View.GONE);
		phone_Sec.setVisibility(View.GONE);
		group_Num_Sec.setVisibility(View.GONE);
		policy_Num_Sec.setVisibility(View.GONE);
		
		ins_Comp_Sec_In.setVisibility(View.GONE);
		phone_Sec_In.setVisibility(View.GONE);
		group_Num_Sec_In.setVisibility(View.GONE);
		policy_Num_Sec_In.setVisibility(View.GONE);
		
		C_secondary.setEnabled(false);
		
		C_covered.setOnClickListener(new OnClickListener() {
			//when the covered checkbox is checked 
			public void onClick (View v) {
				
				if (C_covered.isChecked()) {
					ins_Comp.setVisibility(View.VISIBLE);
					ins_Comp_In.setFocusable(true);
					ins_Comp_In.setVisibility(View.VISIBLE);
					phone.setVisibility(View.VISIBLE);
					phone_In.setFocusable(true);
					phone_In.setVisibility(View.VISIBLE);
					group_Num.setVisibility(View.VISIBLE);
					group_Num_In.setFocusable(true);
					group_Num_In.setVisibility(View.VISIBLE);
					policy_Num.setVisibility(View.VISIBLE);
					policy_Num_In.setFocusable(true);
					policy_Num_In.setVisibility(View.VISIBLE);
					ins_Comp_In.requestFocus();
					
					//unchecks the other checkboxes if they're checked  
					if (C_self_insured.isChecked())
					{
						C_self_insured.setChecked(false);
					}
					
					// C_secondary.setEnabled(true);
					
					//enables the textviews and editTexts associated 
					//with the checkbox
					ins_Comp.setEnabled(true);
					phone.setEnabled(true);
					group_Num.setEnabled(true); 
					policy_Num.setEnabled(true); 
					
					ins_Comp_In.setEnabled(true);
					phone_In.setEnabled(true); 
					group_Num_In.setEnabled(true); 
					policy_Num_In.setEnabled(true); 
					//disables the other textViews and editTexts
					holder_Name.setEnabled(false); 
					rel_Holder.setEnabled(false);
					holder_Name_In.setEnabled(false); 
					rel_Holder_In.setEnabled(false); 
				}
				if (C_covered.isChecked() == false){
					//when it's not checked, disables the textViews and editTexts
					//previously enabled 
					ins_Comp.setVisibility(View.GONE);
					ins_Comp_In.setVisibility(View.GONE);
					phone.setVisibility(View.GONE);
					phone_In.setVisibility(View.GONE);
					group_Num.setVisibility(View.GONE);
					group_Num_In.setVisibility(View.GONE);
					policy_Num.setVisibility(View.GONE);
					policy_Num_In.setVisibility(View.GONE);
					
					if (C_secondary.isChecked())
						C_secondary.setChecked(false);
					C_secondary.setEnabled(false);
					
					ins_Comp_In.setEnabled(false);
					phone_In.setEnabled(false);
					group_Num_In.setEnabled(false);
					policy_Num_In.setEnabled(false);
					
					ins_Comp_Sec.setEnabled(false);
					phone_Sec.setEnabled(false);
					group_Num_Sec.setEnabled(false);
					policy_Num_Sec.setEnabled(false);
					
					ins_Comp_Sec_In.setEnabled(false);
					phone_Sec_In.setEnabled(false);
					group_Num_Sec_In.setEnabled(false);
					policy_Num_Sec_In.setEnabled(false);
				}
			}				
        });
        
        C_self_insured.setOnClickListener(new OnClickListener() {
			//when the self insured checkbox is checked
			public void onClick (View v){
				if (C_self_insured.isChecked()){ 
					
					holder_Name.setVisibility(View.VISIBLE);
					holder_Name_In.setFocusable(true);
					holder_Name_In.setVisibility(View.VISIBLE);
					rel_Holder.setVisibility(View.VISIBLE);
					rel_Holder_In.setFocusable(true);
					rel_Holder_In.setVisibility(View.VISIBLE);
					holder_Name_In.requestFocus();
					
					//unchecks the other checkboxes if they're checked
					if (C_covered.isChecked())
					{
						C_covered.setChecked(false);
					}
					/*if (C_secondary.isChecked()) {
						C_secondary.setChecked(false);
					}*/
					C_secondary.setEnabled(true);
					
					//enables the textviews and editTexts associated 
					//with the checkbox
					holder_Name.setEnabled(true); 					
					rel_Holder.setEnabled(true);
					holder_Name_In.setEnabled(true); 
					rel_Holder_In.setEnabled(true); 
					//disables the other textViews and editTexts
					ins_Comp.setEnabled(false);
					phone.setEnabled(false);
					group_Num.setEnabled(false); 
					policy_Num.setEnabled(false); 
					
					ins_Comp_In.setEnabled(false); 
					phone_In.setEnabled(false); 
					group_Num_In.setEnabled(false); 
					policy_Num_In.setEnabled(false); 
					
				}
				if (C_self_insured.isChecked() == false){ 
					//when it's not checked, disables the textViews and editTexts
					//previously enabled
					holder_Name.setVisibility(View.GONE); 
					holder_Name_In.setVisibility(View.GONE);
					rel_Holder.setVisibility(View.GONE);
					rel_Holder_In.setVisibility(View.GONE);
					
					if (C_secondary.isChecked())
						C_secondary.setChecked(false);
					C_secondary.setEnabled(false);
					
					holder_Name_In.setEnabled(false); 
					rel_Holder_In.setEnabled(false); 
					
					ins_Comp_Sec.setEnabled(false);
					phone_Sec.setEnabled(false);
					group_Num_Sec.setEnabled(false);
					policy_Num_Sec.setEnabled(false);
					
					ins_Comp_Sec_In.setEnabled(false);
					phone_Sec_In.setEnabled(false);
					group_Num_Sec_In.setEnabled(false);
					policy_Num_Sec_In.setEnabled(false);
				}
			}
		}); 
        
        C_secondary.setOnClickListener(new OnClickListener() {
        	//when the secondary insurance checkbox is checked
			public void onClick (View v){
				if (C_secondary.isChecked()){
					
					ins_Comp_Sec.setVisibility(View.VISIBLE);
					ins_Comp_Sec_In.setFocusable(true);
					ins_Comp_Sec_In.setVisibility(View.VISIBLE);
					phone_Sec.setVisibility(View.VISIBLE);
					phone_Sec_In.setFocusable(true);
					phone_Sec_In.setVisibility(View.VISIBLE);
					group_Num_Sec.setVisibility(View.VISIBLE);
					group_Num_Sec_In.setFocusable(true);
					group_Num_Sec_In.setVisibility(View.VISIBLE);
					policy_Num_Sec.setVisibility(View.VISIBLE);//found it
					policy_Num_Sec_In.setFocusable(true);
					policy_Num_Sec_In.setVisibility(View.VISIBLE);
					
					ins_Comp_Sec.setEnabled(true);
					phone_Sec.setEnabled(true);
					group_Num_Sec.setEnabled(true);
					policy_Num_Sec.setEnabled(true);
					
					ins_Comp_Sec_In.setEnabled(true);
					phone_Sec_In.setEnabled(true);
					group_Num_Sec_In.setEnabled(true);
					policy_Num_Sec_In.setEnabled(true);
				}
				
				if (C_secondary.isChecked() == false){
					//when it's not checked, disables the textViews and editTexts
					//previously enabled
					ins_Comp_Sec.setVisibility(View.GONE);
					phone_Sec.setVisibility(View.GONE);
					group_Num_Sec.setVisibility(View.GONE);
					policy_Num_Sec.setVisibility(View.GONE);
					
					ins_Comp_Sec_In.setVisibility(View.GONE);
					phone_Sec_In.setVisibility(View.GONE);
					group_Num_Sec_In.setVisibility(View.GONE);
					policy_Num_Sec_In.setVisibility(View.GONE);
				}
			}
        });
        
        //tasks the activity performs when it is started by the review page
        if (fromReview == 1){
        	
        	//sets the next button to finish button 
			b.setText("Finish");
			
			//gets the respective data through the review page in an array
			final String[] insurance = getIntent().getStringArrayExtra("insurance_Data");
			
			//assigns the data to specific variables
			final String insComp = insurance[0];
			final String phoneIns = insurance[1];
			final String gNum = insurance[2];
			final String polNum = insurance[3];
			
			final String holder = insurance[4];
			final String rel = insurance[5];
			
			final String insComp2 = insurance[6];
			final String phoneIns2 = insurance[7];
			final String gNum2 = insurance[8];
			final String polNum2 = insurance[9];
			
			//fill out the page with the retrieved data through the review page
			C_covered.setChecked(false);
			
			ins_Comp.setEnabled(false);
			ins_Comp_In.setEnabled(false);
			phone.setEnabled(false);
			phone_In.setEnabled(false);
			group_Num.setEnabled(false);
			group_Num_In.setEnabled(false);
			policy_Num.setEnabled(false);
			policy_Num_In.setEnabled(false);
			
			C_self_insured.setChecked(false);

			holder_Name.setEnabled(false);
			holder_Name_In.setEnabled(false);
			rel_Holder.setEnabled(false);
			rel_Holder_In.setEnabled(false);

			C_secondary.setChecked(false);
			
			ins_Comp_Sec.setEnabled(false);
			ins_Comp_Sec_In.setEnabled(false);
			phone_Sec.setEnabled(false);
			phone_Sec_In.setEnabled(false);
			group_Num_Sec.setEnabled(false);
			group_Num_Sec_In.setEnabled(false);
			policy_Num_Sec.setEnabled(false);
			policy_Num_Sec_In.setEnabled(false);
			
			if (insComp != "") {
				C_covered.setChecked(true);
				
				ins_Comp.setEnabled(true);
				ins_Comp_In.setEnabled(true);
				phone.setEnabled(true);
				phone_In.setEnabled(true);
				group_Num.setEnabled(true);
				group_Num_In.setEnabled(true);
				policy_Num.setEnabled(true);
				policy_Num_In.setEnabled(true);
				
				ins_Comp_In.setText(insComp);
				phone_In.setText(phoneIns);
				group_Num_In.setText(gNum);
				policy_Num_In.setText(polNum);
			}
			else {
				C_covered.setChecked(false);
				
				ins_Comp.setEnabled(false);
				ins_Comp_In.setEnabled(false);
				phone.setEnabled(false);
				phone_In.setEnabled(false);
				group_Num.setEnabled(false);
				group_Num_In.setEnabled(false);
				policy_Num.setEnabled(false);
				policy_Num_In.setEnabled(false);
			}
			
			if (holder != "") {
				C_self_insured.setChecked(true);
				
				holder_Name.setEnabled(true);
				holder_Name_In.setEnabled(true);
				rel_Holder.setEnabled(true);
				rel_Holder_In.setEnabled(true);
				
				holder_Name_In.setText(holder);
				rel_Holder_In.setText(rel);
			}
			else {
				C_self_insured.setChecked(false);

				holder_Name.setEnabled(false);
				holder_Name_In.setEnabled(false);
				rel_Holder.setEnabled(false);
				rel_Holder_In.setEnabled(false);
			}
			
			if (insComp2 != "") {
				C_secondary.setChecked(true);
				
				ins_Comp_Sec.setEnabled(true);
				ins_Comp_Sec_In.setEnabled(true);
				phone_Sec.setEnabled(true);
				phone_Sec_In.setEnabled(true);
				group_Num_Sec.setEnabled(true);
				group_Num_Sec_In.setEnabled(true);
				policy_Num_Sec.setEnabled(true);
				policy_Num_Sec_In.setEnabled(true);
				
				ins_Comp_Sec_In.setText(insComp2);
				phone_Sec_In.setText(phoneIns2);
				group_Num_Sec_In.setText(gNum2);
				policy_Num_Sec_In.setText(polNum2);
			}
			else {
				C_secondary.setChecked(false);
				
				ins_Comp_Sec.setEnabled(false);
				ins_Comp_Sec_In.setEnabled(false);
				phone_Sec.setEnabled(false);
				phone_Sec_In.setEnabled(false);
				group_Num_Sec.setEnabled(false);
				group_Num_Sec_In.setEnabled(false);
				policy_Num_Sec.setEnabled(false);
				policy_Num_Sec_In.setEnabled(false);
			}
        }
                
        
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent i;
            
            if (fromReview == 1) {
            	
            	//if this activity is started by the review page 
    			//the intent is assigned with a value that starts the review page
            	i = new Intent(NextActivity3.this, ReviewActivity.class);
            	
            	//Data of the patient details section from the review page
        		final String[] patientDetails = getIntent().getStringArrayExtra("details");
        		
        		//Data of the employment history section from the review page
    			final String[] employmentHist = getIntent().getStringArrayExtra("employment_history");

    			//Data of the emergency contact section from the review page
    			final String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");

    			//Data of the medical history section from the review page
    			final String[] medHistory = getIntent().getStringArrayExtra("medical_History_Data");
    			
    			//Data of the allergy section from the review page
    			final String[] allergies = getIntent().getStringArrayExtra("allergies");
    			
    			//put the data from the other activities in the intent for the review page
    			i.putExtra("employment_history", employmentHist);

        		i.putExtra("emergency_contact", emergencyContact);
    			
    			i.putExtra("details", patientDetails);
        		
        		i.putExtra("medical_History_Data", medHistory);
        		
        		i.putExtra("allergies", allergies);
            }
            else {
            	
            	//the intent is assigned with a value that start the next activity
            	i = new Intent(NextActivity3.this, NextActivity4.class);
            	
            	//put the data from the previous activities in the intent to preserve them through the next activity 
            	i.putExtra("details", patientDetails);
        		
        		i.putExtra("employment_history", employmentHist);
        		
        		i.putExtra("emergency_contact", emergencyContact);
            }
                        
            //gets the data from insurance section
            String insComp = ins_Comp_In.getText().toString();
            String insPhone = phone_In.getText().toString();
            String groupNum = group_Num_In.getText().toString();
            String policyNum = policy_Num_In.getText().toString();
            
            String holderName = holder_Name_In.getText().toString();
            String relationship = rel_Holder_In.getText().toString();
            
            String secInsComp = ins_Comp_Sec_In.getText().toString();
            String secInsPhone = phone_Sec_In.getText().toString();
            String secGroupNum = group_Num_Sec_In.getText().toString();
            String secPolicyNum = policy_Num_Sec_In.getText().toString();
            
            String[] insurance = {insComp, insPhone, groupNum, policyNum, holderName,
            					relationship, secInsComp, secInsPhone, secGroupNum, secPolicyNum};
            
            //pile all the received data on this activity to send it to the next one
    		i.putExtra("insurance_Data", insurance);
    		
    		i.putExtra("selected_state", getIntent().getIntExtra("selected_state", -1));
    		
            startActivity(i);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_activity3, menu);
		return true;
	}

}
