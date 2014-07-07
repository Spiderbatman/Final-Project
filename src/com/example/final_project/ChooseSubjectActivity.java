package com.example.final_project;

import java.util.ArrayList;

import com.example.adapters.ChooseSubjectAdapter;
import com.example.model.SelectSubject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ChooseSubjectActivity extends Activity{
	
	private ArrayList<SelectSubject> selectSubject = new ArrayList<SelectSubject>();
	private ListView listView;
	private ChooseSubjectAdapter adapter;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choosesubject);
		
		App ap = (App) getApplication();
		selectSubject = ap.getSelectSubject();
		listView = (ListView) findViewById(R.id.chooseSubjects_list);
		adapter = new ChooseSubjectAdapter(getLayoutInflater(), selectSubject);
		listView.setAdapter(adapter);
		System.out.println("sdsdsds");
		System.out.println("sssssssssssssssssss");
	}
}
