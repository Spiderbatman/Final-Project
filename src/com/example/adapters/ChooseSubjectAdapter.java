package com.example.adapters;

import java.util.ArrayList;

import com.example.final_project.R;
import com.example.model.SelectSubject;
import com.example.model.Subject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ChooseSubjectAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private ArrayList<SelectSubject> subjects;
	
	public ChooseSubjectAdapter(LayoutInflater inflater, ArrayList<SelectSubject> subjects) {
		this.subjects = subjects;
		this.inflater = inflater;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return subjects.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return subjects.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ChooseSubjectHolder holder;
		if (convertView == null) {
			holder = new ChooseSubjectHolder();
			convertView = inflater.inflate(R.layout.choosesubjects_list, null, false);
			holder.name = (TextView) (convertView.findViewById(R.id.chooseName));
			holder.select = (CheckBox) convertView.findViewById(R.id.select);
			convertView.setTag(holder);
		} else {
			holder = (ChooseSubjectHolder) convertView.getTag();
		}
		
		SelectSubject s = subjects.get(position);
		
		holder.name.setText(s.getSubjName());
		holder.select.setChecked(s.isSelected());
		
		return convertView;
	}
	
	private static class ChooseSubjectHolder {
		TextView name;
		CheckBox select;
	}

}
