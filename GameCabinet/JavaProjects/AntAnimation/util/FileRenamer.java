package util;

import java.io.File;

public class FileRenamer {
	
	
	private String filepath;
	private int startNum=78;
	private File file;
	
	
	
	public FileRenamer(String filepath,int startNum) {
		
		this.filepath = filepath;
		this.startNum = startNum;
		
	}
	
	public void rename(File folder) {
		
		for (File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory()) {
				String string = filepath+"/"+startNum+".JPEG";
				fileEntry.renameTo(new File(string));
				startNum++;
				System.out.println(string);
	        }
		}
		
		
	}

}
