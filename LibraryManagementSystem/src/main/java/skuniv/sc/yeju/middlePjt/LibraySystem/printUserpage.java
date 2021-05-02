package skuniv.sc.yeju.middlePjt.LibraySystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import skuniv.sc.yeju.middlePjt.memberData.LoginDao;

public class printUserpage{
	
	@Autowired
	LoginDao logindao;
	
	public void print() throws IOException{
		String username;
		String str="";
		username = logindao.getEmail();
		File userpageFile = new File("C:\\springworks\\LibraryManagementSystem\\"+username+".txt");
		
		if(!userpageFile.exists()) {
			System.out.println("대여/반납 내역이 존재하지 않습니다.");
		}
		else {
			FileReader fr = new FileReader(userpageFile);
			BufferedReader br = new BufferedReader(fr);
			String line=null;
			while((line = br.readLine()) != null) {
			  str+=line+"\r\n";
			}
			System.out.println(str);
		}
			
	}
}
