package com.example.final_project;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.OneSubjectAdapter;
import com.example.model.Subject;

public class OneSubjectActivity extends Activity{
	
	private ListView listView;
	private OneSubjectAdapter adapter;
	private App ap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_onesubject);
		Intent i = getIntent();
		Bundle extra = i.getExtras();
		TextView t = (TextView) findViewById(R.id.oneSubjName);
		TextView sc = (TextView) findViewById(R.id.totalMark);

		String name = "";
		String score = "";
		if (extra != null) {
			name = extra.getString("SubjectName");
			score = extra.getString("SubjectMark");
			t.setText(name);
			sc.setText(score);
		}
		
		ap = (App) getApplication();
		listView = (ListView) findViewById(R.id.oneSubjects_list);
		adapter = new OneSubjectAdapter(getLayoutInflater(), getKeySubjet(name).getMap());
		listView.setAdapter(adapter);
	}
	
	private Subject getKeySubjet(String name) {
		ArrayList<Subject> s = ap.getSubjects();
		for (int i = 0; i < s.size(); i++) {
			if(s.get(i).getName().equals(name)) return s.get(i);
		}
		return null;
	}
}
