package cn.com.danny.lifestyle.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// 网络操作类
public class HttpConnection {
	public static String HttpGet(String urlString , URLParam param){
		try {
			urlString += param.getQueryStr() ;
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;
			connection.setRequestMethod("GET") ;
			InputStream inStream = connection.getInputStream() ;
			byte[] data = readData(inStream) ;
			String result = new String(data, "gbk") ;
			return result ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	
	public static byte[] readData(InputStream inStream) throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream() ;
		byte[] buffer = new byte[1024] ;
		int len = -1 ;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0 , len) ;
		}
		byte[] data = outStream.toByteArray() ;
		outStream.close() ;
		inStream.close() ;
		return data ;
	}
}
