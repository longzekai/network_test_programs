package cn.com.danny.lifestyle.net;

import cn.com.danny.lifestyle.MainActivity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

public class ParseJsonDataService extends Service {

	
	public static Handler mHandler ;
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		
		mHandler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch (msg.what) {
				case URLProtocol.CMD_REGISTER :
					Bundle bundle = msg.getData() ;
					String name = bundle.getString("name") ;
					String psw = bundle.getString("password") ;
					URLParam param = new URLParam(null) ;
					param.addParam("name", name) ;
					param.addParam("password", psw) ;
					docmd(URLProtocol.CMD_REGISTER, param) ;
					break;

				default:
					break;
				}
			}
		} ;
//		URLParam param = new URLParam(null) ;
//		Bundle bundle = docmd(URLProtocol.CMD_MOVIE , param) ;
//		Message message = new Message() ;
//		message.setData(bundle) ;
//		MainActivity.mHandler.sendMessage(message) ;
	}
	
	
	public Bundle docmd(int cmd , URLParam param ){
		Bundle result = new Bundle() ;
		result.putInt("cmd", cmd) ;
		URLParam _param = new URLParam(param) ;
		_param.addParam("cmd", cmd) ;
		String jsonStr = HttpConnection.HttpGet(URLProtocol.ROOT, _param) ;
		return result ;
		
//		URLParam _param = new URLParam(param) ;
//		_param.addParam("cmd", cmd) ;
//		String jsonStr = HttpConnection.HttpGet(URLProtocol.ROOT , _param) ;
//		Bundle bundle = new Bundle() ;
//		bundle.putString("jsonStr", jsonStr) ;
//		return bundle ;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
