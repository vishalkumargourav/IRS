package in.ezeon.functions;

import in.ezeon.irsapp.MainActivity;
import in.ezeon.irsapp.R;
import in.ezeon.irsapp.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SuccessfulLogin extends Activity{
	TextView tvWelcm;
	Button btnNotification, btnPoll, btnLogout, btnQuery;
	Student s;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.successfullogin);
		s=new Student();
		s = (Student) getIntent().getSerializableExtra("student");
		tvWelcm = (TextView) findViewById(R.id.tvWelcm);
		btnNotification = (Button) findViewById(R.id.btnNotificatin);
		btnPoll = (Button) findViewById(R.id.btnPoll);
		btnLogout = (Button) findViewById(R.id.btnQuery);
		btnLogout = (Button) findViewById(R.id.btnLogout);
		btnQuery =(Button)findViewById(R.id.btnQuery);
		tvWelcm.setText("Welcome " + s.getFirstName() + " " + s.getLastName());
		Toast.makeText(
				this,
				"You have successfully logged in as " + s.getFirstName() + " "
						+ s.getLastName(), Toast.LENGTH_LONG).show();
		btnNotification.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in1=new Intent("in.ezeon.functions.NOTIFICATIONLIST");
				in1.putExtra("student",s);
				startActivity(in1);
			}
		});
		btnLogout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(SuccessfulLogin.this,MainActivity.class);
				startActivity(in);
			}
		});
		btnQuery.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent("in.ezeon.functions.QUERY");
				in.putExtra("student", s);
				startActivity(in);
			}
		});
//		btnPoll.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				Intent in2=new Intent(SuccessfulLogin.this,PollList.class);
//				in2.putExtra("student", s);
//				startActivity(in2);
//			}
//		});
	}
	@Override
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
				
				break;
			case R.id.itmLogout:
				Intent in=new Intent(SuccessfulLogin.this,MainActivity.class);
				startActivity(in);
				break;
		}
		return false;
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
