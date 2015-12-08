package com.alessiomanai.dynamite;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Boom extends Activity {

	Button retry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//impedisce la rotazione dello schermo
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		///permette di avviare la finestra in fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_boom);
		
		/**fa partire lo scoppio all'inizio dell'activity*/
		MediaPlayer rs = MediaPlayer.create(Boom.this, R.raw.boom);
		rs.start();
		
				
		retry = (Button) findViewById(R.id.retry);
		
		retry.setOnClickListener(new OnClickListener(){
    		
			public void onClick(View arg0){
	    						
	    		finish();
			}
		});
		
	}
	
}
