package com.newlecture.part1.ch4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class fileInputOutputApp {

	public static void main(String[] args) throws IOException {
		File o = new File("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\origin.txt");
		File c = new File("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\copy.txt");
		InputStream fin = new FileInputStream(o);
		OutputStream fout = new FileOutputStream(c);
		int data ;
		while((data=fin.read())!=-1) {
			fout.write(data);
		}
		fout.flush();
		fout.close();
		System.out.println("파일 저장이 완료되었습니다.");
	}

}
