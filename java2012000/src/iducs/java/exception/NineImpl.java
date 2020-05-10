package iducs.java.exception;

import java.util.Arrays;

public class NineImpl implements MultiplicationTable {
	private int rows;
	private int cols;
	boolean asc;	
	
	public NineImpl() {
		this(1, true);
	}
	
	public NineImpl(int cols, boolean asc) {
		this.rows = 9;
		this.cols = cols;
		this.asc = asc;
	}
	
	@Override
	public void showTable() {
		// TODO Auto-generated method stub
		this.showTableByOrder();
	}

	@Override
	public void showTableByOrder() {
		// TODO Auto-generated method stub
		try {
			/*
			String[] PERMITTED_COLUMNS = {"1", "2", "4", "8"};
			아래 if문의 조건은 Arrays.asList를 활용하여서 처리도 가능하다.
			*/
			if(cols == 1 || cols == 2 || cols == 4 || cols == 8) {			
				if(asc) { // ascending
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
				else { // descending
					int dan = 9;
					for (int k = 0; k <= 8/cols; k++) {
						for (int i = 1; i <= 9; i++) {
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
				throw new IllegalColumnsUncheckedException("Exception : check your input - 1, 2, 4, 8");
		} catch(IllegalColumnsUncheckedException e) {
			System.out.println(e.getMessage());
		}
	}

}
