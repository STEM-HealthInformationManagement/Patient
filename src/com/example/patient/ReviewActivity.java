package com.example.patient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.patient.R.color;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Color;
import android.graphics.drawable.Drawable;



public class ReviewActivity extends Activity {
	
	private Intent fromReview;
	private TextView firstName;
	private TextView middleName;
	private TextView lastName;
	private Button submitBtn;
	private TextView gender;
	private TextView birthDate;
	private TextView marital; 
	private TextView socialSec;
	private TextView address;
	private TextView email;
	private TextView phone;
	
	// employment history section on the review page
	private TextView employerName;
	private TextView employerPhone;
	private TextView occupation; 
	private TextView employerAddress; 
	
	//emergency contact section on the review page
	private TextView contact1Name;
	private TextView contact1Phone;
	private TextView contact1Rel;
	
	private TextView contact2Name;
	private TextView contact2Phone;
	private TextView contact2Rel; 
	
	//insurance section 
	private TextView insCompany;
	private TextView insPhone; 
	private TextView groupNum;
	private TextView policyNum;
	
	private TextView holderName;
	private TextView relationship;
	
	private TextView secInsCompany;
	private TextView secInsPhone; 
	private TextView secGroupNum;
	private TextView secPolicyNum;
	
	//medical history section on the review page
	private TextView heartDisease;
	private TextView highCholesterol;
	private TextView highBloodPressure;
	private TextView diabetes;
	private TextView arthritis;
	private TextView hearingLoss;
	private TextView kidneyStones;
	private TextView prostateProblems;
	private TextView correctiveLenses; 
	private TextView neurologicalProblem;
	private TextView asthma;
	private TextView cancer;
	private TextView STD; 
	private TextView anemia;
	private TextView seizures;
	private TextView ulcers;
	private TextView stroke; 
	private TextView earProblems;
	private TextView depression; 

