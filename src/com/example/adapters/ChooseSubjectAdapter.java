package com.example.adapters;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.model.SelectSubject;

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

	public ArrayList<SelectSubject> getSelectSubject() {
		return subjects;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
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
		subjects.get(position).setSelected(s.isSelected());
		
		holder.name.setText(s.getSubjName());
		holder.select.setChecked(s.isSelected());
		
		holder.select.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				subjects.get(position).setSelected(isChecked);

				
			}
		});
		
		return convertView;
	}
	
	private static class ChooseSubjectHolder {
		TextView name;
		CheckBox select;
	}

}
