package iducs.java.exception2;

public class NinetyImpl implements MultiplicationTable {
	private int rows;
	private int cols;
	boolean asc;	
	
	public NinetyImpl() {
		this(1, true);
	}
	
	public NinetyImpl(int cols, boolean asc) {
		this.rows = 19; // 9 or 19
		this.cols = cols;
		this.asc = asc;
	}
	
	@Override
	public void showTable() {
		// TODO Auto-generated method stub
		this.showTableByOrder(asc);
	}

	@Override
	public void showTableByOrder(boolean order) {
		// TODO Auto-generated method stub
		try { 
			if(cols == 1 || cols == 2 || cols == 3 || cols == 6 || cols == 9 || cols == 18) {
				if(asc) { // ascending
					int dan = 2;
					for (int k = 0; k <= 18/cols; k++) { // 행 출력
						for (int i = 1; i <= 19; i++) { // 단에 곱해지는 수의 증가
							for (int j = dan; j < (dan + cols); j++) { // 열 출력
								if (j > 19)
									break;
								System.out.printf("%-12s", j + "*" + i + "=" + j * i);
							}
							System.out.println();
						}
						System.out.println();
						dan += cols;
						if (dan > 19)
							break;						
					}
				}
				else { // descending
					int dan = 19;
					for (int k = 0; k <= 18/cols; k++) {
						for (int i = 1; i <= 19; i++) {
							for (int j = dan; j > (dan - cols); j--) {
								if (j < 2)
									break;
								System.out.printf("%-12s", j + "*" + i + "=" + j * i);
							}
							System.out.println();
						}
						System.out.println();
						dan -= cols;
						if (dan < 2)
							break;
						
					}
				}
			}
			else 
				throw new IllegalColumnsCheckedException("Exception : check your input - 1, 2, 3, 6, 9, 18 : ");
		} catch(IllegalColumnsCheckedException e) {
			System.out.println(e.getMessage());
		} 	
	}
}
