package bluemango.matchorganizer;

import static android.provider.BaseColumns._ID;
import static bluemango.matchorganizer.Constants.NAME;
import static bluemango.matchorganizer.Constants.NUMBER;
import static bluemango.matchorganizer.Constants.POSITION;
import static bluemango.matchorganizer.Constants.TABLE_NAME;
import static bluemango.matchorganizer.Constants.VALUE;
import static bluemango.matchorganizer.Constants.MATCHES;
import static bluemango.matchorganizer.Constants.AV_MARKS;
import static bluemango.matchorganizer.Constants.GOALS;
import static bluemango.matchorganizer.Constants.AV_GOALS;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlayersData extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "players.db" ;
	private static final int DATABASE_VERSION = 1;

	/** Create a helper object for the Events database */
	public PlayersData(Context ctx) {
		super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME
				+ " TEXT NOT NULL," + VALUE + " TEXT NOT NULL," + POSITION
				+ " TEXT NOT NULL," + NUMBER + " TEXT," + MATCHES + " INTEGER"
				+ AV_MARKS + "DOUBLE" + GOALS + "INTEGER"
				+ AV_GOALS + "DOUBLE);" );
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

}

