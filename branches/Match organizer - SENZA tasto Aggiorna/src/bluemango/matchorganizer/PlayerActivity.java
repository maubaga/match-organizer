package bluemango.matchorganizer;

import static android.provider.BaseColumns._ID;
import static bluemango.matchorganizer.Constants.NAME;
import static bluemango.matchorganizer.Constants.NUMBER;
import static bluemango.matchorganizer.Constants.POSITION;
import static bluemango.matchorganizer.Constants.TABLE_NAME;
import static bluemango.matchorganizer.Constants.VALUE;

import java.io.File;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class PlayerActivity extends ListActivity {
	private PlayersData events;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		events = new PlayersData(this);
		try {
			Cursor cursor = getEvents();
			showEvents(cursor);
		} finally {
//						events.close();
		}

		ListView list = (ListView)findViewById(android.R.id.list);
		registerForContextMenu(list);

	}

	private static String[] FROM = { _ID, NAME, VALUE, POSITION, NUMBER };
	private static String ORDER_BY = _ID + " ASC" ;
	private Cursor getEvents() {
		// Perform a managed query. The Activity will handle closing
		// and re-querying the cursor when needed.
		SQLiteDatabase db = events.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null,
				null, ORDER_BY);
		startManagingCursor(cursor);


		return cursor;
	}

	private static int[] TO = { R.id.rowid, R.id.nome, R.id.valore, R.id.ruolo, R.id.numero, };
	private void showEvents(Cursor cursor) {
		// Set up data binding
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.item, cursor, FROM, TO);
		setListAdapter(adapter);
	}

	public void addPlayer(View view) {
		startActivity(new Intent(this, AddPlayersActivity.class));
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.players_menu, menu);
	}



	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.mod:
			editPlayer(info.id);
			return true;
		case R.id.del:
			deletePlayer(info.id);
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

	public void editPlayer(long id) {

//				SQLiteDatabase db = events.getWritableDatabase();
//				db.update(TABLE_NAME, values, whereClause, null);
//				
//				startActivity(new Intent(this, Events.class));

	}

	public void deletePlayer(long id) {

		SQLiteDatabase db = events.getWritableDatabase();
		db.delete(TABLE_NAME, _ID + "=" + id, null);

		startActivity(new Intent(this,PlayerActivity.class));

	}
	
	public void clearData(View view) {

		startActivity(new Intent(this,ConfirmDeleteActivity.class));

	}

	public void onBackPressed(){

		this.startActivity(new Intent(PlayerActivity.this,MainActivity.class)); 

	}
	
}
