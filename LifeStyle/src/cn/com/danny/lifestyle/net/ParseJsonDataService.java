package cn.com.danny.lifestyle.net;

import cn.com.danny.lifestyle.MainActivity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

public class ParseJsonDataService extends Service {

	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		Bundle bundle = docmd() ;
		Message message = new Message() ;
		message.setData(bundle) ;
		MainActivity.mHandler.sendMessage(message) ;
	}
	
	
	public Bundle docmd(){
		String jsonStr = HttpConnection.HttpGet("url_addr") ;
		Bundle bundle = new Bundle() ;
		bundle.putString("jsonStr", jsonStr) ;
		return bundle ;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
