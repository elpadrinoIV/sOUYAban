package ar.com.stomalab.souyaban.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HighscoreDbManager extends SQLiteOpenHelper {
	public static final String NOMBRE_DB = "highscore.db";
	public static final String NOMBRE_TABLA = "highscore";
	public static final String COLUMNA_ID = "id";
	public static final String COLUMNA_LEVELSET = "levelset";
	public static final String COLUMNA_NIVEL = "nivel";
	public static final String COLUMNA_MOVIMIENTOS = "movimientos";
	
	private static final int DATABASE_VERSION = 1;
	
	private SQLiteDatabase database;
	
	private String[] todas_las_columnas = {COLUMNA_ID, 	COLUMNA_LEVELSET, COLUMNA_NIVEL, COLUMNA_MOVIMIENTOS};

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
	      + NOMBRE_TABLA + "(" + COLUMNA_LEVELSET + " text not null, " +
								 COLUMNA_NIVEL + " integer, " +
								 COLUMNA_MOVIMIENTOS + " integer, " +
								 "primary key (" + COLUMNA_LEVELSET + ", " + COLUMNA_MOVIMIENTOS + "));";
								 
	
	public HighscoreDbManager(Context context) {
		super(context, NOMBRE_DB, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
		Log.d("ONCREATE", "CREANDO TABLA:" + DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA);
		onCreate(db);
	}
		
	public void open() throws SQLException {
		database = this.getWritableDatabase();
		Log.d("HIGHSCORE DB", "GETTING WRITABLE DB");
	}
	
	 public void close() {
		 this.close();
	 }

	 public void agregarHighscore(HighscoreEntry highscore_entry) {
		 SQLiteDatabase db = this.getWritableDatabase();
		 
		 ContentValues values = new ContentValues();
		 values.put(COLUMNA_LEVELSET, highscore_entry.getLevelset());
		 values.put(COLUMNA_NIVEL, highscore_entry.getNivel());
		 values.put(COLUMNA_MOVIMIENTOS, highscore_entry.getMovimientos());
		 
		 db.insert(NOMBRE_TABLA, null, values);
		 db.close();
	 }
	 
	 public void deleteHighscore(HighscoreEntry highscore_entry) {
		 // database.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_ID + " = " + id, null);
	 }

	public List<HighscoreEntry> getHighscoreCompleto() {
		List<HighscoreEntry> highscore_completo = new ArrayList<HighscoreEntry>();
		Cursor cursor = database.query(NOMBRE_TABLA, todas_las_columnas, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			HighscoreEntry highscore_entry= cursorToHighscoreEntry(cursor);
			highscore_completo.add(highscore_entry);
			cursor.moveToNext();
		}
		
		// Make sure to close the cursor
		cursor.close();
		return highscore_completo;
	}

	private HighscoreEntry cursorToHighscoreEntry(Cursor cursor) {
		HighscoreEntry highscore_entry = new HighscoreEntry();
		highscore_entry.setLevelset(cursor.getString(1));
		highscore_entry.setNivel(cursor.getInt(2));
		highscore_entry.setMovimientos(cursor.getInt(3));
		return highscore_entry;
	}
}
