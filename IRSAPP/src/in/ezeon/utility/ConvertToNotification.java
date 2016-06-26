package in.ezeon.utility;

import org.json.JSONException;
import org.json.JSONObject;

public class ConvertToNotification {
	public Notification ConvertToNotificationUtil(JSONObject obj)
			throws NumberFormatException, JSONException {
		Notification n = new Notification();
		n = null;
		try {
			n.setNotificationId(Integer.parseInt(obj
					.getString("notificationId")));
			n.setSubject(obj.getString("subject"));
			n.setDescription(obj.getString("description"));
			n.setAddedby(obj.getString("addedBy"));
			n.setNotificationId(Integer.parseInt(obj
					.getString("adminId")));
			return n;
			//ADD THE CODE FOR DATE ALSO
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
