package in.ezeon.utility;

import in.ezeon.irsapp.Student;

import org.json.JSONException;
import org.json.JSONObject;

public class ConvertToStudent {
	public Student toStudent(JSONObject obj) throws JSONException{
		final Student s=new Student();
		s.setStudentId(obj.getInt("studentId"));
		s.setScholarNumber(obj.getString("scholarNumber"));
		s.setFirstName(obj.getString("firstName"));
		s.setLastName(obj.getString("lastName"));
		s.setGender(obj.getString("gender"));
		s.setEmail(obj.getString("gender"));
		s.setPhone(obj.getString("phone"));
		s.setAlternatePhone(obj.getString("alternatePhone"));
		s.setSemester(obj.getInt("semester"));
		s.setPassword(obj.getString("password"));
		s.setlStatus(obj.getInt("lStatus"));
		s.setvStatus(obj.getInt("vStatus"));
		return s;
	}
}
