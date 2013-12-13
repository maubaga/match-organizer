package bluemango.matchorganizer;

public class Sunday {
	public byte[] team1, team2;
	public byte repose;
	private static String[] teamName;

	public Sunday(byte[] team1, byte[] team2, byte repose) {
		
		this.team1 = new byte[team1.length];
		this.team2 = new byte[team2.length];
		for(int i = 0; i < team1.length; i++){
			this.team1[i] = team1[i];
			this.team2[i] = team2[i];
		}
		this.repose = repose;
		ShakeTwoArray shakeTwoArray = new ShakeTwoArray(this.team1, this.team2);
		shakeTwoArray.shakeArrays();
	}
	
	public void setStringArray(String[] stringArray){
		teamName = stringArray;
	}
	
	public String toString(){
		String results = "";
		for (int i = 0; i < team1.length; i++){
			results = results + teamName[team1[i]] + " vs " + teamName[team2[i]] + "\n";
		}
		if(repose != -1)
			results = results + "Riposa: " + teamName[repose] + "\n";
		return results;
	}
	
	public String firstTeam(){
		String first = "";
		for (int i = 0; i < team1.length; i++){
			first = first + teamName[team1[i]] + "\n";
		}
		return first;
	}
	
	public String vs(){
		String vs = "";
		for (int i = 0; i < team1.length; i++){
			vs = vs + "vs" + "\n";
		}
		return vs;
	}
	
	public String secondTeam(){
		String second = "";
		for (int i = 0; i < team2.length; i++){
			second = second + teamName[team2[i]] + "\n";
		}
		return second;
	}
	
	public byte getRepose(){
		return repose;
	}

}
