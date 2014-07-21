package com.example.adapters;

import java.util.ArrayList;
import java.util.Map;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.final_project.R;

public class OneSubjectAdapter extends BaseAdapter{

	private LayoutInflater inflater;
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Integer> marks = new ArrayList<Integer>();

	public OneSubjectAdapter(LayoutInflater inflater, Map<String, Integer> m) {
		for(String key : m.keySet()) {
			names.add(key);
			marks.add(m.get(key));
		}
		this.inflater = inflater;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return names.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ChooseSubjectHolder holder;
		if (convertView == null) {
			holder = new ChooseSubjectHolder();
			convertView = inflater.inflate(R.layout.onesubjects_list, null, false);
			holder.name = (TextView) (convertView.findViewById(R.id.midtermText));
			holder.mark = (TextView) convertView.findViewById(R.id.midtermMark);
			convertView.setTag(holder);
		} else {
			holder = (ChooseSubjectHolder) convertView.getTag();
		}
		
		holder.name.setText(names.get(position));
		holder.mark.setText(marks.get(position).toString());
		if(names.get(position).equals("ფინალური"))	{
			holder.name.setTextColor(Color.RED);
			holder.mark.setTextColor(Color.RED);
		}
		
		return convertView;
	}
	
	private static class ChooseSubjectHolder {
		TextView name;
		TextView mark;
	}

}
