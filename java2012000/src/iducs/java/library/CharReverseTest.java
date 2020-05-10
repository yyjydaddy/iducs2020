package iducs.java.library;

public class CharReverseTest {
	public static void main(String[] args) {
		CharReverse charReverser = new CharReverse();		
		charReverser.reverseCharArray();
		charReverser.reverseUsingStringBuffer();
		charReverser.reverseUsingSplit();
	}
}

class CharReverse {
	public void reverseCharArray() {
		char[] input = {'C', 'h', 'o', 'a', 'n', 's', 'a', 'n', '-', 'r', 'o'};
		int size = input.length;
		char[] reverse = new char[size];
		
		int j = 0;
		for (int i = size - 1;i >= 0; i--) {
			reverse[j++] = input[i]; 
		}
		for(int k= 0; k < input.length; k++ )
			System.out.print(input[k]);
		System.out.print(" --> ");
		for(int k= 0; k < reverse.length; k++ )
			System.out.print(reverse[k]);
		System.out.print("\n");	
	}

	public void reverseUsingStringBuffer() {
		String input = "Choansan-ro";
		String reverse = new StringBuffer(input).reverse().toString();
	    System.out.println(reverse);
	}
	
	public void reverseUsingSplit() {	
		String input = "12 Choansan-ro, Nowon-gu, Seoul, Korea, 01878";		
		String[] splits = input.split(",");
		int size = splits.length;
		System.out.print(input + " --> ");
	    for(int i = size - 1; i > 0 ; i--)
	    	System.out.print(splits[i].trim() + ", ");
	    System.out.println(splits[0]);
	}
}
