package com.example.final_project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void onTsuClick(View v) {
		System.out.println("shemovidaaa");
		Intent i = new Intent(getBaseContext(), TsuLogInActivity.class);
		i.putExtra("name", "tsu");
		startActivity(i);
	}
}
