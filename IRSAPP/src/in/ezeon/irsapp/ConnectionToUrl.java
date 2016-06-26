package in.ezeon.irsapp;

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

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class ConnectionToUrl {
	public String sendHttpRequest(String url, String requestType,
			List<NameValuePair> params) {
		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		InputStream is = null;
		String responseText = null;
		try {
			URL urlPath = null;
			String paramString = URLEncodedUtils.format(params, "utf-8");

			if (requestType.equalsIgnoreCase("GET")) {
				urlPath = new URL(url + "?" + paramString);
			}
			if (requestType.equalsIgnoreCase("POST")) {
				urlPath = new URL(url);
			}
			conn = (HttpURLConnection) urlPath.openConnection();
			conn.setReadTimeout(10000);
			conn.setConnectTimeout(15000);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			if (requestType.equalsIgnoreCase("GET")) {
				conn.setRequestMethod("GET");
			}
			if (requestType.equalsIgnoreCase("POST")) {
				conn.setRequestMethod("POST");
			}
			// send the data to the server using post
			dos = new DataOutputStream(conn.getOutputStream());
			dos.writeBytes(paramString);
			dos.flush();

			// Starts the query
			conn.connect();
			int response = conn.getResponseCode();

			is = conn.getInputStream();

			// Convert the InputStream into a string
			responseText = readResponse(is);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
					dos.close();
					conn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}

	String readResponse(InputStream in) throws IOException {
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		StringBuilder sb = new StringBuilder();

		String line = null;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}
