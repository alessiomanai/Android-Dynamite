package com.alessiomanai.dynamite;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class Start extends Activity implements SensorEventListener {

	ImageView shake;
	Intent game;
	SensorManager sm = null;
	static int contatore = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		//impedisce la rotazione dello schermo
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		///permette di avviare la finestra in fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_start);
				
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		
		//sm.registerListener(this, sm.getDefaultSensor( Sensor.TYPE_ACCELEROMETER ),SensorManager.SENSOR_DELAY_NORMAL );
				
		shake = (ImageView) findViewById(R.id.shakephone);
		
		shake.setOnClickListener(new OnClickListener(){
    		
			public void onClick(View arg0){
	    		
				contatore++;
				
	    		avvia();
			}
		});
		
		
		
		
	}

	
	void avvia(){
		
		game = new Intent(getBaseContext(), Game.class);

		//avvia la finestra corrispondente
		startActivity(game);
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		
		avvia();
		
	}

	@Override
	public void onSensorChanged(SensorEvent arg0) {
		
		if (arg0.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				avvia();
		}
	}
	
	
}
