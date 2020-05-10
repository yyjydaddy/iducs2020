package iducs.java.exception2;

public class NineImpl implements MultiplicationTable {
	private int row;
	private int cols;
	private boolean asc;
	public NineImpl(int cols, boolean asc) {
		this.row = 9;
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
			if(cols == 1 || cols == 2 || cols == 4 || cols == 8) {
				if(order) { // 0인 경우 구구단은 오름차순, 십구단은 내림차순
					int dan = 2;
					for (int k = 0; k <= 8/cols; k++) {
						for (int i = 1; i <= 9; i++) {
							for (int j = dan; j < (dan + cols); j++) {
								if (j > 9)
									break;
								System.out.printf("%-12s", j + "*" + i + "=" + j * i);
							}
							System.out.println();
						}
						System.out.println();
						dan += cols;
						if (dan > 9)
							break;						
					}
				}
				else { // 1인 경우 구구단은 내림차순, 십구단은 오름차순
					int dan = 9;
					for (int k = 0; k <= 8/cols; k++) { // 행 반복
						for (int i = 1; i <= 9; i++) {
							for (int j = dan; j > (dan - cols); j--) { // 열 반복
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
				throw new IllegalColumnsUncheckedException("Exception : check your input -1, 2, 4, 8");
		}
		catch(IllegalColumnsUncheckedException e) {
			System.out.println(e.getMessage());
		}

	}

}