	//allergy section on the review page
	private TextView medAllergies;
	private TextView allergy1;
	private TextView allergy2;
	private TextView allergy3;
	private TextView allergy4;
	private TextView allergy5;
	private TextView reaction1;
	private TextView reaction2;
	private TextView reaction3;
	private TextView reaction4;
	private TextView reaction5;
	
	

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_review);
		
		//patient details section on the review page
		firstName = (TextView) findViewById(R.id.reviewFirstName);
		middleName = (TextView) findViewById(R.id.reviewMiddleName);
		lastName = (TextView) findViewById(R.id.reviewLastName);
		gender = (TextView) findViewById(R.id.reviewGender);
		birthDate = (TextView) findViewById(R.id.reviewDOB);
		marital = (TextView) findViewById(R.id.reviewMarital);
		socialSec = (TextView) findViewById(R.id.reviewSocialSec);
		address = (TextView) findViewById(R.id.reviewAddress);
		email = (TextView) findViewById(R.id.reviewEmail);
		phone = (TextView) findViewById(R.id.reviewPhone);
		
		// employment history section on the review page
		employerName = (TextView) findViewById(R.id.reviewEmployerCompany);
		employerPhone = (TextView) findViewById(R.id.reviewEmployerPhone);
		occupation = (TextView) findViewById(R.id.reviewOccupation);
		employerAddress = (TextView) findViewById(R.id.reviewEmployerAddress);
		
		//emergency contact section on the review page
		contact1Name = (TextView) findViewById(R.id.reviewEmergencyContactName1);
		contact1Phone = (TextView) findViewById(R.id.reviewEmergencyContactPhone1);
		contact1Rel = (TextView) findViewById(R.id.reviewEmergencyContactRelationship1);
		
		contact2Name = (TextView) findViewById(R.id.reviewEmergencyContactName2);
		contact2Phone = (TextView) findViewById(R.id.reviewEmergencyContactPhone2);
		contact2Rel = (TextView) findViewById(R.id.reviewEmergencyContactRelationship2);
		
		//insurance section 
		insCompany = (TextView) findViewById(R.id.reviewInsuranceCompany);
		insPhone = (TextView) findViewById(R.id.reviewInsurancePhoneNumber);
		groupNum = (TextView) findViewById(R.id.reviewInsuranceGroupNumber);
		policyNum = (TextView) findViewById(R.id.reviewInsurancePolicyNumber);
		
		holderName = (TextView) findViewById(R.id.reviewPolicyHolderName);
		relationship = (TextView) findViewById(R.id.reviewPolicyHolderRelationship);
		
		secInsCompany = (TextView) findViewById(R.id.reviewInsurance2);
		secInsPhone = (TextView) findViewById(R.id.reviewInsurancePhoneNumber2);
		secGroupNum = (TextView) findViewById(R.id.reviewInsuranceGroupNumber2);
		secPolicyNum = (TextView) findViewById(R.id.reviewInsurancePolicyNumber2);
		
		//medical history section on the review page
		heartDisease = (TextView) findViewById(R.id.reviewHeartDisease);
		highCholesterol = (TextView) findViewById(R.id.reviewHeartCholesterol);
		highBloodPressure = (TextView) findViewById(R.id.reviewHighBloodPressure);
		diabetes = (TextView) findViewById(R.id.reviewDiabetes);
		arthritis = (TextView) findViewById(R.id.reviewArthritis);
		hearingLoss = (TextView) findViewById(R.id.reviewHearingLoss);
		kidneyStones = (TextView) findViewById(R.id.reviewKidneyStones);
		prostateProblems = (TextView) findViewById(R.id.reviewProstateProblems);
		correctiveLenses = (TextView) findViewById(R.id.reviewCorrectiveLenses);
		neurologicalProblem = (TextView) findViewById(R.id.reviewNeurologicalProblem);
		asthma = (TextView) findViewById(R.id.reviewAsthma);
		cancer = (TextView) findViewById(R.id.reviewCancer);
		STD = (TextView) findViewById(R.id.reviewSTD);
		anemia = (TextView) findViewById(R.id.reviewAnemia);
		seizures = (TextView) findViewById(R.id.reviewSeizures);
		ulcers = (TextView) findViewById(R.id.reviewUlcers);
		stroke = (TextView) findViewById(R.id.reviewStroke);
		earProblems = (TextView) findViewById(R.id.reviewEarProblems);
		depression = (TextView) findViewById(R.id.reviewDepression);

		//allergy section on the review page
		medAllergies = (TextView) findViewById(R.id.reviewMedicationAllergies);
		allergy1 = (TextView) findViewById(R.id.reviewAllergy1);
		allergy2 = (TextView) findViewById(R.id.reviewAllergy2);
		allergy3 = (TextView) findViewById(R.id.reviewAllergy3);
		allergy4 = (TextView) findViewById(R.id.reviewAllergy4);
		allergy5 = (TextView) findViewById(R.id.reviewAllergy5);
		reaction1 = (TextView) findViewById(R.id.reviewReaction1);
		reaction2 = (TextView) findViewById(R.id.reviewReaction2);
		reaction3 = (TextView) findViewById(R.id.reviewReaction3);
		reaction4 = (TextView) findViewById(R.id.reviewReaction4);
		reaction5 = (TextView) findViewById(R.id.reviewReaction5);
		
		//Data of the patient details section from the previous activity
		final String[] patientDetails = getIntent().getStringArrayExtra("details");

		//Data of the employment history section from the previous activity
		final String[] employmentHist = getIntent().getStringArrayExtra("employment_history");

		//Data of the emergency contact section from the previous activity
		final String[] emergencyContact = getIntent().getStringArrayExtra("emergency_contact");
		
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
		
		final String empName = employmentHist[0];
		final String empPhone = employmentHist[1];
		final String occup = employmentHist[2];
		final String empAddress = employmentHist[3];

		final String cName1 = emergencyContact[0];
		final String cPhone1 = emergencyContact[1];
		final String cRelation1 = emergencyContact[2];

		final String cName2 = emergencyContact[3];
		final String cPhone2 = emergencyContact[4];
		final String cRelation2 = emergencyContact[5];
		
		//Data of the insurance section from the previous activity
		final String[] insurance = getIntent().getStringArrayExtra("insurance_Data");
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
		
		//Data of the medical history section from the previous activity
		final String[] medHistory = getIntent().getStringArrayExtra("medical_History_Data");
		String heartD = medHistory[0];
		String highCol = medHistory[1];
		String highPress = medHistory[2];
		String diab = medHistory[3];
		String arth = medHistory[4];
		String hearLoss = medHistory[5];
		String kidneyStn = medHistory[6];
		String prostate = medHistory[7];
		String correctLens = medHistory[8];
		String neuroProb = medHistory[9];
		String asthm = medHistory[10];
		String canc = medHistory[11];
		String sTD = medHistory[12];
		String anem = medHistory[13];
		String seizr = medHistory[14];
		String ulcrs = medHistory[15];
		String strk = medHistory[16];
		String earProb = medHistory[17];
		String depressn = medHistory[18];
		
		//Data of the allergy section from the previous activity
		final String[] allergies = getIntent().getStringArrayExtra("allergies");
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
		
		//sets the all the collected data to be viewed on the review page 
		firstName.setText("Firstname: " + iFirstName);
		if (iMiddleName.equals("")||iMiddleName.isEmpty()){
			middleName.setVisibility(View.GONE);
		}
		middleName.setText("Middlename: " +  iMiddleName);
		lastName.setText("Lastname: " + iLastName);
		gender.setText(iGender);
		birthDate.setText("Date of birth: " + iDOB);
		marital.setText(iStatus);
		socialSec.setText("Social Security Number: " + iSSN);
		
		if (iAddress2.equals("")||iAddress2.isEmpty()){
			address.setText("Address: " + iAddress + ", " + iCity + ", " + iState + " " + iZip);
		}
		else {
			address.setText("Address: " + iAddress + " " + iAddress2 + ", " + iCity + ", " + iState + " " + iZip);
		}
		
		email.setText("Email: " + iEmail);
		phone.setText("Phone: " + iPhone);
		
		employerName.setText("Employer: " + empName);
		employerPhone.setText("Phone: " + empPhone);
		occupation.setText("Occupation: " + occup);
		employerAddress.setText("Address: " + empAddress);
		
		contact1Name.setText("Name: " + cName1);
		contact1Phone.setText("Phone: " + cPhone1);
		contact1Rel.setText("Relationship: " + cRelation1);

		contact2Name.setText("Name: " + cName2);
		contact2Phone.setText("Phone: " + cPhone2);
		contact2Rel.setText("Relationship: " + cRelation2);
 		
		insCompany.setText("Company: " + insComp);
		insPhone.setText("Phone: " + phoneIns);
		groupNum.setText("Group Number: " + gNum);
		policyNum.setText("Policy Number: " + polNum);
		if (insComp.equals("")){
			insCompany.append("Not covered by any");
			insCompany.setEnabled(false);
			insPhone.setVisibility(View.GONE);
			groupNum.setVisibility(View.GONE);
			policyNum.setVisibility(View.GONE);
		}
		
		holderName.setText("Policy Holder: " + holder);
		relationship.setText("Relationship: " + rel);
		if (holder.equals("")){
			holderName.setVisibility(View.GONE);
			relationship.setVisibility(View.GONE);
		}
		
		secInsCompany.setText("2nd Company: " + insComp2);
		secInsPhone.setText("Phone: " + phoneIns2);
		secGroupNum.setText("Group Number: " + gNum2);
		secPolicyNum.setText("Policy Number: " + polNum2);
		if (insComp2.equals("")){
			secInsCompany.append("no secondary insurance");
			secInsCompany.setEnabled(false);
			secInsPhone.setVisibility(View.GONE);
			secGroupNum.setVisibility(View.GONE);
			secPolicyNum.setVisibility(View.GONE);
		}
		
		//Medical history
		int deadAndGone = 0;
	    
	    //heart disease
		if (heartD != null){
			heartDisease.setText(heartD);
		}
		else {
			heartDisease.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//high cholesterol
		if (highCol != null) {
			highCholesterol.setText(highCol);
		}
		else {
			highCholesterol.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//high blood pressure
		if (highPress != null) {
			highBloodPressure.setText(highPress);
		}
		else {
			highBloodPressure.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//diabetes
		if (diab != null) {
			diabetes.setText(diab);
		}
		else {
			diabetes.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//arthritis
		if (arth != null) {
			arthritis.setText(arth);
		}
		else {
			arthritis.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//hearing loss
		if (hearLoss != null) {
			hearingLoss.setText(hearLoss);
		}
		else {
			hearingLoss.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//kidney stones
		if (kidneyStn != null) {
			kidneyStones.setText(kidneyStn);
		}
		else { 
			kidneyStones.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//prostate problems 
		if (prostate != null){
			prostateProblems.setText(prostate);
		}
		else {
			prostateProblems.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//corrective lenses
		if (correctLens != null) {
			correctiveLenses.setText(correctLens);
		}
		else {
			correctiveLenses.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//neurological problems
		if (neuroProb != null) {
			neurologicalProblem.setText(neuroProb);
		}
		else {
			neurologicalProblem.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//asthma 
		if (asthm != null) {
			asthma.setText(asthm);
		}
		else {
			asthma.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//cancer
		if (canc != null) {
			cancer.setText(canc);
		}
		else {
			cancer.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//STD
		if (sTD != null) {
			STD.setText(sTD);
		}
		else {
			STD.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//anemia
		if (anem != null){
			anemia.setText(anem);
		}
		else {
			anemia.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//seizures
		if (seizr != null) {
			seizures.setText(seizr);
		}
		else {
			seizures.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//ulcers
		if (ulcrs != null) {
			ulcers.setText(ulcrs);
		}
		else {
			ulcers.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//stroke
		if (strk != null) {
			stroke.setText(strk);
		}
		else {
			stroke.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//ear problems
		if (earProb != null) {
			earProblems.setText(earProb);
		}
		else {
			earProblems.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//depression
		if (depressn != null) {
			depression.setText(depressn);
		}
		else {
			depression.setVisibility(View.GONE);
			deadAndGone++;
		}
		
		//check if nothing is shown;
		if (deadAndGone == 19) {
			String noHist = "No medical history";
			depression.setText(noHist);
			depression.setVisibility(View.VISIBLE);
			depression.setEnabled(false);
		}
		
		//allergies
		int xBoxGone = 0;
		
		if (sAllergy1 != null && sReaction1 != null){
			allergy1.setText(sAllergy1);
			reaction1.setText(sReaction1);
		}
		else {
			allergy1.setVisibility(View.GONE);
			reaction1.setVisibility(View.GONE);
			xBoxGone++;
		}

		if (sAllergy2 != null && sReaction2 != null){
			allergy2.setText(sAllergy2);
			reaction2.setText(sReaction2);
		}
		else {
			allergy2.setVisibility(View.GONE);
			reaction2.setVisibility(View.GONE);
			xBoxGone++;
		}

		if (sAllergy3 != null && sReaction3 != null){
			allergy3.setText(sAllergy3);
			reaction3.setText(sReaction3);
		}
		else {
			allergy3.setVisibility(View.GONE);
			reaction3.setVisibility(View.GONE);
			xBoxGone++;
		}

		if (sAllergy4 != null && sReaction4 != null){
			allergy4.setText(sAllergy4);
			reaction4.setText(sReaction4);
		}
		else {
			allergy4.setVisibility(View.GONE);
			reaction4.setVisibility(View.GONE);
			xBoxGone++;
		}

		if (sAllergy5 != null && sReaction5 != null){
			allergy5.setText(sAllergy5);
			reaction5.setText(sReaction5);
		}
		else {
			allergy5.setVisibility(View.GONE);
			reaction5.setVisibility(View.GONE);
			xBoxGone++;
		}
		
		if (xBoxGone == 5 || sAllergy1.equals("no allergies")) {
			medAllergies.setText("No known allergies");
			medAllergies.setEnabled(false);
			allergy1.setVisibility(View.GONE);
			reaction1.setVisibility(View.GONE);
		}
		
		//Jeff added code for submission
		//
		//
		//If App Crashes Just Comment out code from here down 
		//
		// =) wish me luck 
			
		//change textview to edit text
		firstName =(TextView) this.findViewById(R.id.reviewFirstName);
		middleName=(TextView) this.findViewById(R.id.reviewMiddleName);
		lastName=(TextView) this.findViewById(R.id.reviewLastName);

		
	}
	
	//jeff code
		public void onClick(View v) 
		{

			final ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
//		 	postParameters.add(new BasicNameValuePair("firstName", firstName.getText().toString().trim()));
		 	postParameters.add(new BasicNameValuePair("firstName", firstName.getText().subSequence(11, firstName.length()).toString().trim()));
			//postParameters.add(new BasicNameValuePair("middleName", middleName.getText().toString().trim()));
			postParameters.add(new BasicNameValuePair("lastName", lastName.getText().toString().trim()));
			
			//String url = "http://mejikage.no-ip.biz/server/HIS/insert.php  ";
			final String url = "http://www.njcuacm.org/restricted/stem_test/app/test_put.php";
			
			
			
			
			
			Toast.makeText(getBaseContext(), "The message is sending!", Toast.LENGTH_LONG).show();
			//yuchen added the following code, you can ignore CustomHttpClient.java
				new Thread() {
					@Override
					public void run() {
					// TODO Auto-generated method stub
						try {
						HttpClient httpclient = new DefaultHttpClient();
					     HttpPost httppost = new HttpPost(url);
					     httppost.setEntity(new UrlEncodedFormEntity(postParameters));
					     HttpResponse response = httpclient.execute(httppost);
					     Toast.makeText(getApplicationContext(), "Message has been sent!", Toast.LENGTH_SHORT).show();
						} 
						catch (Exception e) 
						{
							// TODO Auto-generated catch block
							Toast.makeText(getBaseContext(), e.getMessage()+"...it didnt send (-_-)", Toast.LENGTH_SHORT).show();
							e.printStackTrace();
						}
					super.run();
					}
					}.start();
				// end
				 
			     //HttpEntity entity = response.getEntity();
			     //InputStream is = entity.getContent();
				
				
				
				
				//System.out.println("try");
				//String response = CustomHttpClient.executeHttpPost(url, postParameters);
				//String res = response.toString();
				//System.out.println(res);
				//Toast.makeText(getBaseContext(), res, Toast.LENGTH_SHORT).show();
				//StringTokenizer t = new StringTokenizer(res, "*");
			
			
		}
		//}//end jeff code
	
	public void editDetails(View v) {
		fromReview = new Intent(ReviewActivity.this, NextActivity.class);
		Button edit = (Button) findViewById(R.id.button1);
		edit.setBackgroundColor(Color.GRAY);		
		fromReview.putExtra("review", 1);
		fromReview.putExtras(getIntent());
		startActivity(fromReview);
	}
	
	public void editEmployment(View v) {
		fromReview = new Intent(this, NextActivity2.class);
		Button edit = (Button) findViewById(R.id.Button01);
		edit.setBackgroundColor(Color.GRAY);
		fromReview.putExtra("review", 1);
		fromReview.putExtras(getIntent());
		startActivity(fromReview);
	}
	
	public void editEmergenC(View v) {
		fromReview = new Intent(this, NextActivity2.class);
		Button edit = (Button) findViewById(R.id.Button02);
		edit.setBackgroundColor(Color.GRAY);
		fromReview.putExtra("review", 1);
		fromReview.putExtras(getIntent());
		startActivity(fromReview);
	}
	
	public void editInsurrance(View v) {
		fromReview = new Intent(this, NextActivity3.class);
		Button edit = (Button) findViewById(R.id.Button03);
		edit.setBackgroundColor(Color.GRAY);
		fromReview.putExtra("review", 1);
		fromReview.putExtras(getIntent());
		startActivity(fromReview);
	}
	
	public void editMedical(View v) {
		fromReview = new Intent(this, NextActivity4.class);
		Button edit = (Button) findViewById(R.id.Button04);
		edit.setBackgroundColor(Color.GRAY);
		fromReview.putExtra("review", 1);
		fromReview.putExtras(getIntent());
		startActivity(fromReview);
	}
	
	public void editAllergy(View v) {
		fromReview = new Intent(this, NextActivity6.class);
		Button edit = (Button) findViewById(R.id.Button05);
		edit.setBackgroundColor(Color.GRAY);
		fromReview.putExtra("review", 1);
		fromReview.putExtras(getIntent());
		startActivity(fromReview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.review, menu);
		return true;
	}

}
