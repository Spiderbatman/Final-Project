package com.example.final_project;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.example.web.FreeuniWebWorker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity {
	private TextView k;
	private FreeuniWebWorker sendRequest = new FreeuniWebWorker(
			"http://192.168.77.151:8080/Android_Server/Main");

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
		EditText t1 = (EditText) findViewById(R.id.userName);
		EditText t2 = (EditText) findViewById(R.id.userPassword);
		String name = t1.getText().toString();
		String password = t2.getText().toString();
		if (name.equals("") || password.equals(""))
			return;
		try {
			sendRequest.GetText(name, password);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sendRequest.getCheckResult() == "-1") {
			t1.setText("");
			t2.setText("");
			k.setVisibility(View.VISIBLE);
			t2.setBackgroundResource(R.drawable.erroredittext);
			return;
		} else
			k.setVisibility(View.GONE);
		t2.setBackgroundResource(R.drawable.roundedittext);

		Intent i = new Intent(getBaseContext(), StudentsPageActivity.class);
		i.putExtra("mail", name);
		startActivity(i);
		t1.setText("");
		t2.setText("");
	}

}
