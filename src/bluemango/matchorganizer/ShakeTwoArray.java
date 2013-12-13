package bluemango.matchorganizer;


import java.util.Random;

public class ShakeTwoArray {
	byte[] firstArray, secondArray;

	public ShakeTwoArray(byte[] first, byte[] second){
		firstArray = first;
		secondArray = second;
	}
	
	public void shakeArrays(){
		int length = firstArray.length;
		Random random = new Random();
		for(int i = 0; i < length; i++){
			int newIndex = random.nextInt(length);
			byte tempFirst = firstArray[newIndex];
			byte tempSecond = secondArray[newIndex];
			firstArray[newIndex] = firstArray[i];
			secondArray[newIndex] = secondArray[i];
			firstArray[i] = tempFirst;
			secondArray[i] = tempSecond;
		}
	}
	
	public void shakeColumns(){
		Random random = new Random();
		for(int i = 0; i < firstArray.length; i++){
			boolean toSwap = random.nextBoolean();
			if(toSwap){
				byte tmp = firstArray[i];
				firstArray[i] = secondArray[i];
				secondArray[i] = tmp;
			}
		}
			
	}
}
