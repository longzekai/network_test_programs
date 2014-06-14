package cn.com.danny.lifestyle.net;

import org.json.JSONException;
import org.json.JSONObject;

import cn.com.danny.lifestyle.MainActivity;
import android.R.integer;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

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
					Bundle result = docmd(URLProtocol.CMD_REGISTER, param) ;
					Message message = new Message() ;
					message.what = URLProtocol.CMD_REGISTER ;
					message.setData(result) ;
					//最后用handler 发送出去。
					
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
		Log.i("lifestyle", jsonStr) ;
		//把Json中的特殊符号过滤掉
		jsonStr.replaceAll("(\r\n|\r|\n|\n\r)", " ") ;
		
		try {
			JSONObject json = new JSONObject(jsonStr) ;
			int code = json.getInt("code") ; //return code tag ;
			result.putInt("code", code) ;
			
			int returnCmd = json.getInt("cmd") ; // request code tag ;
			if (returnCmd != cmd) {
				Log.e("lifestyle", "Data Error!") ;
			}
			result.putInt("cmd", cmd) ;
			//向服务器发送请求成功
			if (code == 0) {
				switch (cmd) {
				case URLProtocol.CMD_REGISTER :
					// 获取登录的uid
					String uid = json.getString("uid") ;
					break;
				}
			} else {
				Log.e("lifestyle", "Server Error! ") ;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
