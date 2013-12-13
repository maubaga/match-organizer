package bluemango.matchorganizer;

public class GenerateDay {

	int numberOfTeam;
	Sunday[] dayArray;
	//Match da assegnare alle giornate
	byte[] first3 =  {0, 1, 0};
	byte[] second3 = {1, 2, 2};
	byte[] repose3 = {2, 0, 1};
	
	byte[] first4 =  {0, 2, 1, 0, 1, 0};
	byte[] second4 = {1, 3, 2, 3, 3, 2};
	
	byte[] first5 =  {1, 2, 0, 3, 0, 1, 0, 1, 0, 2};
	byte[] second5 = {3, 4, 2, 4, 3, 4, 4, 2, 1, 3};
	byte[] repose5 = {0, 1, 2, 3, 4};
	
	byte[] first6 =  {3, 0, 1, 1, 0, 3, 0, 5, 3, 0, 2, 1, 4, 0, 1};
	byte[] second6 = {2, 4, 5, 4, 2, 5, 1, 2, 4, 5, 4, 3, 5, 3, 2};
	
	byte[] first7 =  {0, 3, 5, 1, 4, 6, 2, 3, 5, 0, 1, 4, 2, 3, 6, 0, 1, 5, 2, 4, 6};
	byte[] second7 = {1, 6, 4, 5, 3, 2, 4, 1, 0, 3, 2, 6, 0, 5, 1, 6, 4, 2, 3, 0, 5};
	byte[] repose7 = {2, 0, 6, 5, 4, 3, 1};
	
	byte[] first8 =  {0, 2, 3, 5, 1, 4, 6, 7, 2, 3, 5, 6, 0, 1, 4, 7, 2, 3, 4, 6, 0, 1, 3, 5, 2, 4, 6, 7};
	byte[] second8 = {1, 7, 6, 4, 5, 3, 2, 0, 4, 1, 0, 7, 3, 2, 6, 5, 0, 5, 7, 1, 6, 4, 7, 2, 3, 0, 5, 1};

	byte[] first9 =  {0, 1, 3, 4, 2, 6, 7, 8, 0, 1, 3, 7, 2, 4, 5, 8, 0, 2, 3, 7, 4, 5, 6, 8, 0, 2, 7, 8, 0, 1, 4, 5, 3, 6, 7, 8};
	byte[] second9 = {7, 2, 6, 5, 0, 4, 3, 1, 8, 5, 2, 6, 7, 1, 0, 3, 4, 6, 5, 8, 3, 7, 1, 2, 1, 5, 4, 6, 6, 3, 2, 8, 0, 5, 1, 4};
	byte[] repose9 = {8, 5, 4, 6, 1, 0, 3, 7, 2};
	
	byte[] first10 =  {0, 1, 3, 4, 9, 2, 6, 7, 8, 5, 0, 1, 3, 7, 9, 2, 4, 5, 8, 6, 0, 2, 3, 7, 1, 4, 5, 6, 8, 9, 0, 2, 7, 8, 3, 0, 1, 4, 5, 9, 3, 6, 7, 8, 2};
	byte[] second10 = {7, 2, 6, 5, 8, 0, 4, 3, 1, 9, 8, 5, 2, 6, 4, 7, 1, 0, 3, 9, 4, 6, 5, 8, 9, 3, 7, 1, 2, 0, 1, 5, 4, 6, 9, 6, 3, 2, 8, 7, 0, 5, 1, 4, 9};
	
	byte[] first11 =  {1, 10, 2, 5, 6, 0, 3, 4,  7, 9, 10, 2, 6, 8, 9,  0, 1, 3, 4, 7, 2, 5,  6, 8, 9, 0, 1, 10, 4, 7,  2, 3, 5, 8, 9, 0, 1, 10, 4, 6, 2, 3, 4, 5,  9, 1, 2, 6, 7, 8, 0,  3, 4, 5, 9};
	byte[] second11 = {7,  4, 9, 0, 3, 1, 8, 6, 10, 5,  1, 3, 7, 4, 0, 10, 6, 5, 2, 8, 7, 4, 10, 1, 3, 6, 2,  8, 9, 5, 10, 0, 1, 6, 7, 8, 9,  5, 3, 2, 8, 7, 0, 6, 10, 3, 0, 9, 4, 5, 7, 10, 1, 2, 8};
	byte[] repose11 = {8, 2, 5, 9, 0, 3, 4, 7, 1, 10, 6};
	
