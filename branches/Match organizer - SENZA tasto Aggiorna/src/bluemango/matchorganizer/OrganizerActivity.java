package bluemango.matchorganizer;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class OrganizerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_organizer);
	}
	
	public void goPlayerSelectionV3(View view) {
    	startActivity(new Intent(this, PlayerSelectionV3Activity.class));
    }
	
	public void goPlayerSelectionV5(View view) {
    	startActivity(new Intent(this, PlayerSelectionV5Activity.class));
    }
	
	public void goPlayerSelectionV6(View view) {
    	startActivity(new Intent(this, PlayerSelectionV6Activity.class));
    }
	
	public void goPlayerSelectionV7(View view) {
    	startActivity(new Intent(this, PlayerSelectionV7Activity.class));
    }
	
	public void goPlayerSelectionV11(View view) {
    	startActivity(new Intent(this, PlayerSelectionV11Activity.class));
    }
	
	public void onBackPressed(){

		this.startActivity(new Intent(this,MainActivity.class)); 

	}

}
