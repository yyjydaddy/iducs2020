package iducs.java201200.library;

public class StringObjectTest1 { // outer class
	public static void main(String[] args) {
		StringObjectTest1 strObjTest = new StringObjectTest1();
		StringObject stringObject = strObjTest.new StringObject();
		// StringObject stringObject = new StringObject();
		stringObject.reverseCharArray();
	}
	class StringObject { // inner class, 범용성 보다는 outer class 안에서만 사용할 목적으로 정의
		public void reverseCharArray() {
			char[] input = {'C', 'h', 'o', 'a', 'n', 's', 'a', 'n', '-', 'r', 'o'};
			int size = input.length;
			char[] reverse = new char[size];
			
			int j = 0;
			for (int i = size - 1;i >= 0; i--) {
				reverse[j++] = input[i]; 
			}
			System.out.printf("%10s", "Input : ");
			for(int k= 0; k < input.length; k++ )
				System.out.print(input[k]);
			System.out.println("");
			
			System.out.printf("%10s", "Result : ");
			for(int k= 0; k < reverse.length; k++ )
				System.out.print(reverse[k]);
			System.out.print("\n");	
		}
	}
}
	


