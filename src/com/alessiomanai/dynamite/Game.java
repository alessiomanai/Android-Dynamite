package com.alessiomanai.dynamite;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;




public class Game extends Activity {

	Intent gameover;
	String gioco;
	TextView display;
	long timeb;
	CountDownTimer tim;
	MediaPlayer tic;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//impedisce la rotazione dello schermo
	    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		///permette di avviare la finestra in fullscreen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_game);
		
		/***fa partire l'audio di sottofondo all'inizio dell'activity*/
		tic = MediaPlayer.create(Game.this, R.raw.tictac);
		tic.start();
		
		/**fa rimanere lo schermo acceso*/
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		/**collega la consegna al layout*/
		display = (TextView) findViewById(R.id.frase);
		
		//genera la consegna
		generatore();
		
		//genera la durata della sessione
		timer();
		
		//setta la consegna
		display.setText(gioco);
		
		/***avvia il timer*/
		tim = new CountDownTimer(timeb, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 
		     }
		     /**appena finisce il timer avvia la schermata successiva*/
		     public void onFinish() {
		    	 tic.stop();
		    	 boom();
		     }
		  }.start();
		
	}	//fine oncreate
	
	
	void timer(){
		
		int a = (int) (Math.random()* 8);
		
		switch (a){
			case 0: timeb = 30000; break;
			case 1: timeb = 40000; break;
			case 2: timeb = 50000; break;
			case 3: timeb = 55000; break;
			case 4: timeb = 20000; break;
			case 5: timeb = 25000; break;
			case 6: timeb = 15000; break;
			case 7: timeb = 5000; break;
			case 8: timeb = 10000; break;
		}
	}
	
	void generatore(){
		
		int a = (int) (Math.random()* 16);
		
		switch (a){
		
			case 0: gioco = getString(R.string.marche) + " " + alfabeto();
				break;
			case 1: gioco = getString(R.string.vips) + " " + alfabeto();
				break;
			case 2: gioco = getString(R.string.colours) + " " + colori();
				break;
			case 3: gioco = getString(R.string.nomiInit) + " " + alfabeto();
				break;
			case 4: gioco = getString(R.string.wordscontengono) + " " + inmezzo();
				break;
			case 5: gioco = getString(R.string.wordend) + " " + fine();
				break;
			case 6: gioco = getString(R.string.wordmezzo) + " " + inmezzo();
				break;
			case 7: gioco = getString(R.string.aggettivi) + " " + alfabeto();
				break;		
			case 8: gioco = getString(R.string.avverbi) + " " + alfabeto();
				break;			
			case 9: gioco = getString(R.string.wordstart) + " " + iniziano();
				break;	
			case 10: gioco = getString(R.string.wordend) + " " + fine();
				break;
			case 11: gioco = getString(R.string.wordstart) + " " + iniziano();
				break;	
			case 12: gioco = getString(R.string.states) + " " + alfabeto();
				break;
			case 13: gioco = getString(R.string.wordscontengono) + " " + inmezzo();
				break;
			case 14: gioco = getString(R.string.wordend) + " " + fine();
				break;
			case 15: gioco = getString(R.string.wordstart) + " " + iniziano();
				break;	
			case 16: gioco = getString(R.string.wordmezzo) + " " + inmezzo();
				break;
		}	
		
	}
	
	/***generatori di fine consegna*/
	String fine(){
		
		int i = (int) (Math.random()* 25);

		switch (i) {
		
			case 0: return "ARE";
			case 1: return "ERE";
			case 2: return "IRE";
			case 3: return "NA";
			case 4: return "ATO";
			case 5: return "ENO";
			case 6: return "LA";
			case 7: return "PE";
			case 8: return "NE";
			case 9: return "OSO";
			case 10: return "GO";
			case 11: return "ENI";
			case 12: return "INE";
			case 13: return "ANO";
			case 14: return "MENTO";
			case 15: return "ETTA";
			case 16: return "STA";
			case 17: return "ETTO";
			case 18: return "NZI";
			case 19: return "LLO";
			case 20: return "DÌ";
			case 21: return "ONI";
			case 22: return "ERO";
			case 23: return "EMO";
			case 24: return "INA";
			case 25: return "ELLO";
		}
		
		return "\0";
		
	}
	
	String iniziano(){
		
		int i = (int) (Math.random()* 20);

		switch (i) {
		
			case 0: return "SCI";
			case 1: return "VU";
			case 2: return "BO";
			case 3: return "CON";
			case 4: return "TO";
			case 5: return "NO";
			case 6: return "LA";
			case 7: return "PE";
			case 8: return "NE";
			case 9: return "BA";
			case 10: return "GO";
			case 11: return "ORG";
			case 12: return "PER";
			case 13: return "VUL";
			case 14: return "MAT";
			case 15: return "MAD";
			case 16: return "COM";
			case 17: return "LAM";
			case 18: return "CEL";
			case 19: return "CAR";
			case 20: return "MUT";
		}
		
		return "\0";
	}
	
	String inmezzo(){
		
		int i = (int) (Math.random()* 12);

		switch (i) {
		
			case 0: return "SCI";
			case 1: return "MP";
			case 2: return "BO";
			case 3: return "CON";
			case 4: return "TO";
			case 5: return "NO";
			case 6: return "LA";
			case 7: return "PE";
			case 8: return "NE";
			case 9: return "BA";
			case 10: return "GO";
			case 11: return "OSO";
			case 12: return "PER";
		}
		
		return "\0";
	}
	
	char colori(){
		
		int i = (int) (Math.random()* 20);

		switch (i) {
		
			case 0: return 'A';
			case 1: return 'B';
			case 2: return 'C';
			case 3: return 'D';
			case 4: return 'E';
			case 5: return 'F';
			case 6: return 'G';
			case 7: return 'A';
			case 8: return 'I';
			case 9: return 'L';
			case 10: return 'M';
			case 11: return 'N';
			case 12: return 'O';
			case 13: return 'O';
			case 14: return 'C';
			case 15: return 'R';
			case 16: return 'S';
			case 17: return 'T';
			case 18: return 'U';
			case 19: return 'V';
			case 20: return 'A';
		}
		
		return '\0';
	}
	
	
	char alfabeto(){
		
		int i = (int) (Math.random()* 21);

		switch (i) {
		
			case 0: return 'A';
			case 1: return 'B';
			case 2: return 'C';
			case 3: return 'D';
			case 4: return 'E';
			case 5: return 'F';
			case 6: return 'G';
			case 7: return 'H';
			case 8: return 'I';
			case 9: return 'L';
			case 10: return 'M';
			case 11: return 'N';
			case 12: return 'O';
			case 13: return 'P';
			case 14: return 'Q';
			case 15: return 'R';
			case 16: return 'S';
			case 17: return 'T';
			case 18: return 'U';
			case 19: return 'V';
			case 20: return 'Z';
			case 21: return 'W';

		}
		
		return '\0';
	}
	
	/**appena finisce il timer avvia la schermata successiva*/
	void boom(){
		gameover = new Intent(getBaseContext(), Boom.class);

		//avvia la finestra corrispondente
		startActivity(gameover);
		
		finish();
	}
	
	public void onBackPressed() {
		tim.cancel();	//blocca il timer
		tic.stop();		//blocca il suono
		finish();	//così smette di ticchettare
	}
	

}
