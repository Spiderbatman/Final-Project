package com.example.final_project;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.adapters.ChooseSubjectAdapter;
import com.example.model.Subject;

public class ChooseSubjectActivity extends Activity{
	
	private ArrayList<Subject> selectSubject = new ArrayList<Subject>();
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
	}
	
	public void submitClick(View v) {
		ArrayList<Boolean> s = adapter.getSelectSubject();
		ArrayList<Integer> resultLis = new ArrayList<Integer>();
		for (int i = 0; i < s.size(); i++) {
			if(s.get(i)) {
				resultLis.add(selectSubject.get(i).getId());
			}
		}
	}
}
