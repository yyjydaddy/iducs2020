package iducs.java.library;

public class ObjectEqualsTest {
	public static void main(String[] args) {
		Object objA = new Object();
		Object objB = new Object();
		
		String strA = new String("String");
		String strB = "String";
		
		Integer intA = Integer.parseInt("1234"); // new Integer("1234") : deprecate
		Integer intB = Integer.parseInt("1234");
		
		System.out.println(objA.hashCode() + " : " + objB.hashCode());
		if(objA == objB)
			System.out.println("Objct == is true");
		else
			System.out.println("Objct == is false");		
		if(objA.equals(objB))
			System.out.println("Objct equals() is true");
		else
			System.out.println("Objct equals() is false");
		
		System.out.println(strA.hashCode() + " : " + strB.hashCode());		
		if(strA == strB)
			System.out.println("String == is true");
		else
			System.out.println("String == is false");		
		if(strA.equals(strB))
			System.out.println("String equals() is true");
		else
			System.out.println("String equals() is false");
		
		System.out.println(intA.hashCode() + " : " + intB.hashCode());	
		if(intA == intB)
			System.out.println("Integer == is true");
		else
			System.out.println("Integer == is false");
		
		if(intA.equals(intB))
			System.out.println("Integer equals() is true");
		else
			System.out.println("Integer equals() is false");
		
	}
}
