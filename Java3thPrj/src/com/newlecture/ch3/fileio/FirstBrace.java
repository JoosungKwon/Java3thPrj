package com.newlecture.ch3.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FirstBrace {

	public static void main(String[] args) throws IOException {
		
		InputStream fin = new FileInputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\origin.txt");
		OutputStream fout = new FileOutputStream("C:\\Users\\ict04-10\\git\\Java3thPrj\\Java3thPrj\\res\\copy.txt");
		
		int data ;
		int cnt = 0;
		
		while((data=fin.read())!=-1) {
			cnt ++;
			if(data=='{')
				break;
		}
		
		String answer = (data== -1) ? "해당 파일에는 중괄호가 없습니다." : "\"{\"는 %d번째 위치에 있습니다." ;
		System.out.println(answer);
		
		
		fout.flush();
		fout.close();
		fin.close();
	}

}

