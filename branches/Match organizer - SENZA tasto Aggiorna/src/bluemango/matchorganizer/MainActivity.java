package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void goOrganizer(View view) {
    	startActivity(new Intent(this, OrganizerActivity.class));
    }
    
    public void goPlayers(View view) {
    	startActivity(new Intent(this, PlayerActivity.class));
    }
    
    public void goTournament(View view) {
    	startActivity(new Intent(this, TournamentActivity.class));
    }
    
    public void goGuide(View view) {
    	startActivity(new Intent(this, GuideActivity.class));
    }
    
    public void goInfo(View view) {
    	startActivity(new Intent(this, InfoActivity.class));
    }
    
    public void goLog(View view) {
    	startActivity(new Intent(this, LogActivity.class));
    }
    
}
