package cn.com.danny.lifestyle;

import cn.com.danny.lifestyle.net.ParseJsonDataService;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txtView ;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView)findViewById(R.id.txtView) ;
        Intent intent = new Intent(this, ParseJsonDataService.class) ;
        startService(intent) ;
        
    }
    
    
    public static Handler mHandler = new Handler(){
    	public void handleMessage(android.os.Message msg) {
//    		Bundle bundle = msg.getData() ;
//    		String jsonStr = bundle.getString("jsonStr") ;
    	};
    } ;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
