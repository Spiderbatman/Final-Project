package com.example.final_project;

import java.util.ArrayList;

import com.example.adapters.SubjectListAdapter;
import com.example.model.Subject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

public class StudentsPageActivity extends Activity{
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ListView listView;
	private SubjectListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profilepage);
		addTabs();
		App ap = (App) getApplication();
		subjects = ap.getSubjects();
		listView = (ListView) findViewById(R.id.subjects_list);
		adapter = new SubjectListAdapter(getLayoutInflater(), ap.getSubjects());
		listView.setAdapter(adapter);
	}
	
	private void addTabs() {
		TabHost tabhost = (TabHost) findViewById(R.id.tabhost);
		tabhost.setup();

		TabHost.TabSpec spec;

		spec = tabhost.newTabSpec("screen1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("Info", null);
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("screen2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("Subjects", null);
		tabhost.addTab(spec);

		tabhost.setCurrentTab(0);
	}
}