	byte[] first12 =  {1, 10, 2, 5, 6,  8, 0, 11, 3, 4,  7, 9, 10, 2, 5, 6, 8, 9, 0, 1, 11, 3, 4, 7, 11, 2, 5, 6, 8, 9, 0, 1, 10, 3, 4, 7, 11, 2, 3, 5, 8, 9, 0, 1, 10, 4, 6, 7, 11, 2, 3, 4, 5, 9, 1, 10, 2, 6, 7, 8, 0, 11, 3, 4, 5, 9};
	byte[] second12 = {7,  4, 9, 0, 3, 11, 1,  2, 8, 6, 10, 5, 1, 3, 11, 7 ,4, 0, 10, 6, 9, 5, 2, 8, 0, 7, 4, 10, 1, 3, 6, 2, 8, 11, 9, 5, 4, 10, 0, 1, 6, 7, 8, 9, 5, 3, 2, 11, 1, 8, 7, 0, 6, 10, 3, 11, 0, 9, 4, 5, 7, 6, 10, 1, 2, 8};
	
	byte[] first13 =  {10, 12, 4, 7, 8, 9, 0, 1, 2, 3, 5, 6, 12, 4, 6, 7, 8, 9, 0, 1, 10, 11, 2, 3, 11, 12, 4, 6, 7, 8, 0, 1, 10, 2, 5, 9, 1, 11, 12, 4, 6, 7, 0, 10, 2, 3, 5, 8, 1, 11, 12, 4, 5, 6, 0, 10, 2, 3, 8, 9, 0, 1, 11, 12, 5, 6, 10, 3, 4, 7, 8, 9, 0, 1, 11, 2, 5, 6};
	byte[] second13 = {3, 2, 11, 1, 5, 0, 8, 4, 10, 9, 7, 12, 11, 5, 2, 0, 3, 10, 4, 12, 8, 6, 9, 7, 2, 5, 3, 1, 10, 9, 12, 11, 4, 8, 6, 7, 2, 5, 3, 9, 0, 8, 11, 12, 7, 6, 1, 4, 0, 3, 9, 7, 2, 10, 5, 11, 4, 1, 12, 6, 2, 10, 9, 7, 3, 8, 5, 0, 12, 6, 11, 1, 10, 8, 7, 3, 9, 4};
	byte[] repose13 = {6, 11, 1, 5, 0, 3, 10, 9, 8, 7, 4, 2, 12};
	
	byte[] first14 =  {10, 12, 13, 4, 7, 8, 9, 0, 1, 11, 2, 3, 5, 6, 12, 13, 4, 6, 7, 8, 9, 0, 1, 10, 11, 2, 3, 5, 11, 12, 13, 4, 6, 7, 8, 0, 1, 10, 2, 3, 5, 9, 1, 11, 12, 13, 4, 6, 7, 0, 10, 2, 3, 5, 8, 9, 1, 11, 12, 13, 4, 5, 6, 0, 10, 2, 3, 7, 8, 9, 0, 1, 11, 12, 13, 5, 6, 10, 13, 3, 4, 7, 8, 9, 0, 1, 11, 12, 2, 5, 6};
	byte[] second14 = {3, 2, 6, 11, 1, 5, 0, 8, 4, 13, 10, 9, 7, 12, 11, 1, 5, 2, 0, 3, 10, 4, 12, 8, 6, 9, 7, 13, 2, 5, 0, 3, 1, 10, 9, 12, 11, 4, 8, 13, 6, 7, 2, 5, 3, 10, 9, 0, 8, 11, 12, 7, 6, 1, 4, 13, 0, 3, 9, 8, 7, 2, 10, 5, 11, 4, 1, 13, 12, 6, 2, 10, 9, 7, 4, 3, 8, 5, 2, 0, 12, 6, 11, 1, 10, 8, 7, 13, 3, 9, 4};
	
