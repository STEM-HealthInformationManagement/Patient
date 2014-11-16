package org.him.patient;

import java.util.Calendar;
import java.util.StringTokenizer;

import com.example.patient.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

public class UpdateInfo extends Activity {

	private DatePickerDialog datePicking2 = null;
	private EditText date; 
	private String initialDate;
	private String initialMonth;
	private String initialYear;
	private String title;
	private EditText firstName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_info);
		findViewById(R.id.RelativeLayout1).requestFocus();
		firstName = (EditText) findViewById(R.id.idTextField);
		
		date = (EditText) findViewById(R.id.reg_phoneNumber);
		title = "Choose your date of birth";
		
		
		//button to pop up the datepicker 
        ImageButton dateButton = (ImageButton) findViewById(R.id.imageButton_dateVerify);
        
        dateButton.setOnClickListener(new View.OnClickListener() {
        	@SuppressWarnings("deprecation")
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
	
}
