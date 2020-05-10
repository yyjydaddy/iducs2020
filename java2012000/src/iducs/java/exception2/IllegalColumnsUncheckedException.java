package iducs.java.exception2;

public class IllegalColumnsUncheckedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalColumnsUncheckedException(String msg) {
		super(msg); // 수퍼 클래스의 문자열 하나를 매개변수로 갖는 생성자를 호출
	}
}
