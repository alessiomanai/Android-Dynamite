package com.alessiomanai.dynamite;

/**
 * 	Dynamite for Android
    Copyright (C) 2014-2015		Alessio Manai 

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 		alessiomanai.tk 	alessio@manai.tk
 * */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

	Button credits, play;
	Intent plays;
	ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//impedisce la rotazione dello schermo
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		///permette di avviare la finestra in fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_main);
				
		/**collega i bottoni*/
        play = (Button) findViewById(R.id.play);
        credits = (Button) findViewById(R.id.credits);
        
        /**avvia la partita*/
        play.setOnClickListener(new OnClickListener(){
    		
			public void onClick(View arg0){
	    		
	    		
	    		plays = new Intent(getBaseContext(), Start.class);

	    		//avvia la finestra corrispondente
	    		startActivity(plays);
			}
		});
        
        /**finestra di dialogo crediti*/
        credits.setOnClickListener(new OnClickListener(){
    		
			public void onClick(View arg0){
				
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle(R.string.Credits);
				builder.setMessage("Dynamite 1.0.14\nDeveloped by Alessio Manai");
				builder.setCancelable(false);
				builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
				@Override
				
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						}
					});
				
				builder.show();
	    		
			}
		});
		
	}
	

}
