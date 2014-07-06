package com.example.final_project;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.adapters.SubjectListAdapter;
import com.example.model.Subject;

public class StudentsPageActivity extends Activity{
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ListView listView;
	private SubjectListAdapter adapter;
	private EditText text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profilepage);
		addTabs();
		text = (EditText) findViewById(R.id.filterText);
		App ap = (App) getApplication();
		subjects = ap.getSubjects();
		listView = (ListView) findViewById(R.id.subjects_list);
		adapter = new SubjectListAdapter(getLayoutInflater(), ap.getSubjects());
		listView.setAdapter(adapter);
		calculate();
		searchListener();
		fillSpinner();
	}
	
	private void fillSpinner() {
		Spinner spinner = (Spinner) findViewById(R.id.mark_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.mark_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	
	private double gpaCredit(double m) {
		if(m > 90) return 4.0;
		if(m > 80) return 3.38;
		if(m > 70) return 2.77;
		if(m > 60) return 2.16;
		if(m > 50) return 1.55;
		
		return 0;
	}
	
	private void calculate() {
		int totalCredits = 0;
		double totalGpaMarks = 0.0;
		for (int i = 0; i < subjects.size(); i++) {
			totalCredits = totalCredits + subjects.get(i).getCredits();
			totalGpaMarks = totalGpaMarks + (subjects.get(i).getCredits() * gpaCredit(subjects.get(i).getPercent()));
		}
		TextView t = (TextView)(findViewById(R.id.totalCredits));
		t.setText(t.getText().toString() + totalCredits);
		
		TextView t2 = (TextView)(findViewById(R.id.gpa));
		double gpa = (totalGpaMarks/totalCredits) * 100;
		double roundGpa = Math.round(gpa);
		t2.setText(t2.getText().toString() + roundGpa/100);
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
	
	private void searchListener() {
		text.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				adapter.getFilter().filter(text.getText().toString());
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			@Override
			public void afterTextChanged(Editable arg0) {

			}
		});
	}
}
