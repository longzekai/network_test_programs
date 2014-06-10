package cn.com.danny.lifestyle.net;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// ÍøÂç²Ù×÷Àà
public class HttpConnection {
	public String HttpGet(String urlString){
		URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;
			connection.setRequestMethod("GET") ;
			InputStream inStream = connection.getInputStream() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
