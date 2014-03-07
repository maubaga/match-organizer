package bluemango.matchorganizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FlagActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flag);
	}

		public void sendFlag(View view){
			
			EditText edit_reason = (EditText) findViewById(R.id.reason);
			
			String reason = edit_reason.getText().toString();
			
			Intent i = new Intent(Intent.ACTION_SEND);
			i.setType("message/rfc822");
			i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"matteo.franzosi@hotmail.it"});
			i.putExtra(Intent.EXTRA_SUBJECT, "Bug report");
			i.putExtra(Intent.EXTRA_TEXT   , reason);
			try {
			    startActivity(Intent.createChooser(i, "Invia email con:"));
			} catch (android.content.ActivityNotFoundException ex) {
			    Toast.makeText(FlagActivity.this, "Non è presente nessuna applicazione per inviare email.", Toast.LENGTH_LONG).show();
			}
			
		}

}
