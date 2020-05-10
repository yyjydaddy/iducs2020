package iducs.java.exception;

public class ExceptionTest {

	public static void main(String[] args) {		
		if(args.length == 2) {
			boolean asc = true;
			if(args[1].equals("1"))
				asc = false;
			int cols = Integer.parseInt(args[0]);
			
			new NineImpl(cols, asc).showTableByOrder();
						
			new NinetyImpl(cols, !asc).showTableByOrder();
		}
		else {
			System.out.println("형식 : java ExceptionTest cols asc");
			System.out.println(" cols 허용되는 정수값, asc - 0:true, 1:false");
		}
	}
}