	byte[] first15 =  {0, 2, 4, 6, 8, 10, 12, 11, 13, 7, 1, 3, 9, 5, 0, 7, 2, 6, 8, 10, 14, 13, 0, 1, 3, 9, 12, 14, 11, 2, 8, 9, 5, 10, 12, 13, 7, 1, 4, 6, 5, 14, 11, 0, 2, 1, 8, 9, 12, 11, 13, 7, 4, 6, 8, 5, 0, 2, 1, 3, 9, 12, 14, 11, 2, 3, 4, 6, 5, 10, 13, 0, 1, 8, 9, 12, 14, 11, 7, 3, 4, 6, 5, 10, 13, 0, 1, 4, 8, 9, 14, 11, 7, 2, 1, 3, 6, 5, 13, 4, 8, 9, 10, 12, 14};
	byte[] second15 = {1, 3, 5, 7, 9, 11, 13, 6, 2, 10, 14, 4, 12, 0, 9, 11, 1, 5, 13, 3, 12, 4, 10, 7, 5, 11, 8, 2, 14, 4, 3, 13, 7, 6, 0, 0, 8, 12, 10, 2, 11, 9, 3, 14, 7, 6, 4, 10, 5, 2, 14, 3, 1, 12, 0, 9, 4, 5, 13, 6, 7, 10, 8, 13, 12, 9, 14, 0, 1, 8, 10, 3, 11, 2, 6, 4, 7, 0, 12, 1, 9, 8, 13, 14, 3, 7, 10, 6, 11, 2, 5, 4, 13, 0, 8, 12, 14, 10, 6, 7, 5, 1, 2, 11, 3};
	byte[] repose15 = {14, 8, 4, 6, 1, 3, 13, 10, 11, 7, 5, 2, 12, 9, 0};

	
	
	public GenerateDay(int numberOfTeam) {
		this.numberOfTeam = numberOfTeam;
	}
	
	public Sunday[] getDayArray(){
		int totalMatchNumber = numberOfTeam * (numberOfTeam - 1) / 2;
		int matchForDay = numberOfTeam / 2;
		int numberOfDays = totalMatchNumber / matchForDay;
		
		ShakeTwoArray shakeTwoArray;
		byte[] matches1 = new byte[matchForDay];
		byte[] matches2 = new byte[matchForDay];
		
		int count;
		
		switch(numberOfTeam){
		
		case 3:
			shakeTwoArray = new ShakeTwoArray(first3, second3);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first3.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first3[i];
				matches2[mod] = second3[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose3[count]);
					count++;
				}	
			}
			break;
		
		case 4:
			shakeTwoArray = new ShakeTwoArray(first4, second4);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first4.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first4[i];
				matches2[mod] = second4[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2,(byte) -1);
					count++;
				}		
			}
			break;
			
		case 5:
			shakeTwoArray = new ShakeTwoArray(first5, second5);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first5.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first5[i];
				matches2[mod] = second5[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose5[count]);
					count++;
				}	
			}
			break;
			
		case 6:
			shakeTwoArray = new ShakeTwoArray(first6, second6);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first6.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first6[i];
				matches2[mod] = second6[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2,(byte) -1);
					count++;
				}		
			}
			break;
			
		case 7:
			shakeTwoArray = new ShakeTwoArray(first7, second7);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first7.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first7[i];
				matches2[mod] = second7[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose7[count]);
					count++;
				}	
			}
			break;
			
		case 8:
			shakeTwoArray = new ShakeTwoArray(first8, second8);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first8.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first8[i];
				matches2[mod] = second8[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2,(byte) -1);
					count++;
				}		
			}
			break;
			
		case 9:
			shakeTwoArray = new ShakeTwoArray(first9, second9);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first9.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first9[i];
				matches2[mod] = second9[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose9[count]);
					count++;
				}	
			}
			break;
			
		case 10:
			shakeTwoArray = new ShakeTwoArray(first10, second10);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first10.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first10[i];
				matches2[mod] = second10[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2,(byte) -1);
					count++;
				}		
			}
			break;
			
		case 11:
			shakeTwoArray = new ShakeTwoArray(first11, second11);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first11.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first11[i];
				matches2[mod] = second11[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose11[count]);
					count++;
				}	
			}
			break;
			
		case 12:
			shakeTwoArray = new ShakeTwoArray(first12, second12);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first12.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first12[i];
				matches2[mod] = second12[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2,(byte) -1);
					count++;
				}		
			}
			break;
			
		case 13:
			shakeTwoArray = new ShakeTwoArray(first13, second13);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first13.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first13[i];
				matches2[mod] = second13[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose13[count]);
					count++;
				}	
			}
			break;
			
		case 14:
			shakeTwoArray = new ShakeTwoArray(first14, second14);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first14.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first14[i];
				matches2[mod] = second14[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2,(byte) -1);
					count++;
				}		
			}
			break;
			
		case 15:
			shakeTwoArray = new ShakeTwoArray(first15, second15);
			shakeTwoArray.shakeColumns();
			dayArray = new Sunday[numberOfDays];
			count = 0;
			for (int i = 0; i < first15.length; i++){
				int mod = i % matchForDay;
				matches1[mod] = first15[i];
				matches2[mod] = second15[i];
				if(mod == matchForDay - 1){
					dayArray[count] = new Sunday(matches1, matches2, repose15[count]);
					count++;
				}	
			}
			break;
		}
		return dayArray;
	}
	
	
	

}
