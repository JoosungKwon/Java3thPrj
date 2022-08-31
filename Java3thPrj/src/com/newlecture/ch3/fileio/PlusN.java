package com.newlecture.ch3.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PlusN {

	public static void main(String[] args) throws IOException {
		
		InputStream fin = new FileInputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\origin.txt");
		OutputStream fout = new FileOutputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\copy.txt");
		
		int data ;
		
		while((data=fin.read())!=-1) {
			fout.write(data);
			if(data=='n') 
				fout.write('N');
		}
		System.out.println("Success");
	
		fout.flush();
		fout.close();
		fin.close();
	}
	
}
