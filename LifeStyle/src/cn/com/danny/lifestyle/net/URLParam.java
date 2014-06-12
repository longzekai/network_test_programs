package cn.com.danny.lifestyle.net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLParam {
	//用来构建字符串
	public StringBuffer _query = new StringBuffer() ;
	
	public URLParam(URLParam urlParam) {
		if (urlParam != null) {
			_query.append(urlParam._query.toString()) ;
		}
	}
	
	// 添加String 类型的参数
	public void addParam (String name , String value) {
		if (_query.length() != 0) {
			_query.append('&') ;
		} else {
			_query.append('?') ;
		}
		
		try {
			_query.append(name).append('=').append(URLEncoder.encode(value, "UTF-8")) ;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 添加int 类型的参数
	public void addParam (String name , int value) {
		if (_query.length() != 0) {
			_query.append('&') ;
		} else {
			_query.append('?') ;
		}
		
		_query.append(name).append('=').append(value+"") ;
	}
	
	// 获得查询字符串
	public String getQueryStr(){
		return _query.toString() ;
	}
}











