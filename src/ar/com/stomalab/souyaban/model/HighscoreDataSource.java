package ar.com.stomalab.souyaban.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class HighscoreDataSource {
	// Database fields
	  private SQLiteDatabase database;
	  private HighscoreDatabaseHelper db_helper;
	  private String[] all_columns = { HighscoreDatabaseHelper.COLUMN_NAME_HIGHSCORE_ID,
			  					       HighscoreDatabaseHelper.COLUMN_NAME_LEVELSET,
			  					       HighscoreDatabaseHelper.COLUMN_NAME_NIVEL,
			  					       HighscoreDatabaseHelper.COLUMN_NAME_MOVIMIENTOS };

	  public HighscoreDataSource(Context context) {
	    db_helper = new HighscoreDatabaseHelper(context);
	  }

	  public void open() throws SQLException {
	    database = db_helper.getWritableDatabase();
	  }

	  public void close() {
	    db_helper.close();
	  }

	  public HighscoreEntry createComment(String levelset, int nivel, int movimientos) {
	    ContentValues values = new ContentValues();
	    values.put(HighscoreDatabaseHelper.COLUMN_NAME_LEVELSET, levelset);
	    values.put(HighscoreDatabaseHelper.COLUMN_NAME_NIVEL, nivel);
	    values.put(HighscoreDatabaseHelper.COLUMN_NAME_MOVIMIENTOS, movimientos);
	    
	    long insert_id = database.insert(HighscoreDatabaseHelper.TABLE_NAME, null, values);
	    Cursor cursor = database.query(HighscoreDatabaseHelper.TABLE_NAME,
	        all_columns, HighscoreDatabaseHelper.COLUMN_NAME_HIGHSCORE_ID + " = " + insert_id, null,
	        null, null, null);
	    cursor.moveToFirst();
	    HighscoreEntry new_highscore = cursorToHighscoreEntry(cursor);
	    cursor.close();
	    return new_highscore;
	  }

	  /*
	  public void deleteComment(Comment comment) {
	    long id = comment.getId();
	    System.out.println("Comment deleted with id: " + id);
	    database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID
	        + " = " + id, null);
	  }
*/
	  
	  public List<HighscoreEntry> getComleteHighscore() {
	    List<HighscoreEntry> complete_highscore = new ArrayList<HighscoreEntry>();

	    Cursor cursor = database.query(HighscoreDatabaseHelper.TABLE_NAME,
	        all_columns, null, null, null, null, null);

	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	HighscoreEntry highscore_entry = cursorToHighscoreEntry(cursor);
	    	complete_highscore.add(highscore_entry);
	    	cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return complete_highscore;
	  }
	  
	  private HighscoreEntry cursorToHighscoreEntry(Cursor cursor) {
		  HighscoreEntry highscore_entry = new HighscoreEntry();
		  highscore_entry.setId(cursor.getLong(0));
		  highscore_entry.setLevelset(cursor.getString(1));
		  highscore_entry.setNivel(cursor.getInt(2));
		  highscore_entry.setMovimientos(cursor.getInt(3));
		  
		  return highscore_entry;
	  }
}
