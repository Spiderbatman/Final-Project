package com.example.final_project;

import java.util.ArrayList;

import com.example.model.Subject;
import com.example.web.DefaultWebWorker;
import com.example.web.TSUWebWorker;

import android.app.Application;

public class App extends Application{
	private DefaultWebWorker df;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	
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
	private void generate() {
		Subject a = new Subject("კალკულუსი", 6, 92);
		Subject b = new Subject("პროგრამირება", 7, 94);
		Subject c = new Subject("ალბათობა", 5, 84);
		Subject d = new Subject("ანდროიდი", 4, 82);

		subjects.add(a);
		subjects.add(b);
		subjects.add(c);
		subjects.add(d);
	}
}
