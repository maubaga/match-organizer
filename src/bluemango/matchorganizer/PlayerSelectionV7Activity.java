package bluemango.matchorganizer;

import static android.provider.BaseColumns._ID;
import static bluemango.matchorganizer.Constants.NAME;
import static bluemango.matchorganizer.Constants.VALUE;
import static bluemango.matchorganizer.Constants.POSITION;
import static bluemango.matchorganizer.Constants.TABLE_NAME;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class PlayerSelectionV7Activity extends ListActivity {
	private PlayersData events;

	final int TOT = 14;
	
	int idx = 0;
	int idx_2 = 0;
	String names[] = new String[100];
	String values[] = new String[100];
	String positions[] = new String[100];
	final String[] FROM_NAME = { NAME };
	final String[] FROM_VALUE = { VALUE };
	final String[] FROM_POSITION = { POSITION };
	String name = "";
	String value = "";
	String pos = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_selection);
		events = new PlayersData(this);
		try {
			Cursor cursor = getEvents();
			showEvents(cursor);
		} finally {
			//			events.close();
		}

		ListView list = (ListView)findViewById(android.R.id.list);
		LinearLayout check_layout = (LinearLayout) findViewById(R.id.check_layout);

		for(int i = 0; i < list.getCount(); i++){

			CheckBox check = new CheckBox(this);
			check.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			check.setPadding(0, 0, 0, 24);
			check.setTextSize(20);
			check.setFocusable(false);
			check.setFocusableInTouchMode(false);
			check.setClickable(false);
			check.setId(i);

			check_layout.addView(check);

		}

		list.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view,
					int position, long id) {
				
				CheckBox checkbox = (CheckBox) findViewById(position);
				ImageView image = (ImageView) view.findViewById(R.id.image);

				if(checkbox.isChecked()){

					checkbox.setChecked(false);
					image.setVisibility(View.INVISIBLE);
					idx--;

				} else {

					checkbox.setChecked(true);
					image.setVisibility(View.VISIBLE);
					idx++;
					
					SQLiteDatabase db = events.getReadableDatabase();
					
					Cursor c_name = db.query(TABLE_NAME, FROM_NAME, "_ID = " + id , null, null, null, null);
					c_name.moveToFirst();
					name = c_name.getString(0);
					
					names[(idx - 1)] = name;
					
					Cursor c_value = db.query(TABLE_NAME, FROM_VALUE, "_ID = " + id , null, null, null, null);
					c_value.moveToFirst();
					value = c_value.getString(0);
					
					values[(idx - 1)] = value;
					
					Cursor c_position = db.query(TABLE_NAME, FROM_POSITION, "_ID = " + id , null, null, null, null);
					c_position.moveToFirst();
					pos = c_position.getString(0);
					
					positions[(idx - 1)] = pos;
				}

			}
		});

	}

	private static String[] FROM = { _ID, NAME, VALUE, POSITION };
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

	private static int[] TO = { R.id.rowid, R.id.nome, R.id.valore, R.id.ruolo };
	private void showEvents(Cursor cursor) {
		// Set up data binding
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.checkbox_item, cursor, FROM, TO);
		setListAdapter(adapter);
	}

	public void goMatchBoard(View view){
		
		if(idx < TOT){
			
			Toast.makeText(getApplicationContext(), "Devi selezionare almeno " + TOT + " giocatori.", Toast.LENGTH_SHORT).show();
			
		} else if(idx > TOT){
			
			Toast.makeText(getApplicationContext(), "Non puoi selezionare più di " + TOT + " giocatori.", Toast.LENGTH_SHORT).show();
			
		} else if(idx == TOT){
			
			Intent intent = new Intent(this, MatchBoardV7Activity.class);
			intent.putExtra("names", names);
			intent.putExtra("values", values);
			intent.putExtra("positions", positions);
			
			startActivity(intent);
			
		}
	}
	
	public void onBackPressed(){

		this.startActivity(new Intent(this,OrganizerActivity.class)); 

	}
}
