package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
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

		//Spinner per selezionare il numero di squadre
		Spinner s = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.numeri, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);	
		
		//Spinner per selezionare il numero di incontri
		Spinner t = (Spinner) findViewById(R.id.match_type);
		ArrayAdapter Aadapter = ArrayAdapter.createFromResource(this, R.array.tipi, android.R.layout.simple_spinner_item);
		Aadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		t.setAdapter(Aadapter);	
		
	}
	
	public void nameTeams(View view) {

		//EditText per avere il nome del torneo
		EditText tour_title = (EditText) findViewById(R.id.tournament);
		String tour = tour_title.getText().toString();

		if(tour.equals("")){
			Toast.makeText(getBaseContext(), "Devi inserire un nome per il torneo",
					Toast.LENGTH_LONG).show();
			return;
		}

		//Spinner per avere il numero di squadre
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
		
		final int numberToView = Integer.parseInt(teams);
		
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
				
				for (int i = 0; i < numberToView; i++){
					if(squads[i].equals("")){
						Toast.makeText(getBaseContext(), "Devi inserire un nome per la Squadra" + (i + 1),
								Toast.LENGTH_LONG).show();
						return;
					}
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
		buttonLayout.setPadding(60, 15, 60, 15);
		buttonLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		LinearLayout verticalLayout = new LinearLayout(this);
		verticalLayout.setOrientation(LinearLayout.VERTICAL);
		verticalLayout.setPadding(0, 30, 0, 0);
		
		Button firstButton = (Button) findViewById(R.id.first_confirm);
		firstButton.setVisibility(View.GONE);
		
		TextView line = new TextView(this);
		line.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 5));
		line.setBackgroundColor(0xFF000000);
		verticalLayout.addView(line);

		for (int i = 0; i < numberToView; i++){
			verticalLayout.addView(linear[i]);
		}
		verticalLayout.addView(buttonLayout);

		LinearLayout biggestLayout = (LinearLayout) findViewById(R.id.biggest_linear);
		biggestLayout.addView(verticalLayout);
	}
}

