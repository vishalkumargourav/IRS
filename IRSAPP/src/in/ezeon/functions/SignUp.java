package in.ezeon.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import in.ezeon.irsapp.ConnectionToUrl;
import in.ezeon.irsapp.MainActivity;
import in.ezeon.irsapp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class SignUp extends Activity implements OnCheckedChangeListener{
	EditText etScholarNumber,etFirstName,etLastName,etEmail,etPhone,etAlternatePhone,etSemester,etLoginName,etPassword;
	RadioGroup rgGender;
	Button btnSave,btnBack;
	String gender;
	ConnectionToUrl conu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		rgGender=(RadioGroup)findViewById(R.id.rgGender);
		etScholarNumber=(EditText)findViewById(R.id.etScholarNumber);
		etFirstName=(EditText)findViewById(R.id.etFirstName);
		etLastName=(EditText)findViewById(R.id.etLastName);
		rgGender=(RadioGroup)findViewById(R.id.rgGender);
		etEmail=(EditText)findViewById(R.id.etEmail);
		etPhone=(EditText)findViewById(R.id.etPhone);
		etAlternatePhone=(EditText)findViewById(R.id.etAlternatePhone);
		etSemester=(EditText)findViewById(R.id.etSemester);
		etLoginName=(EditText)findViewById(R.id.etLoginName);
		etPassword=(EditText)findViewById(R.id.etPassword);
		btnSave=(Button)findViewById(R.id.btnSave);
		btnBack=(Button)findViewById(R.id.btnBack);
		rgGender.setOnCheckedChangeListener(this);
		conu=new ConnectionToUrl();
		addListener();
	}
	void addListener(){
		btnSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String ip="10.0.2.2";
				String url="http://"+ip+":8080/MyProject/androidRegisterStudent.htm";
				AsyncTask at=new HttpPostFormData().execute(url);
				String res;
				try{
					res=(String)at.get();
					Toast.makeText(SignUp.this, res, Toast.LENGTH_LONG).show();
					etScholarNumber.setText("");
					etFirstName.setText("");
					etLastName.setText("");
					etEmail.setText("");
					etPhone.setText("");
					etAlternatePhone.setText("");
					etSemester.setText("");
					etLoginName.setText("");
					etPassword.setText("");
				}catch(InterruptedException e){
					e.printStackTrace();
				}catch(ExecutionException e){
					e.printStackTrace();
				}
			}
		});
		btnBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in = new Intent(SignUp.this,MainActivity.class);
				startActivity(in);
			}
		});
	}
	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		switch(arg1){
		case R.id.rbFemale:
			gender="Female";
			break;
		case R.id.rbMale:
			gender="Male";
			break;
		}
	}
	class HttpPostFormData extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("scholarNumber", etScholarNumber.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("firstName", etFirstName.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("lastName", etLastName.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("gender", gender));
			pairs.add(new BasicNameValuePair("email", etEmail.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("phone", etPhone.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("alternatePhone", etAlternatePhone.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("semester", etSemester.getText()
					.toString()));
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
