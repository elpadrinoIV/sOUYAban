package ar.com.stomalab.souyaban.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HighscoreDbManager extends SQLiteOpenHelper {
	public static final String NOMBRE_DB = "highscore.db";
	public static final String NOMBRE_TABLA = "highscore";
	public static final String COLUMNA_ID = "id";
	public static final String COLUMNA_LEVELSET = "levelset";
	public static final String COLUMNA_NIVEL = "nivel";
	public static final String COLUMNA_MOVIMIENTOS = "movimientos";
	
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
	      + NOMBRE_TABLA + "(" + COLUMNA_ID + " integer primary key autoincrement, " +
								 COLUMNA_LEVELSET + "text not null, " +
								 COLUMNA_NIVEL + "integer, " +
								 COLUMNA_MOVIMIENTOS + "integer);";
	
	public HighscoreDbManager(Context context) {
		super(context, NOMBRE_DB, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA);
    onCreate(db);
  }
}
