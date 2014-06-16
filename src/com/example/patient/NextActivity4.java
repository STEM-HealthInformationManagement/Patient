package com.example.patient;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class NextActivity4 extends Activity 
{
	private CheckBox C_heartD;
	private CheckBox C_highCol;
	private CheckBox C_highPress;
	private CheckBox C_diabetes;
	private CheckBox C_arthritis;
	private CheckBox C_hearLoss;
	private CheckBox C_kidneyStn;
	private CheckBox C_prostate;
	private CheckBox C_correctLens;
	private CheckBox C_neuroProb;
	private CheckBox C_asthma;
	private CheckBox C_cancer;
	private CheckBox C_sTD;
	private CheckBox C_anemia;
	private CheckBox C_seizures;
	private CheckBox C_ulcers;
	private CheckBox C_stroke;
	private CheckBox C_earProb;
	private CheckBox C_depression;
	private Button clearButton;
	
	ArrayList<String> medHistory = new ArrayList<String>();
	
	int fromReview;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen6);
		
		Button b = (Button) findViewById(R.id.button2);
		
		//gets the value 1 if this activity was started by the review page
		//otherwise the value is 0
		fromReview = getIntent().getIntExtra("review", 0);
		
		//medical history 
		C_heartD = (CheckBox) findViewById(R.id.checkBox1);
		C_highCol = (CheckBox) findViewById(R.id.checkBox2);
		C_highPress = (CheckBox) findViewById(R.id.checkBox3);
		C_diabetes = (CheckBox) findViewById(R.id.checkBox4);
		C_arthritis = (CheckBox) findViewById(R.id.checkBox5);
		C_hearLoss =(CheckBox) findViewById(R.id.checkBox6);
		C_kidneyStn = (CheckBox) findViewById(R.id.checkBox7);
		C_prostate = (CheckBox) findViewById(R.id.checkBox8);
		C_correctLens = (CheckBox) findViewById(R.id.checkBox11);
		C_neuroProb = (CheckBox) findViewById(R.id.checkBox12);
		C_asthma = (CheckBox) findViewById(R.id.checkBox13);
		C_cancer = (CheckBox) findViewById(R.id.checkBox14);
		C_sTD = (CheckBox) findViewById(R.id.checkBox15);
		C_anemia = (CheckBox) findViewById(R.id.checkBox17);
		C_seizures = (CheckBox) findViewById(R.id.checkBox16);
		C_ulcers = (CheckBox) findViewById(R.id.checkBox9);
		C_stroke =(CheckBox) findViewById(R.id.checkBox10);
		C_earProb = (CheckBox) findViewById(R.id.checkBox18);
		C_depression = (CheckBox) findViewById(R.id.checkBox19);
		
		clearButton = (Button) findViewById(R.id.button1);
		clearButton.setOnClickListener (new View.OnClickListener()
		{
			public void onClick(View v)
			{
				clearAll((ViewGroup) findViewById(R.id.RelativeLayout1));
			}
		});
		
		//tasks the activity performs when it is started by the review page
		if (fromReview == 1) {
			
			//sets the next button to finish button 
			b.setText("Finish");			

            checkChecked((ViewGroup) findViewById(R.id.RelativeLayout1));
		}
		
		
        b.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {

        		//Data of the Patient Details section from the previous activity
        		String[] patientDetails = getIntent().getStringArrayExtra("details");

        		//Data of the employment history section from the previous activity
        		String[] employmentHist = getIntent().getStringArrayExtra("employment_history");

        		//Data of the emergency contact section from the previous activity
        		String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");
        		
        		//Data of the insurance section from the previous activity
        		String[] insurance = getIntent().getStringArrayExtra("insurance_Data");
        		
        		String heartD = null;
        		String highCol = null;
        		String highPress = null;
        		String diabetes = null;
        		String arthritis = null;
        		String hearLoss = null;
        		String kidneyStn = null;
        		String prostate = null;
        		String correctLens = null;
        		String neuroProb = null;
        		String asthma = null;
        		String cancer = null;
        		String sTD = null;
        		String anemia = null;
        		String seizures = null;
        		String ulcers = null;
        		String stroke = null;
        		String earProb = null;
        		String depression = null;

        		if (C_heartD.isChecked()){
        			heartD = "Heart Disease";
        			medHistory.add(heartD);
        		}
        		
        		if (C_highCol.isChecked())
        		{
        			highCol = "High Cholesterol";
        			medHistory.add(highCol);
        		}
        		if (C_highPress.isChecked()){
        			highPress = "High Blood Prressure";
        			medHistory.add(highPress);
        		}
        		if (C_diabetes.isChecked()){
        			diabetes = "Diabetes";
        			medHistory.add(diabetes);
        		}
        		if (C_arthritis.isChecked()){
        			arthritis = "Arthritis";
        			medHistory.add(arthritis);
        		}
        		if (C_hearLoss.isChecked()){
        			hearLoss = "Hearing Loss";
        			medHistory.add(hearLoss);
        		}
        		if (C_kidneyStn.isChecked()){
        			kidneyStn = "Kidney Stones";
        			medHistory.add(kidneyStn);
        		}
        		if (C_prostate.isChecked()){
        			prostate = "Prostate Problems";
        			medHistory.add(prostate);
        		}
        		if (C_correctLens.isChecked()){
        			correctLens = "Corrective Lenses";
        			medHistory.add(correctLens);
        		}
        		if (C_neuroProb.isChecked()){
        			neuroProb = "Neurological Problems";
        			medHistory.add(neuroProb);
        		}
        		if (C_asthma.isChecked()){
        			asthma = "Asthma";
        			medHistory.add(asthma);
        		}
        		if (C_cancer.isChecked()){
        			cancer = "Cancer";
        			medHistory.add(cancer);
        		}
        		if (C_sTD.isChecked()){
        			sTD = "Sexually Transmitted Disease";
        			medHistory.add(sTD);
        		}
        		if (C_anemia.isChecked()){
        			anemia = "Anemia";
        			medHistory.add(anemia);
        		}
        		if (C_seizures.isChecked()){
        			seizures = "Seizures";
        			medHistory.add(seizures);
        		}
        		if (C_ulcers.isChecked()){
        			ulcers = "Ulcers";
        			medHistory.add(ulcers);
        		}
        		if (C_stroke.isChecked()){
        			stroke = "Stroke";
        			medHistory.add(stroke);
        		}
        		if (C_earProb.isChecked()){
        			earProb = "Ear Problems";
        			medHistory.add(earProb);
        		}
        		if (C_depression.isChecked()){
        			depression = "Depression";
        			medHistory.add(depression);
        		}
/*        		final String[] medHistory = { heartD,  highCol, highPress, diabetes, arthritis, 
        									hearLoss, kidneyStn, prostate, correctLens, neuroProb,
        									asthma, cancer, sTD, anemia, seizures, ulcers, stroke, 
        									earProb, depression};
*/
        		Intent i;
        		if (fromReview == 1) {
        			i = new Intent(NextActivity4.this, ReviewActivity.class);
        			
        			//Data of the patient details section from the review page
            		patientDetails = getIntent().getStringArrayExtra("details");
            		
            		//Data of the insurance section from the review page
        			insurance = getIntent().getStringArrayExtra("insurance_Data");
        			
            		//Data of the employment history section from the review page
        			employmentHist = getIntent().getStringArrayExtra("employment_history");

        			//Data of the emergency contact section from the review page
        			emergencyContact = getIntent().getStringArrayExtra("emergency_contact");
        			
        			//Data of the allergy section from the review page
        			final String[] allergies = getIntent().getStringArrayExtra("allergies");
        			
        			i.putExtra("details", patientDetails);
        			
        			i.putExtra("insurance_Data", insurance);
            		
        			i.putExtra("employment_history", employmentHist);

            		i.putExtra("emergency_contact", emergencyContact);        			
        			
            		i.putExtra("allergies", allergies);
        		}
        		else {
        			i = new Intent(NextActivity4.this, NextActivity6.class);
        			
        			i.putExtra("details", patientDetails);
        			
        			i.putExtra("insurance_Data", insurance);
            		
            		i.putExtra("employment_history", employmentHist);
            		
            		i.putExtra("emergency_contact", emergencyContact);
        		}
        		
        		
        		//pile all the data on this activity to send it to the next one
        		i.putStringArrayListExtra("medical_History_Data", medHistory);
        		
        		i.putExtra("selected_state", getIntent().getIntExtra("selected_state", -1));
        		
        		startActivity(i);
        	}
        });
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next_activity4, menu);
		return true;
	}
	
	public void checkChecked(ViewGroup root) 
	{

		int k = 0;  
		
		//gets the respective data through the review page in an array
		//final String[] medHistory = getIntent().getStringArrayExtra("medical_History_Data");
		//final ArrayList<String> medHistory = new ArrayList<String>();
	    for (int i = 0, j = root.getChildCount(); i < j; i++) 
	    {
	        View view = root.getChildAt(i);
	        if (view instanceof ViewGroup) 
	        {
	        	checkChecked((ViewGroup) view);
	            continue;
	        }
	        if (view instanceof CheckBox) 
	        {
	        	
	        	if (k<=18)
	        	{
	        		if (medHistory.get(k).toString() != null) {
	    				((CheckBox) view).setChecked(true);	    				
		        	}	
	        		k++;
	        		continue; 
	        	}
	            break;            
	        }
	    }
	}

	public void clearAll(ViewGroup root) 
	{
	    for (int i = 0, j = root.getChildCount(); i < j; i++) 
	    {
	        View view = root.getChildAt(i);
	        if (view instanceof ViewGroup) 
	        {
	            clearAll((ViewGroup) view);
	            continue;
	        }
	        if (view instanceof CheckBox) 
	        {
	            ((CheckBox) view).setChecked(false);
	            continue;
	        }
	    }
	}
}
