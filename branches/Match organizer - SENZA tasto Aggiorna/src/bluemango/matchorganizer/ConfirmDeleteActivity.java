package bluemango.matchorganizer;

import static bluemango.matchorganizer.Constants.TABLE_NAME;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class ConfirmDeleteActivity extends Activity {
	private PlayersData events;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_delete);
		events = new PlayersData(this);
	}

	public void clearData(View view) {

		SQLiteDatabase db = events.getWritableDatabase();
		db.delete(TABLE_NAME, null, null);

		startActivity(new Intent(this, PlayerActivity.class));

	}

	public void cancel(View view) {

		startActivity(new Intent(this, PlayerActivity.class));

	}

}
