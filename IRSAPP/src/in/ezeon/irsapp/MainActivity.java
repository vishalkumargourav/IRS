package in.ezeon.irsapp;

import in.ezeon.functions.SuccessfulLogin;
import in.ezeon.utility.ConvertToStudent;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnSave;
	TextView tvSignUp;
	EditText etLoginName;
	EditText etPassword;
	ConnectionToUrl conu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnSave = (Button) findViewById(R.id.btnLogin);
		etLoginName = (EditText) findViewById(R.id.etLoginName);
		tvSignUp = (TextView) findViewById(R.id.tvSignUp);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etLoginName.setText("");
		etPassword.setText("");
		conu = new ConnectionToUrl();
		addListener();
	}

	void addListener() {
		btnSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String chkln = etLoginName.getText().toString();
				String pss = etPassword.getText().toString();
				if (chkln.equals("") || pss.equals(""))
					Toast.makeText(MainActivity.this,
							"Please enter both Login name and password",
							Toast.LENGTH_LONG).show();
				else {
					try {
						String ip = "10.0.2.2";
						String url = "http://" + ip
								+ ":8080/MyProject/androidStudentLogin.htm";
						AsyncTask at = new HttpPostFormData().execute(url);
						String res;
						ConvertToStudent cts = new ConvertToStudent();
						Student s = new Student();
						try {
							res = (String) at.get();
							JSONObject obj = new JSONObject(res);
							s = cts.toStudent(obj);
							Intent in = new Intent(MainActivity.this,
									SuccessfulLogin.class);
							in.putExtra("student", s);
							startActivity(in);
							// Toast.makeText(MainActivity.this,
							// "Succesfully logged in as "+s.getFirstName()+" "+s.getLastName(),
							// Toast.LENGTH_LONG).show();
						} catch (InterruptedException e) {
							Toast.makeText(MainActivity.this,
									"Invalid username or password",
									Toast.LENGTH_LONG).show();
							e.printStackTrace();
						} catch (ExecutionException e) {
							Toast.makeText(MainActivity.this,
									"Invalid username or password",
									Toast.LENGTH_LONG).show();
							e.printStackTrace();
						} catch (JSONException e) {
							Toast.makeText(MainActivity.this,
									"Invalid username or password",
									Toast.LENGTH_LONG).show(); // THIS WAS
																// GETTING
																// DISPLAYED
							e.printStackTrace();
						}
					} catch (Exception e) {
						Toast.makeText(MainActivity.this, "Network problem",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}
				}
			}
		});
		tvSignUp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent in = new Intent("in.ezeon.functions.SIGNUP");
				startActivity(in);
			}
		});
	}

	class HttpPostFormData extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("loginName", etLoginName.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("password", etPassword.getText()
					.toString()));
			String txt = conu.sendHttpRequest(urls[0], "post", pairs);
			return txt;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
