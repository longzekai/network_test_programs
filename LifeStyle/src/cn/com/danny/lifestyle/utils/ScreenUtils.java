package cn.com.danny.lifestyle.utils;

import android.content.Context;
import android.widget.Toast;

//消息提示类
public class ScreenUtils {
	private Context mContext ;
	
	public ScreenUtils(Context context){
		mContext = context ;
	}
	
	public void showMsg(String text){
		Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show() ;
	}
}
