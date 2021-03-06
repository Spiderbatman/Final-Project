package com.example.final_project;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.adapters.SubjectListAdapter;
import com.example.model.Subject;

public class StudentsPageActivity extends Activity {
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<Subject> filterSubjects = new ArrayList<Subject>();
	private ListView listView;
	private SubjectListAdapter adapter;
	private EditText text;
	private TabHost tabhost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profilepage);
		addTabs(savedInstanceState);
		Intent i = getIntent();
		Bundle extra = i.getExtras();
		TextView t = (TextView) findViewById(R.id.userInfo);
		if (extra != null) {
			String mail = extra.getString("mail");
			t.setText(mail);
		}
		text = (EditText) findViewById(R.id.filterText);
		App ap = (App) getApplication();
		subjects = ap.getSubjects();
		filterSubjects = ap.getSubjects();
		listView = (ListView) findViewById(R.id.subjects_list);
		adapter = new SubjectListAdapter(getLayoutInflater(), filterSubjects);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Intent i = new Intent(getBaseContext(),
						OneSubjectActivity.class);
				Subject s = (Subject) adapter.getItem(arg2);
				i.putExtra("SubjectName", s.getName());
				i.putExtra("SubjectMark", "" + s.getPercent());
				startActivity(i);
			}
		});

		calculate();
		searchListener();
		fillSpinner();
	}

	private void fillSpinner() {
		Spinner spinner = (Spinner) findViewById(R.id.mark_spinner);
		ArrayAdapter<CharSequence> adap = ArrayAdapter.createFromResource(this,
				R.array.mark_array, android.R.layout.simple_spinner_item);
		adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adap);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

				String t = (String) arg0.getItemAtPosition(arg2);
				adapter.getFilter().filter("&" + t);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

	private double gpaCredit(double m) {
		if (m > 90)
			return 4.0;
		if (m > 80)
			return 3.38;
		if (m > 70)
			return 2.77;
		if (m > 60)
			return 2.16;
		if (m > 50)
			return 1.55;

		return 0;
	}

	private void calculate() {
		int totalCredits = 0;
		double totalGpaMarks = 0.0;
		for (int i = 0; i < subjects.size(); i++) {
			if (subjects.get(i).isFinished()) {
				totalCredits = totalCredits + subjects.get(i).getCredits();
			}
			totalGpaMarks = totalGpaMarks
					+ (subjects.get(i).getCredits() * gpaCredit(subjects
							.get(i).getPercent()));
		}
		TextView t = (TextView) (findViewById(R.id.totalCredits));
		t.setText(t.getText().toString() + totalCredits);

		TextView t2 = (TextView) (findViewById(R.id.gpa));
		double gpa = (totalGpaMarks / totalCredits) * 100;
		double roundGpa = Math.round(gpa);
		t2.setText(t2.getText().toString() + roundGpa / 100);
	}

	private void addTabs(Bundle savedInstanceState) {
		tabhost = (TabHost) findViewById(R.id.tabhost);
		tabhost.setup();

		TabHost.TabSpec spec;

		spec = tabhost.newTabSpec("screen1");
		spec.setContent(R.id.tab1);
		spec.setIndicator("", getResources().getDrawable(R.drawable.profile));
		tabhost.addTab(spec);

		spec = tabhost.newTabSpec("screen2");
		spec.setContent(R.id.tab2);
		spec.setIndicator("", getResources().getDrawable(R.drawable.subject));
		tabhost.addTab(spec);

		if (savedInstanceState != null) {
			int value = savedInstanceState.getInt("myKey");
			tabhost.setCurrentTab(value);
		} else
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

	public void chooseSubject(View v) {
		Intent i = new Intent(getBaseContext(), ChooseSubjectActivity.class);
		i.putExtra("ragac", "sds");
		startActivity(i);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		adapter = new SubjectListAdapter(getLayoutInflater(), filterSubjects);
		listView.setAdapter(adapter);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		int currentTab = tabhost.getCurrentTab();
		outState.putInt("myKey", currentTab);
	}

}
