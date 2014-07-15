package com.example.final_project;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import android.R.integer;
import android.app.Application;

import com.example.model.Subject;
import com.example.web.DefaultWebWorker;
import com.example.web.FreeuniWebWorker;

public class App extends Application {
	private DefaultWebWorker df;
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<Subject> selectSubject = new ArrayList<Subject>();
	private Map<Subject, Map<String, String>> subjectInfo = new HashMap<Subject, Map<String, String>>();

	private Map<String, String> mail = new HashMap<String, String>();

	@Override
	public void onCreate() {
		super.onCreate();
		// subjects = df.getSubjects();//TODO es asynchtaskshi tu rac iqneba
		generate(); // // / droebiiiiiit
		/*
		 * FreeuniWebWorker webDatas = new FreeuniWebWorker(
		 * "http://192.168.77.34:8080/Android_Server/Main"); try {
		 * webDatas.GetText(); } catch (UnsupportedEncodingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
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

	public Map<String, String> getMailInfo() {
		return mail;
	}

	private void generate() {
		
		incomeTextParser(kai);

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

		mail.put("aa", "aa");
		

	}

	// userid # sagani krediti procenti gavliliaristuara subID
	private String opa = "-1";
	private String kai = "75#23 matematika 3 65 1 qvizi1 44 qvizi2 23,12 shroma 3 65 1 qvizi1 44 qvizi2 23 saboloo_gamocda 34,18 chama 4 33 0 qvizi1 44 qvizi2 23 saboloo_gamocda 77|5 matematika2 4,7 matematika2 2";

	private String userID;
	private String s = "5 matematika2 4,7 matematika2 2";

	// public Subject getSelectSubjects(String selectedSubjects){
	//
	// }
	
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
		text = kai;

		StringTokenizer tok = new StringTokenizer(text.substring(
				text.indexOf("#") + 1, text.indexOf("|")), ",");

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(0) != '-') {
				if (text.charAt(i) == '#') {
					userID = text.substring(0, i);
					System.out.println(userID);
					break;

				}
			}
		}
		while (tok.hasMoreTokens()) {
			subjects.add(getSubjects(tok.nextToken()));
		}
		
	}
}
