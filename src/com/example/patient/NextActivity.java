//screen2.xml
package com.example.patient;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class NextActivity extends Activity {
	
	EditText dFirstName;
	EditText dMiddleName;
	EditText dLastName;
	RadioButton dGenderFem;
	RadioButton dGenderMale;
	RadioButton dMarried;
	RadioButton dSingle;
	EditText dSocialSec;
	EditText dAddress;
	EditText dAddress2;
	EditText dCity;
	Spinner dState;
	EditText dZipCode;
	EditText dEmail;
	EditText dPhone;

	
	
	private String initialDate;
	private String initialMonth;
	private String initialYear;
	private 
	DatePickerDialog datePicking2 = null;
	private EditText date; 
	private String title; 
	Context context;
	
	
	
	
	int fromReview;

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen2);
		
		date = (EditText) findViewById(R.id.editText_dob);
		context = getApplicationContext();
		title = "Choose your date of birth";
		//next page button
		Button b = (Button) findViewById(R.id.btn_Confirm);
		//gets the value 1 if this activity was started by the review page
		//otherwise the value is 0
		fromReview = getIntent().getIntExtra("review", 0);
		
		dFirstName = (EditText) findViewById(R.id.editText_firstname);
		dMiddleName = (EditText) findViewById(R.id.editText_middlename);
		dLastName = (EditText) findViewById(R.id.editText_lastname);
		
		dGenderFem = (RadioButton) findViewById(R.id.radioButton_female);
		dGenderMale = (RadioButton) findViewById(R.id.radioButton_male);
		
		dMarried = (RadioButton) findViewById(R.id.radioButton_Married);
		dSingle = (RadioButton) findViewById(R.id.radioButton_Single);
		
		dSocialSec = (EditText) findViewById(R.id.editText_ssn);
		dAddress = (EditText) findViewById(R.id.editText_Address1);
		dAddress2 = (EditText) findViewById(R.id.editText_Address2);
		dCity = (EditText) findViewById(R.id.editText_city);
		
		dState = (Spinner) findViewById(R.id.spinner_states); 
		
		dZipCode = (EditText) findViewById(R.id.editText_zipcode);
		dEmail = (EditText) findViewById(R.id.editText_email);
		dPhone = (EditText) findViewById(R.id.editText_phone);
		
		
		//tasks the activity performs when it is started by the review page
		if (fromReview == 1){
			//sets the next button to finish button 
			b.setText("Finish");
			
			//gets the respective data through the review page in an array 
			String[] patientDetails = getIntent().getStringArrayExtra("details");
			//assigns the data to specific variables
			final String iFirstName = patientDetails[0];
			final String iMiddleName = patientDetails[1];
			final String iLastName = patientDetails[2];		
			final String iGender = patientDetails[3];
			final String iDOB = patientDetails[4];
			final String iStatus = patientDetails[5];
			final String iSSN = patientDetails[6];
			final String iAddress = patientDetails[7];
			final String iCity = patientDetails[8];
			final String iState = patientDetails[9];
			final String iZip = patientDetails[10];
			final String iEmail = patientDetails[11];
			final String iPhone = patientDetails[12];
			
			final String iAddress2 = patientDetails[13];
			//fill out the page with the retrieved data through the review page
			dFirstName.setText(iFirstName);
			dMiddleName.setText(iMiddleName);
			dLastName.setText(iLastName);
			
			if (iGender == "Gender: Female"){
				dGenderFem.setChecked(true);
			}
			else {
				dGenderMale.setChecked(true);
			}
			
			date.setText(iDOB);
			
			if (iStatus == "Marital Status: Married"){
				dMarried.setChecked(true);
			}
			else {
				dSingle.setChecked(true);
			}
			
			dSocialSec.setText(iSSN);
			dAddress.setText(iAddress);
			dAddress2.setText(iAddress2);
			dCity.setText(iCity);			
			dState.setSelection(getIntent().getIntExtra("selected_state", -1));
			dZipCode.setText(iZip);
			dEmail.setText(iEmail);
			dPhone.setText(iPhone);
			
		}
		
		//button to pop up the datepicker 
        ImageButton dateButton = (ImageButton) findViewById(R.id.imageButton_date);
        
        dateButton.setOnClickListener(new View.OnClickListener() {
        	@SuppressLint("NewApi") @Override 
        	public void onClick(View v) {
            	       		
        		Calendar  dtTxt = null;
                
        		String preExistingDate = (String) date.getText().toString();
        		
        		if (preExistingDate != null && !preExistingDate.equals("")) {
        			StringTokenizer st = new StringTokenizer(preExistingDate,"/");
        			initialMonth = st.nextToken();
        			initialDate = st.nextToken();
        			initialYear = st.nextToken();
        			
        			if (datePicking2 == null) {
        				datePicking2 = new DatePickerDialog(v.getContext(), new PickDate(), Integer.parseInt(initialYear), 
        						Integer.parseInt(initialMonth) - 1, Integer.parseInt(initialDate));        				
        			}
        			
        			datePicking2.updateDate(Integer.parseInt(initialYear), Integer.parseInt(initialMonth) - 1, 
        					Integer.parseInt(initialDate));
        			
        		}
        		else {
        			dtTxt = Calendar.getInstance(); 
        			if (datePicking2 == null) {
        				datePicking2 = new DatePickerDialog(v.getContext(), new PickDate(), dtTxt.getTime().getYear(),dtTxt.getTime().getMonth(), 
        						dtTxt.getTime().getDay());
        			}
        			
        			datePicking2.updateDate(dtTxt.getTime().getYear(), dtTxt.getTime().getMonth(), dtTxt.getTime().getDay());
        		}
                datePicking2.setTitle(title);
                DatePicker dateCeption = datePicking2.getDatePicker();
                dateCeption.setCalendarViewShown(false);
                long currentDay = Calendar.getInstance().getTimeInMillis();
                dateCeption.getCalendarView().setDate(currentDay);
                
                datePicking2.show();
            }
        });
        
        // when the next page button is clicked
        b.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		
        		Intent i;
        		if (fromReview == 1 && firstName != null && lastName != null)) {
        			//if this activity is started by the review page 
        			//the intent is assigned with a value that starts the review page
        			i = new Intent(NextActivity.this, ReviewActivity.class);
        			
        			//Data of the employment history section from the review page
        			final String[] employmentHist = getIntent().getStringArrayExtra("employment_history");

        			//Data of the emergency contact section from the review page
        			final String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");

        			//Data of the insurance section from the review page
        			final String[] insurance = getIntent().getStringArrayExtra("insurance_Data");

        			//Data of the medical history section from the review page
        			final String[] medHistory = getIntent().getStringArrayExtra("medical_History_Data");
        			
        			//Data of the allergy section from the review page
        			final String[] allergies = getIntent().getStringArrayExtra("allergies");
        			
        			//put the data from the other activities for the review page
        			i.putExtra("employment_history", employmentHist);

            		i.putExtra("emergency_contact", emergencyContact);

            		i.putExtra("insurance_Data", insurance);
            		
            		i.putExtra("medical_History_Data", medHistory);
            		
            		i.putExtra("allergies", allergies);
        			
        		}
        		else {
        			//the intent is assigned with a value that start the next activity
        			i = new Intent(NextActivity.this, NextActivity2.class);
        		}
        		
        		//gets the data entered by the user
        		String firstName = dFirstName.getText().toString();
        		String middleName = dMiddleName.getText().toString();
        		String lastName = dLastName.getText().toString();
        		
        		String genderSelected = "Gender: not selected";
				if (dGenderFem.isChecked()) {
					genderSelected = "Gender: Female";			
        		}
				
				if (dGenderMale.isChecked()) {
        			genderSelected = "Gender: Male";
        		}
        		        		
        		String birthDate = date.getText().toString();
        		
        		String status = "Marital Status: not selected";
        		if (dMarried.isChecked()) {
        			status = "Marital Status: Married";
        		}
        		
        		if (dSingle.isChecked()) {
        			status = "Marital Status: Single";
        		}
        		
        		String ssn = dSocialSec.getText().toString();
        		
        		String address1 = dAddress.getText().toString();

        		String address2 = dAddress2.getText().toString();

        		String city = dCity.getText().toString();
        		String state = dState.getItemAtPosition(dState.getSelectedItemPosition()).toString();
        		
        		int statePos = dState.getSelectedItemPosition();
        		i.putExtra("selected_state", statePos);
        		
        		String zip = dZipCode.getText().toString();
        		String email = dEmail.getText().toString();
        		String phone = dPhone.getText().toString(); 
        		//puts the data in an array 
        		
        		if  ( firstName != null || lastName != null)
        		
   
        		String[] patientDetails = { firstName, middleName, lastName, genderSelected, birthDate, status, ssn, address1, city, state, zip,
        									email, phone,  address2 };
        		//puts the array in an intent to be sent to the next activity 
        		i.putExtra("details", patientDetails);
        		
        		startActivity(i);
        	
        	}
        });
        //clear button 
		Button clearButton = (Button) findViewById(R.id.button1);
		clearButton.setOnClickListener (new View.OnClickListener()
		{
			public void onClick(View w)
			{
				clearAll((ViewGroup) findViewById(R.id.RelativeLayout1));
			}
		});
		
		
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
		return true;
	}
	
	private class PickDate implements DatePickerDialog.OnDateSetListener {

	    @Override
	    public void onDateSet(DatePicker view, int year, int monthOfYear,
	            int dayOfMonth) {
	        view.updateDate(year, monthOfYear + 1, dayOfMonth);
	        date.setText(monthOfYear+"/"+dayOfMonth+"/"+year);
	        datePicking2.hide();
	    }

	}
//clear button for edittexts and radiogroups
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
	        if (view instanceof EditText) 
	        {
	            ((EditText) view).setText("");
	            continue;
	        }
	        ViewGroup parent = (ViewGroup) findViewById(R.id.RelativeLayout1);
	        for (int k = 0; k < parent.getChildCount(); k++) 
	        {
	            View currentView = parent.getChildAt(k);
	            if (currentView instanceof RadioGroup) 
	            {
	                ((RadioGroup) currentView).clearCheck();
	            }
	        }	        
	    }
	}
}