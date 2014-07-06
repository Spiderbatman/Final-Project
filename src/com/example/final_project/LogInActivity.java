package com.example.final_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		TextView t = (TextView) findViewById(R.id.endOfMail);
		t.setText("@freeuni.edu.ge");
	}
	
	public void signInClick(View v) {
		String name = ((EditText)findViewById(R.id.userName)).getText().toString() + "@freeuni.edu.ge";
		String password = ((EditText)findViewById(R.id.userPassword)).getText().toString();
		if(name.equals("") || password.equals("")) return;
		System.out.println(name +  "  " + password);

		Intent i = new Intent(getBaseContext(), StudentsPageActivity.class);
		i.putExtra("mail", name);
		startActivity(i);
	}
	
}
