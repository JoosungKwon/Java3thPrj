package com.newlecture.part1.ch4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCountApp {

	public static void main(String[] args) throws IOException {
		
		InputStream fin = new FileInputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\source.java");
		OutputStream fout = new FileOutputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\source_copy.java");
		//----------------------------------------------------------------------------------------------------------------------
		int count = 0;
		
		while(true) {
			
			int x = fin.read();
			
			if(x==-1)
				break;
			
			if(x=='\n' || x == '\r') {continue;}
			fout.write(49);
		}
	}
}
