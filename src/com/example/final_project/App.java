package com.example.final_project;

import java.util.ArrayList;

import com.example.model.SelectSubject;
import com.example.model.Subject;
import com.example.web.DefaultWebWorker;
import com.example.web.TSUWebWorker;

import android.app.Application;

public class App extends Application{
	private DefaultWebWorker df;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<SelectSubject> selectSubject = new ArrayList<SelectSubject>();
	
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
	
	public ArrayList<SelectSubject> getSelectSubject() {
		return selectSubject;
	}
	
	private void generate() {
		Subject a = new Subject("კალკულუსი", 6, 92);
		Subject b = new Subject("პროგრამირება", 7, 81);
		Subject c = new Subject("ალბათობა", 5, 71);
		Subject d = new Subject("ანდროიდი", 4, 61);
		Subject e = new Subject("androidi", 4, 70);
		Subject f = new Subject("antropologia", 4, 33);
		subjects.add(a);
		subjects.add(b);
		subjects.add(c);
		subjects.add(d);
		subjects.add(e);
		subjects.add(f);
		
		SelectSubject g = new SelectSubject("სამართალი", false);
		SelectSubject h = new SelectSubject("ბიზნესი", false);
		SelectSubject i = new SelectSubject("სოციოლოგია", false);
		SelectSubject j = new SelectSubject("ფსიქოლოგია", false);
		SelectSubject k = new SelectSubject("ფინანსები", false);
		SelectSubject l = new SelectSubject("მარკეტინგი", false);
		
		selectSubject.add(g);
		selectSubject.add(h);
		selectSubject.add(i);
		selectSubject.add(j);
		selectSubject.add(k);
		selectSubject.add(l);

		
	}
}
