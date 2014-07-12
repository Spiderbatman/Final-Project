package com.example.final_project;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity{
	private TextView k;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		TextView t = (TextView) findViewById(R.id.endOfMail);
		k = (TextView) findViewById(R.id.incorrect);
		k.setVisibility(View.GONE);
		t.setText("@freeuni.edu.ge");
	}
	
	public void signInClick(View v) {
		EditText t1 = (EditText)findViewById(R.id.userName);
		EditText t2 = (EditText)findViewById(R.id.userPassword);
		String name = t1.getText().toString();
		String password = t2.getText().toString();
		if(name.equals("") || password.equals("")) return;

		App ap = (App) getApplication();
		Map<String, String> m = ap.getMailInfo();
		System.out.println(name + "k   k" + m.get(name));
		if(!m.containsKey(name) || !password.equals(m.get(name))) {
			t1.setText("");
			t2.setText("");
			k.setVisibility(View.VISIBLE);
			return;
		} else k.setVisibility(View.GONE);
		t1.setText("");
		t2.setText("");
		Intent i = new Intent(getBaseContext(), StudentsPageActivity.class);
		i.putExtra("mail", name);
		startActivity(i);
	}
	
}
