package in.ezeon.irsapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import in.ezeon.functions.SuccessfulLogin;
import in.ezeon.irsapp.MainActivity.HttpPostFormData;
import in.ezeon.utility.ConvertToNotification;
import in.ezeon.utility.Notification;
import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NotificationList extends ListActivity {
	ConnectionToUrl conu;
	ArrayList<String> notifications = new ArrayList<String>();
	ArrayList<String> descriptions = new ArrayList<String>();
	Student s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String res;
		s=new Student();
		s=(Student)getIntent().getSerializableExtra("student");
		try {
			conu = new ConnectionToUrl();
			String ip = "10.0.2.2";
			String url = "http://" + ip
					+ ":8080/MyProject/androidStudentNotification.htm";
			AsyncTask at = new HttpPostFormData().execute(url);
			res = (String) at.get();
			JSONArray array = new JSONArray(res);
			for (int i = 0; i < array.length(); i += 1) {
				JSONObject obj = array.getJSONObject(i);
//				notificationsObjects.add(conot.ConvertToNotificationUtil(obj));
				descriptions.add(obj.getString("description"));
				notifications.add(obj.getString("subject"));
			}
		} catch (Exception e) {
			notifications.add("No notifications found");
			res = "No data recieved";
			e.printStackTrace();
		}
		setListAdapter(new ArrayAdapter<String>(NotificationList.this,
				android.R.layout.simple_list_item_1, notifications));
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
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try {
			String desc=descriptions.get(position);
			Toast.makeText(NotificationList.this, desc, Toast.LENGTH_LONG)
					.show();
			Intent in=new Intent("in.ezeon.functions.SHOWNOTIFICATION");
			in.putExtra("subject", notifications.get(position));
			in.putExtra("description", desc);
			in.putExtra("student", s);
			startActivity(in);
		} catch (Exception e) {
			Toast.makeText(NotificationList.this, "The problem is here",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
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