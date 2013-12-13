package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class NamingTeamsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_naming_teams);

		// Get the message from the intent
		Intent intent = getIntent();
		String tour = intent.getStringExtra(TournamentActivity.TOUR_NAME);
		String teams = intent.getStringExtra(TournamentActivity.TEAMS_NUM);

		TextView title = (TextView) findViewById(R.id.title);
		title.setText(tour);		

		TextView[] team = new TextView[15];
		EditText[] team_name = new EditText[15];
		LinearLayout[] linear = new LinearLayout[15];

		
		for (int i = 0; i < 15; i++){
			team[i] = new TextView(this);
			team[i].setPadding(0, 20, 0, 0);
			team[i].setTextSize(22);
			team[i].setText("Squadra/Giocatore " + (i+1) + ":");

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
		confirmButton.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		confirmButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				String[] squads = new String[15];
				for (int i = 0; i < 15; i++){
					squads[i] = nomeTeam[i].getText().toString();
				}
				
				Intent intent = new Intent(NamingTeamsActivity.this, BoardActivity.class);
				intent.putExtra("tour_name", tour_name);
				intent.putExtra("squads", squads);
				intent.putExtra("numbers", numbers);
				startActivity(intent);

			}
			
		});

		LinearLayout buttonLayout = new LinearLayout(this);
		buttonLayout.setOrientation(LinearLayout.VERTICAL);
		buttonLayout.addView(confirmButton);
		buttonLayout.setPadding(15, 15, 0, 15);

		int numberToView = Integer.parseInt(teams);
		LinearLayout verticalLayout = new LinearLayout(this);
		verticalLayout.setOrientation(LinearLayout.VERTICAL);

		for (int i = 0; i < numberToView; i++){
			verticalLayout.addView(linear[i]);
		}
		verticalLayout.addView(buttonLayout);

		ScrollView scroll = new ScrollView(this);
		scroll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		scroll.setFillViewport(true);
		scroll.addView(verticalLayout);

		setContentView(scroll);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.naming_teams, menu);
		return true;
	}

}
