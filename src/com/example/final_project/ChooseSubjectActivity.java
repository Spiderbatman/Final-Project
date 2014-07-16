package com.example.final_project;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapters.ChooseSubjectAdapter;
import com.example.model.Subject;
import com.example.web.FreeuniWebWorker;

public class ChooseSubjectActivity extends Activity {

	private ArrayList<Subject> selectSubject = new ArrayList<Subject>();
	private ListView listView;
	private ChooseSubjectAdapter adapter;
	private TextView error;
	private App ap;
	private FreeuniWebWorker web = new FreeuniWebWorker(
			"http://192.168.77.114:8080/Android_Server/Main");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choosesubject);

		ap = (App) getApplication();
		selectSubject = ap.getSelectSubject();
		listView = (ListView) findViewById(R.id.chooseSubjects_list);
		boolean[] sel = new boolean[selectSubject.size()];
		if (savedInstanceState != null) {
			sel = savedInstanceState.getBooleanArray("selKey");
		}
		adapter = new ChooseSubjectAdapter(getLayoutInflater(), selectSubject,
				sel);
		listView.setAdapter(adapter);
		error = (TextView) findViewById(R.id.errorText);
		error.setVisibility(View.GONE);
	}

	public void submitClick(View v) throws UnsupportedEncodingException {
		ArrayList<Boolean> s = adapter.getSelectSubject();
		if (!adapter.check()) {
			error.setVisibility(View.VISIBLE);
			return;
		}
		error.setVisibility(View.GONE);
		ArrayList<Integer> resultLis = new ArrayList<Integer>();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i)) {
				resultLis.add(selectSubject.get(i).getId());
				ap.addSubject(selectSubject.get(i));
				selectSubject.remove(i);
			}
		}
		adapter.notifyDataSetChanged();
		web.GetSubjects(resultLis, ap.getUserId());
		finish();
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
