package ar.com.stomalab.souyaban;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import ar.com.stomalab.souyaban.model.HighscoreDbManager;
import ar.com.stomalab.souyaban.model.HighscoreEntry;

public class HighscoreActivity extends ListActivity {
	private HighscoreDbManager db_manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_highscore);
		
		db_manager = new HighscoreDbManager(this);
		db_manager.openDb();
		
		db_manager.agregarHighscore(new HighscoreEntry("LEV1", 1, 124));
		db_manager.agregarHighscore(new HighscoreEntry("LEV1", 2, 150));
		db_manager.agregarHighscore(new HighscoreEntry("LEV1", 3, 132));
		db_manager.agregarHighscore(new HighscoreEntry("LEV2", 1, 100));
		db_manager.agregarHighscore(new HighscoreEntry("LEV2", 2, 56));
		db_manager.deleteHighscore(new HighscoreEntry("LEV1", 2, 150));
		db_manager.updateHighscore(new HighscoreEntry("LEV2", 1, 59));
		
		List<HighscoreEntry> valores = db_manager.getHighscoreLevelset("LEV1");
		
		// Use the SimpleCursorAdapter to show the
	    // elements in a ListView
	    ArrayAdapter<HighscoreEntry> adapter = new ArrayAdapter<HighscoreEntry>(this, android.R.layout.simple_list_item_1, valores);
	    setListAdapter(adapter);}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.highscore, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		db_manager.openDb();
		super.onResume();
	}

	@Override
	protected void onPause() {
		db_manager.closeDb();
		super.onPause();
	}


}
