package com.example.final_project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	
	public void logInClick(View v) {
		Intent i = new Intent(getBaseContext(), LogInActivity.class);
		i.putExtra("name", "tsu");
		startActivity(i);
	}
}
