package in.ezeon.functions;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import in.ezeon.irsapp.ConnectionToUrl;
import in.ezeon.irsapp.MainActivity;
import in.ezeon.irsapp.R;
import in.ezeon.irsapp.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Query extends Activity implements OnClickListener {
	EditText etQuery;
	Button btnSubmitQuery, btnCheckReply, btnReset, btnClose;
	ConnectionToUrl conu;
	Student s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query);
		s = new Student();
		s = (Student) getIntent().getSerializableExtra("student");
		System.out.println("Details of student are student id:"+s.getStudentId()+" name="+s.getFirstName());
		btnSubmitQuery = (Button) findViewById(R.id.btnSubmitQuery);
		btnCheckReply = (Button) findViewById(R.id.btnCheckReply);
		btnReset = (Button) findViewById(R.id.btnReset);
		btnClose = (Button) findViewById(R.id.btnClose);
		etQuery = (EditText) findViewById(R.id.etQuery);
		btnSubmitQuery.setOnClickListener(this);
		btnCheckReply.setOnClickListener(this);
		btnReset.setOnClickListener(this);
		btnClose.setOnClickListener(this);
		conu = new ConnectionToUrl();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSubmitQuery:
			String ip = "10.0.2.2";
			String url = "http://" + ip
					+ ":8080/MyProject/androidSaveQuery.htm";
			AsyncTask at = new HttpPostFormData().execute(url);
			String res;
			try {
				res = (String) at.get();
				Toast.makeText(Query.this,"Query successfully submitted" ,Toast.LENGTH_LONG).show();
				etQuery.setText("");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case R.id.btnReset:
			etQuery.setText("");
			break;
		case R.id.btnClose:
			Intent in1=new Intent(this,SuccessfulLogin.class);
			in1.putExtra("student", s);
			startActivity(in1);
			break;
		case R.id.btnCheckReply:
			Intent in=new Intent(Query.this,CheckReply.class);
			in.putExtra("student", s);
			startActivity(in);
			break;
		}

	}

	class HttpPostFormData extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			pairs.add(new BasicNameValuePair("query", etQuery.getText()
					.toString()));
			pairs.add(new BasicNameValuePair("submitedBy", s.getStudentId().toString()));
			pairs.add(new BasicNameValuePair("answer", "not answered"));
			pairs.add(new BasicNameValuePair("answeredBy", "-1"));
			String txt = conu.sendHttpRequest(urls[0], "post", pairs);
			return txt;
		}
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp=getMenuInflater();
		blowUp.inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
			case R.id.itmHome:
				Intent in1=new Intent(this,SuccessfulLogin.class);
				in1.putExtra("student", s);
				startActivity(in1);
				break;
			case R.id.itmLogout:
				Intent in=new Intent(this,MainActivity.class);
				startActivity(in);
				break;
		}
		return false;
	}
}
