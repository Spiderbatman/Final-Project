package com.example.final_project;

import java.util.ArrayList;

import com.example.adapters.ChooseSubjectAdapter;
import com.example.model.SelectSubject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
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
	}
	
	public void submitClick(View v) {
		ArrayList<SelectSubject> s = adapter.getSelectSubject();
		ArrayList<SelectSubject> resultLis = new ArrayList<SelectSubject>();
		for (int i = 0; i < s.size(); i++) {
			if(s.get(i).isSelected()) {
				resultLis.add(s.get(i));
			}
		}
			
	}
}
