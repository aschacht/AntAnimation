package util;

import java.io.File;

public class UtilTest {

	public static void main(String[] args) {
		FileRenamer fileRenamer = new FileRenamer("/home/wes/Documents/WhiperTech/iCloud Photos", 78);
		
		File file = new File("/home/wes/Documents/WhiperTech/iCloud Photos");
		fileRenamer.rename(file);
		
		
		
		
		

	}

}
