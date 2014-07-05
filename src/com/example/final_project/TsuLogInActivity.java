package com.example.final_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TsuLogInActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tsulogin);
		
	}
	
	public void signInClick(View v) {
		String name = ((EditText)findViewById(R.id.userName)).getText().toString();
		String surname = ((EditText)findViewById(R.id.userSurName)).getText().toString();
		String password = ((EditText)findViewById(R.id.userPassword)).getText().toString();
		if(name.equals("") || surname.equals("") || password.equals("")) return;
		System.out.println(name + "   " + surname + "  " + password);

	}
}
