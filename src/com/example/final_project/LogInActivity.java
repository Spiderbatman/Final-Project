package com.example.final_project;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.web.FreeuniWebWorker;

public class LogInActivity extends Activity {
	private TextView k;
	private FreeuniWebWorker sendRequest = new FreeuniWebWorker(
			"http://192.168.76.194:8080/Android_Server/Main");
	private App app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		app = (App) getApplication();
		setContentView(R.layout.activity_login);
		TextView t = (TextView) findViewById(R.id.endOfMail);
		k = (TextView) findViewById(R.id.incorrect);
		k.setVisibility(View.GONE);
		t.setText("@freeuni.edu.ge");
	}

	public void signInClick(View v) {
		EditText t1 = (EditText) findViewById(R.id.userName);
		EditText t2 = (EditText) findViewById(R.id.userPassword);
		String name = t1.getText().toString();
		String password = t2.getText().toString();
		if (name.equals("") || password.equals(""))
			return;
		
		try {
			sendRequest.GetText(name, computeMD5Hash(password));
			app.incomeTextParser(sendRequest.getCheckResult());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		if (sendRequest.getCheckResult().charAt(0) == '-') {
			t1.setText("");
			t2.setText("");
			k.setVisibility(View.VISIBLE);
			t2.setBackgroundResource(R.drawable.erroredittext);
			return;
		} else
			k.setVisibility(View.GONE);
		t2.setBackgroundResource(R.drawable.roundedittext);

		Intent i = new Intent(getBaseContext(), StudentsPageActivity.class);
		i.putExtra("mail", name);
		startActivity(i);
		t1.setText("");
		t2.setText("");
	}

	public String computeMD5Hash(String password)
    {
 
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();
      
            StringBuffer MD5Hash = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
            {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                MD5Hash.append(h);
            }
           return "" + MD5Hash;
         } 
            catch (NoSuchAlgorithmException e) 
            {
            e.printStackTrace();
            }
         return null;
    }

}
