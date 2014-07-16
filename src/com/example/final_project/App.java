package com.example.final_project;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import android.R.integer;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.model.Subject;
import com.example.web.DefaultWebWorker;
import com.example.web.FreeuniWebWorker;

public class App extends Application {
	private DefaultWebWorker df;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<Subject> selectSubject = new ArrayList<Subject>();
	private String userID;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	
	public void addSubject(Subject s) {
		subjects.add(s);
	}

	public ArrayList<Subject> getSelectSubject() {
		return selectSubject;
	}

	public Subject getSelectSubject(String selectSubject) {
		int id = 0;
		String name = "";
		int credit = 0;

		StringTokenizer tok = new StringTokenizer(selectSubject);
		id = Integer.parseInt(tok.nextToken());
		name = tok.nextToken();
		credit = Integer.parseInt(tok.nextToken());
		Subject sub = new Subject(name, credit, 0, false, id);
		return sub;
	}

	public Subject getSubjects(String subject) {
		boolean finished = false;
		int id = 0;
		String name = "";
		int credit = 0;
		double percent = 0;
		int isFinished = 0;
		String examName = "";
		int examResult = 0;

		StringTokenizer tok = new StringTokenizer(subject);
		id = Integer.parseInt(tok.nextToken());
		name = tok.nextToken();
		credit = Integer.parseInt(tok.nextToken());
		percent = Double.parseDouble(tok.nextToken());
		isFinished = Integer.parseInt(tok.nextToken());
		if (isFinished == 1) {
			finished = true;
		}

		Subject sub = new Subject(name, credit, percent, finished, id);

		while (tok.hasMoreTokens()) {
			examName = tok.nextToken();
			examResult = Integer.parseInt(tok.nextToken());
			sub.addExam(examName, examResult);
		}
		return sub;
	}

	public void incomeTextParser(String text) {
		StringTokenizer tok = new StringTokenizer(text.substring(
				text.indexOf("#") + 1, text.indexOf("|")), ",");
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(0) != '-') {
				if (text.charAt(i) == '#') {
					userID = text.substring(0, i);
					break;

				}
			} else {
				Toast.makeText(getApplicationContext(),
						"incorect password or email", Toast.LENGTH_LONG).show();
				break;

			}
		}
		while (tok.hasMoreTokens()) {
			subjects.add(getSubjects(tok.nextToken()));
		}

		if (text.substring(text.indexOf("|") + 1, text.length()).length() <= 1) {
			return;
		}

		StringTokenizer token = new StringTokenizer(text.substring(
				text.indexOf("|") + 1, text.length()), ",");

		while (token.hasMoreTokens()) {
			selectSubject.add(getSelectSubject(token.nextToken()));
		}
	}

	public String getUserId() {
		return userID;
	}
}
