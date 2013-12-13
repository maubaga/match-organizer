package bluemango.matchorganizer;


import java.util.Random;

public class ShakeArray {
	int[] array;
	Sunday[] sundayArray;

	public ShakeArray(int[] arrayToShake){
		this.array = arrayToShake;
	}
	
	public ShakeArray(Sunday[] arrayToShake){
		this.sundayArray = arrayToShake;
	}
	
	public void shakeArrays(){
		int length = array.length;
		Random random = new Random();
		for(int i = 0; i < length; i++){
			int newIndex = random.nextInt(length);
			int tempFirst = array[newIndex];
			array[newIndex] = array[i];
			array[i] = tempFirst;
		}
	}
	
	public void shakeSundayArrays(){
		int length = sundayArray.length;
		Random random = new Random();
		for(int i = 0; i < length; i++){
			int newIndex = random.nextInt(length);
			Sunday tempFirst = sundayArray[newIndex];
			sundayArray[newIndex] = sundayArray[i];
			sundayArray[i] = tempFirst;
		}
	}
}
