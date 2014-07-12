package com.example.adapters;

import java.util.ArrayList;

import android.R.bool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.model.Subject;

public class ChooseSubjectAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private ArrayList<Subject> subjects;
	private ArrayList<Boolean> isSelected = new ArrayList<Boolean>();
	
	public ChooseSubjectAdapter(LayoutInflater inflater, ArrayList<Subject> subjects, boolean[] selected) {
		this.subjects = subjects;
		this.inflater = inflater;
		for (int i = 0; i < selected.length; i++) {
			isSelected.add(selected[i]);
		}
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

	public ArrayList<Boolean> getSelectSubject() {
		return isSelected;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ChooseSubjectHolder holder;
		if (convertView == null) {
			holder = new ChooseSubjectHolder();
			convertView = inflater.inflate(R.layout.choosesubjects_list, null, false);
			holder.name = (TextView) (convertView.findViewById(R.id.chooseName));
			holder.select = (CheckBox) convertView.findViewById(R.id.select);
			holder.credit = (TextView) convertView.findViewById(R.id.chooseCredit);
			convertView.setTag(holder);
		} else {
			holder = (ChooseSubjectHolder) convertView.getTag();
		}
		
		Subject s = subjects.get(position);
	
		holder.select.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				isSelected.set(position, isChecked);
			}
		});
		holder.name.setText(s.getName());
		holder.select.setChecked(isSelected.get(position));
		holder.credit.setText("" + s.getCredits());
		
		return convertView;
	}
	
	private static class ChooseSubjectHolder {
		TextView name;
		TextView credit;
		CheckBox select;
	}

}
