package bluemango.matchorganizer;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
	public static final String TABLE_NAME = "players" ;
	// Columns in the Events database
	public static final String NAME = "nome" ;
	public static final String VALUE = "valore" ;
	public static final String POSITION = "ruolo" ;
	public static final String NUMBER = "numero" ;
	public static final String MATCHES = "partite" ;
	public static final String AV_MARKS = "media voti" ;
	public static final String GOALS = "goal" ;
	public static final String AV_GOALS = "media goal" ;
}