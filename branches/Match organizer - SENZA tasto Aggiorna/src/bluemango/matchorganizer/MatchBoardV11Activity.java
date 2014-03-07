package bluemango.matchorganizer;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MatchBoardV11Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_match_board);

		final int TOT = 22; //Numero totale dei giocatori
		
		//Visualizzazione del nome, valore e ruolo di ogni giocatore
		TextView[] player = new TextView[TOT];
		TextView[] value = new TextView[TOT];
		TextView[] position = new TextView[TOT];

		Intent intent = getIntent();
		String[] players = intent.getStringArrayExtra("names");
		String[] str_values = intent.getStringArrayExtra("values");
		String[] positions = intent.getStringArrayExtra("positions");
		Double[] values = new Double[TOT];

		//Conversione valori in Double
		for(int i = 0; i < TOT; i++){

			String str = "" + str_values[i];
			double val = Double.parseDouble(str);
			values[i] = val;			

		}

		//Ordinamento dei giocatori in base al valore
		for(int i = 0; i < TOT - 1; i++){

			for(int j = i + 1; j < TOT; j++){

				if(values[j] > values[i]){

					double tmp = values[i];
					values[i] = values[j];
					values[j] = tmp;

					String tmp_name = players[i];
					players[i] = players[j];
					players[j] = tmp_name;

					String tmp_pos = positions[i];
					positions[i] = positions[j];
					positions[j] = tmp_pos;

				}

			}

		}

		LinearLayout main_name_t1 = (LinearLayout)findViewById(R.id.main_name_t1);
		LinearLayout main_value_t1 = (LinearLayout)findViewById(R.id.main_value_t1);
		LinearLayout main_position_t1 = (LinearLayout)findViewById(R.id.main_pos_t1);
		LinearLayout main_name_t2 = (LinearLayout)findViewById(R.id.main_name_t2);
		LinearLayout main_value_t2 = (LinearLayout)findViewById(R.id.main_value_t2);
		LinearLayout main_position_t2 = (LinearLayout)findViewById(R.id.main_pos_t2);

		//		LinearLayout main_name_dif = (LinearLayout)findViewById(R.id.main_name_dif);
		//		LinearLayout main_value_dif = (LinearLayout)findViewById(R.id.main_value_dif);
		//		LinearLayout main_position_dif = (LinearLayout)findViewById(R.id.main_pos_dif);
		//		LinearLayout main_name_att = (LinearLayout)findViewById(R.id.main_name_att);
		//		LinearLayout main_value_att = (LinearLayout)findViewById(R.id.main_value_att);
		//		LinearLayout main_position_att = (LinearLayout)findViewById(R.id.main_pos_att);

		//		for(int i = 0; i < 10; i++){
		//
		//			String str_name = "" + players[i];
		//			String str_val = "" + values[i];
		//			String str_pos = "" + positions[i];
		//
		//			if(str_pos.equals("Por") || str_pos.equals("Dif") || str_pos.equals("Por/Dif") || str_pos.equals("Dif/Cen")){
		//
		//				player[i] = new TextView(this);
		//				player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				player[i].setTextSize(20);
		//				player[i].setText(str_name);
		//
		//				value[i] = new TextView(this);
		//				value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				value[i].setTextSize(20);
		//				value[i].setText(str_val);
		//
		//				position[i] = new TextView(this);
		//				position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				position[i].setTextSize(20);
		//				position[i].setText(str_pos);
		//
		//				main_name_dif.addView(player[i]);
		//				main_value_dif.addView(value[i]);
		//				main_position_dif.addView(position[i]);
		//			}
		//
		//			if(str_pos.equals("Cen") || str_pos.equals("Att") || str_pos.equals("Cen/Att")){
		//
		//				player[i] = new TextView(this);
		//				player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				player[i].setTextSize(20);
		//				player[i].setText(str_name);
		//
		//				value[i] = new TextView(this);
		//				value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				value[i].setTextSize(20);
		//				value[i].setText(str_val);
		//
		//				position[i] = new TextView(this);
		//				position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				position[i].setTextSize(20);
		//				position[i].setText(str_pos);
		//
		//				main_name_att.addView(player[i]);
		//				main_value_att.addView(value[i]);
		//				main_position_att.addView(position[i]);
		//			}
		//
		//		}

		//Conteggio dei giocatori in attacco e in difesa
		int idx_dif = 0;
		int idx_att = 0;
		for(int i = 0; i < TOT; i++){

			String str_pos = "" + positions[i];

			if(str_pos.equals("Por") || str_pos.equals("Dif") || str_pos.equals("Por/Dif") || str_pos.equals("Dif/Cen") || str_pos.equals("Por/Att")){

				idx_dif++;
			}

			if(str_pos.equals("Cen") || str_pos.equals("Att") || str_pos.equals("Cen/Att")){

				idx_att++;
			}

		}

		String[] new_players_dif = new String[idx_dif];
		Double[] new_values_dif = new Double[idx_dif];
		String[] new_positions_dif = new String[idx_dif];
		String[] new_players_att = new String[idx_att];
		Double[] new_values_att = new Double[idx_att];
		String[] new_positions_att = new String[idx_att];

		String[] total_players = new String[10];
		Double[] total_values = new Double[10];
		String[] total_positions = new String[10];

		//Divisione dei giocatori tra attacco e difesa
		int dif = 0;
		int att = 0;

		for(int i = 0; i < TOT; i++){

			String str_pos = "" + positions[i];

			if(str_pos.equals("Por") || str_pos.equals("Dif") || str_pos.equals("Por/Dif") || str_pos.equals("Dif/Cen") || str_pos.equals("Por/Att")){

				new_players_dif[dif] = players[i];
				new_values_dif[dif] = values[i];
				new_positions_dif[dif] = positions[i];

				dif++;
			}

			if(str_pos.equals("Cen") || str_pos.equals("Att") || str_pos.equals("Cen/Att")){

				new_players_att[att] = players[i];
				new_values_att[att] = values[i];
				new_positions_att[att] = positions[i];

				att++;
			}

		}

		//Unione dei due array in uno solo. L'array degli attaccanti è copiato in modo inverso cioè dal più scarso.
		int idx_dif2 = idx_dif;

		for(int i = 0; i < idx_dif; i++){

			total_players[i] = new_players_dif[i];
			total_values[i] = new_values_dif[i];
			total_positions[i] = new_positions_dif[i];

		}

		for(int i = idx_att - 1; i >= 0; i--){

			total_players[idx_dif2] = new_players_att[i];
			total_values[idx_dif2] = new_values_att[i];
			total_positions[idx_dif2] = new_positions_att[i];

			idx_dif2++;

		}
		
		//Divisione e visualizzazione dei giocatori
		Boolean swap = true;

		for(int i = 0; i < TOT; i++){

			String str_name = "" + total_players[i];
			String str_val = "" + total_values[i];
			String str_pos = "" + total_positions[i];

			if(swap){

				if(i % 2 == 0){
					player[i] = new TextView(this);
					player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					player[i].setTextSize(20);
					player[i].setText(str_name);

					value[i] = new TextView(this);
					value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					value[i].setTextSize(20);
					value[i].setText(str_val);

					position[i] = new TextView(this);
					position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					position[i].setTextSize(20);
					position[i].setText(str_pos);

					main_name_t1.addView(player[i]);
					main_value_t1.addView(value[i]);
					main_position_t1.addView(position[i]);

				} else {

					player[i] = new TextView(this);
					player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					player[i].setTextSize(20);
					player[i].setText(str_name);

					value[i] = new TextView(this);
					value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					value[i].setTextSize(20);
					value[i].setText(str_val);

					position[i] = new TextView(this);
					position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					position[i].setTextSize(20);
					position[i].setText(str_pos);

					main_name_t2.addView(player[i]);
					main_value_t2.addView(value[i]);
					main_position_t2.addView(position[i]);

					if(swap){
						
						swap = false;
						
					} else {
						
						swap = true;
						
					}
					
				}
				
			} else {
				
				if(i % 2 == 0){
					player[i] = new TextView(this);
					player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					player[i].setTextSize(20);
					player[i].setText(str_name);

					value[i] = new TextView(this);
					value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					value[i].setTextSize(20);
					value[i].setText(str_val);

					position[i] = new TextView(this);
					position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					position[i].setTextSize(20);
					position[i].setText(str_pos);

					main_name_t2.addView(player[i]);
					main_value_t2.addView(value[i]);
					main_position_t2.addView(position[i]);

				} else {

					player[i] = new TextView(this);
					player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					player[i].setTextSize(20);
					player[i].setText(str_name);

					value[i] = new TextView(this);
					value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					value[i].setTextSize(20);
					value[i].setText(str_val);

					position[i] = new TextView(this);
					position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
					position[i].setTextSize(20);
					position[i].setText(str_pos);

					main_name_t1.addView(player[i]);
					main_value_t1.addView(value[i]);
					main_position_t1.addView(position[i]);
					
					if(swap){
						
						swap = false;
						
					} else {
						
						swap = true;
						
					}

				}
				
			}

		}

		//		for(int i = 0; i < 10; i++){
		//
		//			String str_name = "" + new_players_att[i];
		//			String str_val = "" + new_values_att[i];
		//			String str_pos = "" + new_positions_att[i];
		//
		//			if(i % 2 == 0){
		//				player[i] = new TextView(this);
		//				player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				player[i].setTextSize(20);
		//				player[i].setText(str_name);
		//
		//				value[i] = new TextView(this);
		//				value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				value[i].setTextSize(20);
		//				value[i].setText(str_val);
		//
		//				position[i] = new TextView(this);
		//				position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				position[i].setTextSize(20);
		//				position[i].setText(str_pos);
		//
		//				main_name_t1.addView(player[i]);
		//				main_value_t1.addView(value[i]);
		//				main_position_t1.addView(position[i]);
		//
		//			} else {
		//
		//				player[i] = new TextView(this);
		//				player[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				player[i].setTextSize(20);
		//				player[i].setText(str_name);
		//
		//				value[i] = new TextView(this);
		//				value[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				value[i].setTextSize(20);
		//				value[i].setText(str_val);
		//
		//				position[i] = new TextView(this);
		//				position[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		//				position[i].setTextSize(20);
		//				position[i].setText(str_pos);
		//
		//				main_name_t2.addView(player[i]);
		//				main_value_t2.addView(value[i]);
		//				main_position_t2.addView(position[i]);
		//
		//			}
		//
		//		}

	}
	
	public void onBackPressed(){

		this.startActivity(new Intent(this,PlayerSelectionV11Activity.class)); 

	}

}
