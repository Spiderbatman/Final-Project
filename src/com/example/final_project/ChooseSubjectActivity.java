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
		boolean[] sel = new boolean[selectSubject.size()];
		if(savedInstanceState != null) {
			sel = savedInstanceState.getBooleanArray("selKey");
		}
		adapter = new ChooseSubjectAdapter(getLayoutInflater(), selectSubject, sel);
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
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		ArrayList<Boolean> s = adapter.getSelectSubject();
		boolean[] l = new boolean[s.size()];
		for (int i = 0; i < s.size(); i++) {
			l[i] = s.get(i);
		}
		outState.putBooleanArray("selKey", l);
		
	}
}
