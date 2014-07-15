package com.example.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;

import com.example.model.Subject;

public class FreeuniWebWorker extends DefaultWebWorker {

	private String text = "";

	public FreeuniWebWorker(String url) {
		super(url);
	}

	@Override
	public ArrayList<Subject> getSubjects() {
		// TODO aq freeunis gadmowera
		return null;
	}

	@SuppressLint("NewApi")
	public void GetText(String mail, String password)
			throws UnsupportedEncodingException {
		// Get user defined values

		// Create data variable for sent values to server
		String data = URLEncoder.encode("type", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8");

		data += "&" + URLEncoder.encode("email", "UTF-8") + "="
				+ URLEncoder.encode(mail, "UTF-8");

		data += "&" + URLEncoder.encode("pass", "UTF-8") + "="
				+ URLEncoder.encode(password, "UTF-8");

		String text = "";
		BufferedReader reader = null;

		// Send data
		try {

			// Defined URL where to send data
			URL url = new URL(super.url);

			// Send POST data request

			URLConnection conn = url.openConnection();
			// ////////////
			if (Build.VERSION.SDK_INT >= 10) {
				ThreadPolicy tp = ThreadPolicy.LAX;
				StrictMode.setThreadPolicy(tp);
			}
			// ///////////////////

			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(data);
			System.out.println(data);
			wr.flush();

			// Get the server response

			reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;

			// Read Server Response
			while ((line = reader.readLine()) != null) {
				// Append server response in string
				sb.append(line + "\n");
			}

			text = sb.toString();
			System.out.println(text);
		} catch (Exception ex) {

		} finally {
			try {

				reader.close();
			}

			catch (Exception ex) {
			}
		}

		// Show response on activity

	}

	@SuppressLint("NewApi")
	public void GetSubjects(ArrayList<Integer> subjects)
			throws UnsupportedEncodingException {
		// Get user defined values

		// Create data variable for sent values to server
		String data = URLEncoder.encode("type", "UTF-8") + "="
				+ URLEncoder.encode("2", "UTF-8");

		for (int i = 0; i < subjects.size(); i++) {

			data += "&" + URLEncoder.encode("ind" + i, "UTF-8") + "="
					+ URLEncoder.encode(subjects.get(i).toString(), "UTF-8");
		}

		String text = "";
		BufferedReader reader = null;

		// Send data
		try {

			// Defined URL where to send data
			URL url = new URL(super.url);

			// Send POST data request

			URLConnection conn = url.openConnection();
			// ////////////
			if (Build.VERSION.SDK_INT >= 10) {
				ThreadPolicy tp = ThreadPolicy.LAX;
				StrictMode.setThreadPolicy(tp);
			}
			// ///////////////////

			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(data);
			System.out.println(data);
			wr.flush();

			// Get the server response

			reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;

			// Read Server Response
			while ((line = reader.readLine()) != null) {
				// Append server response in string
				sb.append(line + "\n");
			}

			text = sb.toString();
			System.out.println(text);
		} catch (Exception ex) {

		} finally {
			try {

				reader.close();
			}

			catch (Exception ex) {
			}
		}

		// Show response on activity

	}

	public String getCheckResult() {
		return text;
	}

}
