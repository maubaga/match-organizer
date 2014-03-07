package bluemango.matchorganizer;

import static bluemango.matchorganizer.Constants.NAME;
import static bluemango.matchorganizer.Constants.NUMBER;
import static bluemango.matchorganizer.Constants.POSITION;
import static bluemango.matchorganizer.Constants.TABLE_NAME;
import static bluemango.matchorganizer.Constants.VALUE;

import java.util.Scanner;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPlayersActivity extends Activity {

	private PlayersData events;
	CheckBox gk;
	CheckBox dif;
	CheckBox cen;
	CheckBox att;

	@SuppressWarnings("rawtypes")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_players);

		Spinner s = (Spinner) findViewById(R.id.edit_value);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.value_options, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_players, menu);
		return true;
	}

	public void addPlayer(View view) {
		EditText editName = (EditText) findViewById(R.id.edit_name);
	
		Boolean isNameWrong = false;
		String str = editName.getText().toString();
		if(str.equals("")){
			
			Toast.makeText(getApplicationContext(), "Devi inserire un nome.", Toast.LENGTH_SHORT).show();
			isNameWrong = true;
			
		}
		
		if(str.contains(" ")){
			
			Toast.makeText(getApplicationContext(), "Non puoi inserire spazi nel nome.", Toast.LENGTH_SHORT).show();
			isNameWrong = true;
			
		}
		Spinner editValue = (Spinner) findViewById(R.id.edit_value);
		str = str + " " + editValue.getSelectedItem().toString();
		gk = (CheckBox) findViewById(R.id.gk);
		dif = (CheckBox) findViewById(R.id.dif);
		cen = (CheckBox) findViewById(R.id.cen);
		att = (CheckBox) findViewById(R.id.att);
		boolean isFirst = true;
		int i = 0;
		if (gk.isChecked()) {
			str = str + " Por";
			isFirst = false;
			i++;
		}
		if (dif.isChecked() && isFirst) {
			str = str + " Dif";
			isFirst = false;
			i++;
		}
		else if (dif.isChecked()){
			str = str + "/Dif";
			i++;
		}

		if (cen.isChecked() && isFirst) {
			str = str + " Cen";
			isFirst = false;
			i++;
		}
		else if (cen.isChecked()){
			str = str + "/Cen";
			i++;
		}
		if (att.isChecked() && isFirst) {
			str = str + " Att";
			isFirst = false;
			i++;
		}
		else if (att.isChecked()){
			str = str + "/Att";
			i++;
		}
		EditText editNumber = (EditText) findViewById(R.id.edit_number);
		str = str + " " + editNumber.getText().toString();

		if(i == 0)
		{
			Toast.makeText(getApplicationContext(), "Seleziona almeno un ruolo.", Toast.LENGTH_SHORT).show();
		}

		else {if(i >= 3)// it will allow 2 checkboxes only
		{
			Toast.makeText(getApplicationContext(), "Si possono selezionare al massimo 2 ruoli "
					+ "per ogni giocatore.", Toast.LENGTH_LONG).show();
			gk.setChecked(false);
			dif.setChecked(false);
			cen.setChecked(false);
			att.setChecked(false);
			i--;
		}
		else if(!isNameWrong){
			events = new PlayersData(this);
			try {
				addPlayer(str);
			} finally {
				events.close();
			}
				startActivity(new Intent(this, PlayerActivity.class));
		}
		}
	}

	private void addPlayer(String string) {
		// Insert a new record into the Events data source. 
		// You would do something similar for delete and update. 
		Scanner elements = new Scanner(string);
		SQLiteDatabase db = events.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(NAME, elements.next());
		values.put(VALUE, elements.next());
		values.put(POSITION, elements.next());
		if(elements.hasNext())
		{
			values.put(NUMBER, elements.next());
		}
		elements.close();
		db.insertOrThrow(TABLE_NAME, null, values);
		db.close();
	}

}
