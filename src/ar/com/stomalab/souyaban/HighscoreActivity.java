package ar.com.stomalab.souyaban;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
import ar.com.stomalab.souyaban.model.HighscoreDbManager;
import ar.com.stomalab.souyaban.model.HighscoreEntry;

public class HighscoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_highscore);
		
		TextView text_view = (TextView) this.findViewById(R.id.HIGHSCORE_TEXT);
		
		text_view.setText("Hola chiche");
		HighscoreDbManager db_manager = new HighscoreDbManager(this);
		// db_manager.open();
		
		db_manager.agregarHighscore(new HighscoreEntry("LEV1", 1, 124));
		db_manager.agregarHighscore(new HighscoreEntry("LEV1", 2, 150));
		db_manager.agregarHighscore(new HighscoreEntry("LEV1", 3, 132));
		db_manager.agregarHighscore(new HighscoreEntry("LEV2", 1, 100));
		db_manager.agregarHighscore(new HighscoreEntry("LEV2", 2, 56));
				
		//db_manager.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.highscore, menu);
		return true;
	}

}
