package exerc10;

public class Array {

	public static void main(String[] args) {
		int[] array = {0,1,2,3,4,5,6,7,8,9,10};
		for(int i=1; i < array.length; i++) {
			System.out.println(i + " * 2 = " + (array[i] * 2));
		}
	}
}
