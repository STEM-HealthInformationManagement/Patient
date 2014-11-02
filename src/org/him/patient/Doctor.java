package org.him.patient;

import com.example.patient.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Doctor extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctor_screen);
		final ProgressBar sp = (ProgressBar) findViewById(R.id.doctorLoginProgress);
		final EditText idField = (EditText) findViewById(R.id.idTextField);
		final EditText pwField = (EditText) findViewById(R.id.passwordTextField);
		final Button loginButton = (Button) findViewById(R.id.loginButton);
		final ToggleButton rememberToggle = (ToggleButton) findViewById(R.id.rememberToggle);
		final TextView afterLogin = (TextView) findViewById(R.id.afterDoctorLogin);
		sp.setVisibility(View.INVISIBLE);
		afterLogin.setVisibility(View.INVISIBLE);
	}
}