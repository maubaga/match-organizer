package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BoardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board);

		Intent intent = getIntent();
		String tour_name = intent.getStringExtra("tour_name");
		String[] teamName = intent.getStringArrayExtra("squads");
		String numbers = intent.getStringExtra("numbers");
		String typeOfMatch = intent.getStringExtra("typeOfMatch");

		TextView title_name = (TextView) findViewById(R.id.title);

		final int NUMBER = Integer.parseInt(numbers);

		int matchNumber = NUMBER * (NUMBER - 1) / 2;
		int matchForDay = NUMBER / 2;
		int numberOfDay = matchNumber / matchForDay;

		LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
		LinearLayout mainLayout_2 = (LinearLayout) findViewById(R.id.mainLayout_2);

		
		// Linea dopo le partite di andata
		LinearLayout line_5 = new LinearLayout(this);
		line_5.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 1));
		line_5.setOrientation(LinearLayout.HORIZONTAL);
		line_5.setPadding(0, 15, 0, 0);
		line_5.setBackgroundColor(0xFF000000);
		
		if(typeOfMatch.equals("Solo andata")){
			
			Sunday[] dayArray = new GenerateDay(NUMBER).getDayArray();
			ShakeArray shakeArray = new ShakeArray(dayArray);
			shakeArray.shakeSundayArrays();

			dayArray[0].setStringArray(teamName);
			
			for(int i = 0; i < numberOfDay; i++){
				
				//Numero della giornata
				TextView day = new TextView(this);
				day.setTextSize(35);
				day.setTextColor(0xffdc0918);
				day.setGravity(Gravity.LEFT);
				day.setTypeface(null, Typeface.BOLD);
				day.setPadding(10, 0, 0, 20);
				day.setText("GIORNATA " + (i + 1));

				//Contenitore delle partite di una giornata
				LinearLayout linearMatch = new LinearLayout(this);
				linearMatch.setOrientation(LinearLayout.HORIZONTAL);
				linearMatch.setPadding(0, 0, 10, -35);

				//Squadre in casa
				TextView dayMatches1 = new TextView(this);
				dayMatches1.setTextSize(25);
				dayMatches1.setTypeface(null, Typeface.BOLD);
				dayMatches1.setGravity(Gravity.LEFT);
				dayMatches1.setPadding(40, 0, 0, 0);
				dayMatches1.setText(dayArray[i].firstTeam());

				//VS
				TextView vs = new TextView(this);
				vs.setTextSize(25);
				vs.setGravity(Gravity.LEFT);
				vs.setPadding(15, 0, 0, 0);
				vs.setText(dayArray[i].vs());

				//Squadre fuori casa
				TextView dayMatches2 = new TextView(this);
				dayMatches2.setTextSize(25);
				dayMatches2.setGravity(Gravity.LEFT);
				dayMatches2.setTypeface(null, Typeface.BOLD);
				dayMatches2.setPadding(15, 0, 0, 0);
				dayMatches2.setText(dayArray[i].secondTeam());

				//Aggiungo le View
				mainLayout.addView(day);
				linearMatch.addView(dayMatches1);
				linearMatch.addView(vs);
				linearMatch.addView(dayMatches2);
				mainLayout.addView(linearMatch);


				if(dayArray[i].getRepose() == -1){
					continue;
				}
				
				// Linee tra le giornate
				LinearLayout line_2 = new LinearLayout(this);
				line_2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 2));
				line_2.setOrientation(LinearLayout.HORIZONTAL);
				line_2.setPadding(0, 15, 0, 0);
				line_2.setBackgroundColor(0xFF000000);
				
				LinearLayout linearReposeContainer = new LinearLayout(this);
				linearReposeContainer.setOrientation(LinearLayout.VERTICAL);

				LinearLayout linearRepose = new LinearLayout(this);
				linearRepose.setOrientation(LinearLayout.HORIZONTAL);
				linearRepose.setPadding(0, -25, 0, 10);

				TextView repose = new TextView(this);
				repose.setTextSize(25);
				repose.setGravity(Gravity.LEFT);
				repose.setPadding(35, 0, 0, 20);
				repose.setText("Riposa: ");

				TextView reposeTeam = new TextView(this);
				reposeTeam.setTextSize(25);
				reposeTeam.setGravity(Gravity.LEFT);
				reposeTeam.setTypeface(null, Typeface.BOLD);
				reposeTeam.setText(teamName[dayArray[i].getRepose()]);
				
				linearReposeContainer.addView(linearRepose);
				linearRepose.addView(repose);
				linearRepose.addView(reposeTeam);
				linearReposeContainer.addView(line_2);

				mainLayout.addView(linearReposeContainer);
				
			}
		} else {
			
			Sunday[] dayArray = new GenerateDay(NUMBER).getDayArray();
			ShakeArray shakeArray = new ShakeArray(dayArray);
			shakeArray.shakeSundayArrays();

			dayArray[0].setStringArray(teamName);
			
			mainLayout_2.addView(line_5);
			
			for(int i = 0; i < numberOfDay; i++){
				
				//Numero della giornata
				TextView day = new TextView(this);
				day.setTextSize(35);
				day.setTextColor(0xffdc0918);
				day.setGravity(Gravity.LEFT);
				day.setTypeface(null, Typeface.BOLD);
				day.setPadding(10, 0, 0, 20);
				day.setText("GIORNATA " + (i + 1));
				
				//Numero della giornata di ritorno
				TextView day_2 = new TextView(this);
				day_2.setTextSize(35);
				day_2.setTextColor(0xffdc0918);
				day_2.setGravity(Gravity.LEFT);
				day_2.setTypeface(null, Typeface.BOLD);
				day_2.setPadding(10, 0, 0, 20);
				day_2.setText("GIORNATA " + (numberOfDay + i));

				//Contenitore delle partite di una giornata di andata
				LinearLayout linearMatch = new LinearLayout(this);
				linearMatch.setOrientation(LinearLayout.HORIZONTAL);
				linearMatch.setPadding(0, 0, 10, -35);
				
				//Contenitore delle partite di una giornata di ritorno
				LinearLayout linearMatch_2 = new LinearLayout(this);
				linearMatch_2.setOrientation(LinearLayout.HORIZONTAL);
				linearMatch_2.setPadding(0, 0, 10, -35);

				//Squadre in casa
				TextView dayMatches1 = new TextView(this);
				dayMatches1.setTextSize(25);
				dayMatches1.setTypeface(null, Typeface.BOLD);
				dayMatches1.setGravity(Gravity.LEFT);
				dayMatches1.setPadding(40, 0, 0, 0);
				dayMatches1.setText(dayArray[i].firstTeam());

				//VS
				TextView vs = new TextView(this);
				vs.setTextSize(25);
				vs.setGravity(Gravity.LEFT);
				vs.setPadding(15, 0, 0, 0);
				vs.setText(dayArray[i].vs());

				//Squadre fuori casa
				TextView dayMatches2 = new TextView(this);
				dayMatches2.setTextSize(25);
				dayMatches2.setGravity(Gravity.LEFT);
				dayMatches2.setTypeface(null, Typeface.BOLD);
				dayMatches2.setPadding(15, 0, 0, 0);
				dayMatches2.setText(dayArray[i].secondTeam());

				//Aggiungo le View dell'andata
				mainLayout.addView(day);
				linearMatch.addView(dayMatches1);
				linearMatch.addView(vs);
				linearMatch.addView(dayMatches2);
				mainLayout.addView(linearMatch);
				
				//Aggiungo le View del ritorno
				mainLayout_2.addView(day_2);
				linearMatch_2.addView(dayMatches2);
				linearMatch_2.addView(vs);
				linearMatch_2.addView(dayMatches1);
				mainLayout_2.addView(linearMatch_2);


				if(dayArray[i].getRepose() == -1){
					continue;
				}
				
				// Linee tra le giornate
				LinearLayout line_2 = new LinearLayout(this);
				line_2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 2));
				line_2.setOrientation(LinearLayout.HORIZONTAL);
				line_2.setPadding(0, 15, 0, 0);
				line_2.setBackgroundColor(0xFF000000);

				LinearLayout linearRepose = new LinearLayout(this);
				linearRepose.setOrientation(LinearLayout.HORIZONTAL);
				linearRepose.setPadding(0, -25, 0, 10);

				TextView repose = new TextView(this);
				repose.setTextSize(25);
				repose.setGravity(Gravity.LEFT);
				repose.setPadding(35, 0, 0, 20);
				repose.setText("Riposa: ");

				TextView reposeTeam = new TextView(this);
				reposeTeam.setTextSize(25);
				reposeTeam.setGravity(Gravity.LEFT);
				reposeTeam.setTypeface(null, Typeface.BOLD);
				reposeTeam.setText(teamName[dayArray[i].getRepose()]);

				linearRepose.addView(repose);
				linearRepose.addView(reposeTeam);

				mainLayout.addView(linearRepose);
				mainLayout.addView(line_2);
			}
		}
		title_name.setText(tour_name);
	}

}
