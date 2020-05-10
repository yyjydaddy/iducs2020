package iducs.java.library;

import java.math.BigDecimal;
import java.math.RoundingMode; 
import java.text.DecimalFormat; 
public class RoundTest { 
	public static void main(String[] args) { 
		double rnd; 
		System.out.println("** DecimalFormat"); 
		DecimalFormat df = new DecimalFormat("#,###.00"); 
		
		df.setRoundingMode(RoundingMode.HALF_UP); 
		df.setMaximumFractionDigits(2); 

		rnd = 212399.535d; 
		System.out.println(df.format(rnd)); 
		
		rnd = 112399.405d; 
		System.out.println(df.format(rnd)); 
		
		BigDecimal bd = BigDecimal.valueOf(rnd); 
		//bd.setScale(2, RoundingMode.HALF_UP);
		System.out.println(df.format(bd));
		
		df.setMaximumFractionDigits(3); 
		rnd = 7.9005d; 
		System.out.println(df.format(rnd));
		

	} 
}
