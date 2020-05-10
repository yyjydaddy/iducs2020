package iducs.java.library;

public class ObjectCloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Player objA = new Player("egyou", 32, 20.28);
		Player objB = new Player("iducs", 50, 15.17);
		Player objC = (Player) objA.clone();	
		
		if(objA.equals(objB))
			System.out.println("참조하는 인스턴스가 동일하다.");
		else
			System.out.println("참조하는 인스턴스가 다르다.");
		
		if(objA.equals(objC))
			System.out.println("참조하는 인스턴스가 동일하다.");
		else
			System.out.println("참조하는 인스턴스가 다르다.");
		
		if(objB.getClass() == objC.getClass())
			System.out.println("");
		else
			System.out.println("참조하는 인스턴스가 다르다.");
		
		System.out.println(objA.hashCode() + "@" + objA.toString());
		System.out.println(objB.hashCode() + "@" + objB.toString());
		System.out.println(objC.hashCode() + "@" + objC.toString());
	}
}

class Player implements Cloneable { // 복제 가능한 객체 생성을 위해 Cloneable 인터페이스 구현
	String name;
	int age;
	double kWar;

	public Player(String name, int age, double kWar) {
		this.name = name;
		this.age = age;
		this.kWar = kWar;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();		
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", kWar=" + kWar + "]";
	}
	
}
