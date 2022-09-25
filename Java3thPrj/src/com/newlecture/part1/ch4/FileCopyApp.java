package com.newlecture.part1.ch4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyApp {
	public static void main(String[] args) throws IOException {
		InputStream fin = new FileInputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\source.java");
		OutputStream fout = new FileOutputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\source_copy.java");
		//----------------------------------------------------------------------------------------------------------------------
		int x = fin.read();
		int count = 0;
		
		while(x != -1) {
			fout.write(x);
			count ++;
			x = fin.read();
		}
		
//		while() {
//			int x = fin.read();
//			
//			if(x==-1)
//				break;
//			
//			fout.write(x);
//		}
		
		
		fout.flush();
		fout.close();
		fin.close();
		System.out.println("파일 저장이 완료되었습니다.");
		System.out.println(count);
	}
}
