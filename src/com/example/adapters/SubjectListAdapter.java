package com.example.adapters;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.model.Subject;

public class SubjectListAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private ArrayList<Subject> subjects;
	
	public SubjectListAdapter(LayoutInflater inflater, ArrayList<Subject> subjects) {
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
		SubjectHolder holder;
		if (convertView == null) {
			holder = new SubjectHolder();
			convertView = inflater.inflate(R.layout.subjects_list, null, false);
			holder.name = (TextView) (convertView.findViewById(R.id.subjectName));
			holder.credit = (TextView) (convertView.findViewById(R.id.credit));
			holder.mark = (TextView) (convertView.findViewById(R.id.mark));

			convertView.setTag(holder);
		} else {
			holder = (SubjectHolder) convertView.getTag();
		}
		
		Subject s = subjects.get(position);
		
		holder.name.setText(s.getName());
		holder.credit.setText("" + s.getCredits());
		holder.mark.setText("" + s.getPercent());
		
		return convertView;
	}
	
	private static class SubjectHolder {
		TextView name;
		TextView credit;
		TextView mark;
	}


}
