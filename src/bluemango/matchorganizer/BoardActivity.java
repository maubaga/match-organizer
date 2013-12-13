package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
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
		
		TextView title_name = (TextView) findViewById(R.id.title);
		
		final int NUMBER = Integer.parseInt(numbers);
		
		int matchNumber = NUMBER * (NUMBER - 1) / 2;
		int matchForDay = NUMBER / 2;
		int numberOfDay = matchNumber / matchForDay;
		
		Sunday[] dayArray = new GenerateDay(NUMBER).getDayArray();
		ShakeArray shakeArray = new ShakeArray(dayArray);
		shakeArray.shakeSundayArrays();

		dayArray[0].setStringArray(teamName);
		
		LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);		
		for(int i = 0; i < numberOfDay; i++){
			TextView day = new TextView(this);
			day.setTextSize(35);
			day.setTextColor(0xffdc0918);
			day.setGravity(Gravity.LEFT);
			day.setTypeface(null, Typeface.BOLD);
			day.setPadding(10, 0, 0, 20);
			day.setText("GIORNATA " + (i + 1));
			
			LinearLayout linearMatch = new LinearLayout(this);
			linearMatch.setOrientation(LinearLayout.HORIZONTAL);
			linearMatch.setPadding(0, 0, 10, -35);
			
			TextView dayMatches1 = new TextView(this);
			dayMatches1.setTextSize(25);
			dayMatches1.setTypeface(null, Typeface.BOLD);
			dayMatches1.setGravity(Gravity.LEFT);
			dayMatches1.setPadding(40, 0, 0, 0);
			dayMatches1.setText(dayArray[i].firstTeam());
			
			TextView vs = new TextView(this);
			vs.setTextSize(25);
			vs.setGravity(Gravity.LEFT);
			vs.setPadding(15, 0, 0, 0);
			vs.setText(dayArray[i].vs());
			
			TextView dayMatches2 = new TextView(this);
			dayMatches2.setTextSize(25);
			dayMatches2.setGravity(Gravity.LEFT);
			dayMatches2.setTypeface(null, Typeface.BOLD);
			dayMatches2.setPadding(15, 0, 0, 0);
			dayMatches2.setText(dayArray[i].secondTeam());
						
			
			mainLayout.addView(day);
			linearMatch.addView(dayMatches1);
			linearMatch.addView(vs);
			linearMatch.addView(dayMatches2);
			mainLayout.addView(linearMatch);
			
			
			if(dayArray[i].getRepose() == -1){
				continue;
			}
			
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
		}
		
		
		title_name.setText(tour_name);
	}
}
