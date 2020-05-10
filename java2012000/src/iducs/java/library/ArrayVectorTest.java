package iducs.java.library;

import java.util.Vector;

import sun.misc.Unsafe;
import sun.reflect.*;

public class ArrayVectorTest {
	static Unsafe unsafe;
	public static void main(String[] args) {
		String[] strArr = {"first", "second", "third", "fourth"};
		//Vector<String> strVec = new Vector<String>();
		//strVec.add
		printAddress("Address", strArr);
		for(String str : strArr)
			printAddress("Address", strArr);
	}
	
	public static Unsafe getUnsafe() {
	    Class cc = sun.reflect.Reflection.getCallerClass(2);
	    if (cc.getClassLoader() != null)
	        throw new SecurityException("Unsafe");
	    return theUnsafe;
	}
	
	public static void printAddress(String label, Object... objects) {
		System.out.print(label + ": 0x");
		long last = 0;
		int offset = unsafe.arrayBaseOffset(objects.getClass());
		int scale = unsafe.arrayIndexScale(objects.getClass());
		switch (scale) {
		case 4:
			long factor = true ? 8 : 1;
			final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
			System.out.print(Long.toHexString(i1));
			last = i1;
			for (int i = 1; i < objects.length; i++) {
				final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
				if (i2 > last)
					System.out.print(", +" + Long.toHexString(i2 - last));
				else
					System.out.print(", -" + Long.toHexString( last - i2));
				last = i2;
			}
			break;
		case 8:
			throw new AssertionError("Not supported");
		}
		System.out.println();
	}
}
