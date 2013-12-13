package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TournamentActivity extends Activity {

	public final static String TOUR_NAME = "bluemango.matchorganizer.NAME";
	public final static String TEAMS_NUM = "bluemango.matchorganizer.TEAMS";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tournament);

		Spinner s = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.numeri, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tournament, menu);
		return true;
	}

	int click_number = 0;

	public void nameTeams(View view) {

		EditText editText = (EditText) findViewById(R.id.tournament);
		String tour = editText.getText().toString();

		if(tour.equals("")){
			Toast.makeText(getBaseContext(), "Devi inserire un nome per il torneo",
					Toast.LENGTH_LONG).show();
			return;
		}
		
		click_number++;

		Spinner editTeams = (Spinner) findViewById(R.id.spinner);
		String teams = editTeams.getSelectedItem().toString();




		TextView[] team = new TextView[15];
		EditText[] team_name = new EditText[15];
		LinearLayout[] linear = new LinearLayout[15];

		for (int i = 0; i < 15; i++){
			team[i] = new TextView(this);
			team[i].setPadding(0, 20, 0, 0);
			team[i].setTextSize(22);
			team[i].setText("Squadra " + (i+1) + ":");

			team_name[i] = new EditText(this);
			//			team_name[i].setWidth(250);
			//			team_name[i].setHeight(70);
			team_name[i].setTextSize(20);
			team_name[i].setHint("Nome squadra");
			team_name[i].setId(i+1);
			team_name[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

			linear[i] = new LinearLayout(this);
			// Not necessary as it's the default but useful to know
			linear[i].setOrientation(LinearLayout.HORIZONTAL);
			linear[i].addView(team[i]);
			linear[i].addView(team_name[i]);
		}

		final EditText[] nomeTeam = team_name;
		final String numbers = teams;
		final String tour_name = tour;
		Button confirmButton = new Button(this);
		confirmButton.setTextSize(25);
		confirmButton.setText("Conferma");
		confirmButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		confirmButton.setBackgroundResource(R.drawable.button_pressed);
		confirmButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				String[] squads = new String[15];
				for (int i = 0; i < 15; i++){
					squads[i] = nomeTeam[i].getText().toString();
				}

				Intent intent = new Intent(TournamentActivity.this, BoardActivity.class);
				intent.putExtra("tour_name", tour_name);
				intent.putExtra("squads", squads);
				intent.putExtra("numbers", numbers);
				startActivity(intent);

			}

		});

		LinearLayout buttonLayout = new LinearLayout(this);
		buttonLayout.setOrientation(LinearLayout.VERTICAL);
		buttonLayout.addView(confirmButton);
		buttonLayout.setPadding(0, 15, 0, 15);
		buttonLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		int numberToView = Integer.parseInt(teams);
		LinearLayout verticalLayout = new LinearLayout(this);
		verticalLayout.setOrientation(LinearLayout.VERTICAL);

		for (int i = 0; i < numberToView; i++){
			verticalLayout.addView(linear[i]);
		}
		verticalLayout.addView(buttonLayout);

		LinearLayout squadsLinear = new LinearLayout(this);
		squadsLinear.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		squadsLinear.setOrientation(LinearLayout.VERTICAL);
		squadsLinear.addView(verticalLayout);

		Button firstButton = (Button) findViewById(R.id.first_confirm);
		firstButton.setText("Aggiorna");;

		LinearLayout biggestLayout = (LinearLayout) findViewById(R.id.biggest_linear);
		
		
		TextView sampleText = new TextView(this);
		sampleText.setId(19);
		sampleText.setPadding(0, 20, 0, 0);
		sampleText.setTextSize(22);
		sampleText.setText("Nuova Squadra");

		if(click_number == 2){
			
			biggestLayout.addView(sampleText);
			
		} else if(click_number == 1){
			biggestLayout.addView(squadsLinear);
		} else if(click_number == 3){
			biggestLayout.removeViewAt(19);
		}
	}
}

