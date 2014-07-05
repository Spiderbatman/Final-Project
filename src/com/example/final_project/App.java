package com.example.final_project;

import java.util.ArrayList;

import com.example.model.Subject;
import com.example.web.DefaultWebWorker;
import com.example.web.TSUWebWorker;

import android.app.Application;

public class App extends Application{
	private DefaultWebWorker df;
	private ArrayList<Subject> subjects;
	
	@Override
	public void onCreate() {
		super.onCreate();
		df = new TSUWebWorker("sms.tsu.ge");
		subjects = df.getSubjects();//TODO es asynchtaskshi tu rac iqneba
	}
}
