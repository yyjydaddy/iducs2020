package iducs.java.exception2;

public class ExceptionTest {
	public static void main(String[] args) {
		if(args.length == 2) { // 매개변수 갯수 2인지를 검토, 명령행 매개변수(command line argument)
			boolean asc = true;
			if(args[1].equals("1"))
				asc = false;
			int cols = Integer.parseInt(args[0]);
			
			new NineImpl(cols, asc).showTable();
			new NineImpl(cols, asc).showTableByOrder(false);
						
			//new NinetyImpl(cols, !asc).showTableByOrder();
		}
		else {
			System.out.println("형식 : java ExceptionTest cols asc");
			System.out.println(" cols 허용되는 정수값, asc - 0:true, 1:false");
		}
	}
}
