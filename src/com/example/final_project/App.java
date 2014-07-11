package com.example.final_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Application;

import com.example.model.Subject;
import com.example.web.DefaultWebWorker;
import com.example.web.TSUWebWorker;

public class App extends Application{
	private DefaultWebWorker df;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<Subject> selectSubject = new ArrayList<Subject>();
	private Map<Subject, Map<String, String>> subjectInfo= new HashMap<Subject, Map<String, String>>();
	
	@Override
	public void onCreate() {
		super.onCreate();
		df = new TSUWebWorker("sms.tsu.ge");
		//subjects = df.getSubjects();//TODO es asynchtaskshi tu rac iqneba
		generate();		/// droebiiiiiit
	}
	
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	public ArrayList<Subject> getSelectSubject() {
		return selectSubject;
	}
	
	public Map<Subject, Map<String, String>> getSubjectInfo() {
		return subjectInfo;
	}
	
	private void generate() {
		Subject a = new Subject("კალკულუსი", 6, 92, true, 1);
		Subject b = new Subject("პროგრამირება", 7, 81, true, 1);
		Subject c = new Subject("ალბათობა", 5, 71, false, 1);
		Subject d = new Subject("ანდროიდი", 4, 61, true, 1);
		Subject e = new Subject("androidi", 4, 70, true, 1);
		Subject f = new Subject("antropologia", 4, 33, false, 1);
		subjects.add(a);
		subjects.add(b);
		subjects.add(c);
		subjects.add(d);
		subjects.add(e);
		subjects.add(f);
		
		Subject g = new Subject("სამართალი", 6, 0, false, 1);
		Subject h = new Subject("ბიზნესი", 6, 0, false, 2);
		Subject i = new Subject("სოციოლოგია", 6, 0, false, 3);
		Subject j = new Subject("ფსიქოლოგია", 6, 0, false, 4);
		Subject k = new Subject("ფინანსები", 6, 0, false, 5);
		Subject l = new Subject("მარკეტინგი", 6, 0, false, 6);
		
		selectSubject.add(g);
		selectSubject.add(h);
		selectSubject.add(i);
		selectSubject.add(j);
		selectSubject.add(k);
		selectSubject.add(l);
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 7));
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 8));
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 9));
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 10));
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 11));
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 12));
		selectSubject.add(new Subject("მარკეტინგი", 6, 0, false, 13));

		Map<String, String> m = new HashMap<String, String>();
		m.put("პირველი შუალედური", "" + 85);
		m.put("მეორე შუალედური", "" + 95);
		m.put("ფინალური", "" + 100);

		for (int z = 0; z < subjects.size(); z++) {
			subjectInfo.put(subjects.get(z), m);
		}
		
	}
}
