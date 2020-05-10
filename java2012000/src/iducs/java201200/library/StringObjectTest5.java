package iducs.java201200.library;

public class StringObjectTest5 {
	public static void main(String[] args) {
		String input = "12 Choansan-ro, Nowon-gu, Seoul, Korea, 01878";	
		StringObjectTest5 tester = new StringObjectTest5();
		StringObject stringObject = tester.new StringObject();
		System.out.println("Input String : " + input);
		int start, length;
		start = Integer.parseInt(args[0]);
		length = Integer.parseInt(args[1]);
		System.out.println("ReversSubString : " + 
				stringObject.reverseSubString(input, start, length));		
	}
	
	class StringObject {
		public String reverseSubString(String input, int begin, int length) {	
			StringBuilder reverse = new StringBuilder();		
			String[] splits = input.split(" ");
			int size = splits.length;// size 6, index 0 ~ 5	
		    for(int i = size - 1; i > 0 ; i--)
		    	reverse.append(splits[i] + " ");
		    reverse.append(splits[0]);
		    System.out.println("Reverse String : " + reverse);
		    int end = begin + length;
		    String str = reverse.substring(begin, end);
		    return str;
		}
	}
}

