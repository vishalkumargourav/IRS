package in.ezeon.irsapp;

import in.ezeon.functions.SuccessfulLogin;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowNotification extends Activity {
	TextView tvSubject, tvDescription;
	Button btnBack;
	Student s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shownotification);
		tvDescription=(TextView)findViewById(R.id.tvDesription);
		tvSubject=(TextView)findViewById(R.id.tvSubject);
		btnBack=(Button)findViewById(R.id.btnBack);
		tvDescription.setText(getIntent().getStringExtra("description"));
		tvSubject.setText(getIntent().getStringExtra("subject"));
		s=(Student)getIntent().getSerializableExtra("student");
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(ShowNotification.this,NotificationList.class);
				in.putExtra("student",s);
				startActivity(in);
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
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
