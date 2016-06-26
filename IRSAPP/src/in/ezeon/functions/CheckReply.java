package in.ezeon.functions;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import in.ezeon.irsapp.ConnectionToUrl;
import in.ezeon.irsapp.MainActivity;
import in.ezeon.irsapp.R;
import in.ezeon.irsapp.Student;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CheckReply extends ListActivity {
	ConnectionToUrl conu;
	String res;
	Student s;
	ArrayList<String> queryList = new ArrayList<String>();
	ArrayList<String> answerList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		s = (Student) getIntent().getSerializableExtra("student");
		try {
			conu = new ConnectionToUrl();
			String ip = "10.0.2.2";
			String url = "http://" + ip
					+ ":8080/MyProject/androidQueryList.htm";
			AsyncTask at = new HttpPostFormData().execute(url);
			res = (String) at.get();
			JSONArray array = new JSONArray(res);
			for (int i = 0; i < array.length(); i += 1) {
				JSONObject obj = array.getJSONObject(i);
				if (Integer.parseInt(obj.getString("submitedBy")) == s
						.getStudentId()) {
					queryList.add(obj.getString("query"));
					answerList.add(obj.getString("answer"));
				}
			}
		} catch (Exception e) {
			queryList.add("No notifications found");
			answerList.add("No answers found");
			res = "No data recieved";
			e.printStackTrace();
		}
		setListAdapter(new ArrayAdapter<String>(CheckReply.this,
				android.R.layout.simple_list_item_1, queryList));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String answer;
		try{
			answer=answerList.get(position);
			Intent in=new Intent(CheckReply.this,ShowQueryAnswer.class);
			in.putExtra("query", queryList.get(position));
			in.putExtra("answer",answerList.get(position));
			in.putExtra("student",s);
			startActivity(in);
			//Toast.makeText(CheckReply.this,answer, Toast.LENGTH_LONG).show();
		}catch(Exception e){
			e.printStackTrace();
			Toast.makeText(CheckReply.this, "Answer not found",Toast.LENGTH_LONG).show();
		}
	}

	class HttpPostFormData extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
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
