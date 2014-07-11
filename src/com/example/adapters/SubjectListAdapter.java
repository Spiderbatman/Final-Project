package com.example.adapters;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.model.Subject;

public class SubjectListAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private ArrayList<Subject> subjects;
	private ArrayList<Subject> filter;
	private ItemFilter item = new ItemFilter();

	public SubjectListAdapter(LayoutInflater inflater,
			ArrayList<Subject> subjects) {
		this.subjects = subjects;
		this.inflater = inflater;
		this.filter = subjects;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return filter.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return filter.get(arg0);
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
			holder.name = (TextView) (convertView
					.findViewById(R.id.subjectName));
			holder.credit = (TextView) (convertView.findViewById(R.id.credit));
			holder.mark = (TextView) (convertView.findViewById(R.id.mark));
			holder.isFinished = (ImageView) convertView
					.findViewById(R.id.isFinished);

			convertView.setTag(holder);
		} else {
			holder = (SubjectHolder) convertView.getTag();
		}
		Subject s = filter.get(position);

		holder.name.setText(s.getName());
		holder.credit.setText("" + s.getCredits());
		holder.mark.setText("" + s.getPercent());
		if (s.isFinished())
			holder.isFinished.setImageResource(R.drawable.accept);
		else
			holder.isFinished.setImageResource(R.drawable.cancel);

		return convertView;
	}

	private static class SubjectHolder {
		TextView name;
		TextView credit;
		TextView mark;
		ImageView isFinished;
	}

	public Filter getFilter() {
		return item;
	}

	
	
	private class ItemFilter extends Filter {
		ArrayList<Subject> nlist = new ArrayList<Subject>();
		
		private void fillList(double start, double end, int count, ArrayList<Subject> list) {
			for (int i = 0; i < count; i++) {
				if (list.get(i).getPercent() > start && list.get(i).getPercent() < end) {
					if(!nlist.contains(list.get(i)))
						nlist.add(list.get(i));
				} else if(nlist.contains(list.get(i))) nlist.remove(list.get(i));
			}
		}
		
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			String filterString = constraint.toString().toLowerCase();
			FilterResults results = new FilterResults();

			final ArrayList<Subject> list = subjects;

			int count = list.size();
			
			String t = "";
			
			if (!filterString.equals(""))
				t = filterString.substring(1);
			System.out.println("sityva:" + t + "..");
			double start = -1;
			double end = 101;
			if(filterString.equals("") || t.equals("mark")) {
				System.out.println("shemovidaaa");
				for (int i = 0; i < count; i++) {
					if(!nlist.contains(list.get(i)))
						nlist.add(list.get(i));
				}
				
			}
			else if (filterString.charAt(0) != '&') {
				String filterableString;
				for (int i = 0; i < count; i++) {
					filterableString = list.get(i).getName();
					if (filterableString.toLowerCase().contains(filterString)) {
						if(!nlist.contains(list.get(i)))
							nlist.add(list.get(i));
					} else if(nlist.contains(list.get(i))) nlist.remove(list.get(i));
				}
			}
			
			else if (t.charAt(0) == '0') {
				fillList(0.0, 51, count, list);
			} else if (t.charAt(0) == '5') {
				fillList(50, 61, count, list);
			} else if (t.charAt(0) == '6') {
				fillList(60, 71, count, list);
			} else if (t.charAt(0) == '7') {
				fillList(70, 81, count, list);
			} else if (t.charAt(0) == '8') {
				fillList(80, 91, count, list);
			} else if (t.charAt(0) == '9') {
				fillList(90, 101, count, list);
			}
			

			results.values = nlist;
			results.count = nlist.size();

			return results;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			filter = (ArrayList<Subject>) results.values;
			notifyDataSetChanged();
		}

	}

}
