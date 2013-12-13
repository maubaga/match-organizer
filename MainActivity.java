package com.example.squadre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	public final static String TOUR_NAME = "com.example.squadre.NAME";
	public final static String TEAMS_NUM = "com.example.squadre.TEAMS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Spinner s = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.numeri, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
    public void nameTeams(View view) {
    	Intent intent = new Intent(this, NamingTeamsActivity.class);
    	
        EditText editText = (EditText) findViewById(R.id.tournament);
        String tour = editText.getText().toString();
        intent.putExtra(TOUR_NAME, tour);
        
//        Spinner editValue = (Spinner) findViewById(R.id.edit_value);
//		str = str + " " + editValue.getSelectedItem().toString();
        
        Spinner editTeams = (Spinner) findViewById(R.id.spinner);
        String teams = editTeams.getSelectedItem().toString();
        intent.putExtra(TEAMS_NUM, teams);
        
        startActivity(intent);
    }

}
