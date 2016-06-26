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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowQueryAnswer extends Activity{
	String query;
	String answer;
	TextView etQuery;
	TextView etAnswer;
	Student s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showqueryanswer);
		s=new Student();
		s = (Student) getIntent().getSerializableExtra("student");
		etQuery=(TextView)findViewById(R.id.tvQuery);
		etAnswer=(TextView)findViewById(R.id.tvAnswer);
		query=getIntent().getStringExtra("query");
		answer=getIntent().getStringExtra("answer");
		etQuery.setText(query);
		etAnswer.setText(answer);
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
