package skuniv.sc.yeju.middlePjt.memberData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class UserCheck implements LoginBean{

	
	public boolean usercheck(String s) throws IOException {
		String fileName = "C:\\springworks\\LibraryManagementSystem\\userFile.txt";
		FileReader fr = new FileReader(fileName);
		File inputFile = new File(fileName);
		//File outputFile = new File(tempFile);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		//BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
		
		String line;
		String repLine;
		boolean result = false;
		
		while((line = br.readLine()) != null) {
			
			String []s1=line.split(" ");
			if(s1[2].equals(s)) {
				System.out.println("로그인 성공");
				result=true;
				break;
			}
			
	

		}
		if(result==false){
			System.out.println("아이디를 확인해주세요");
		}
		/*
		 * FileWriter fw=new FileWriter(inputFile); fw.write(temp);
		 */
		//fw.close();
		//bw.close();
		br.close();
		return result;
		

		
	}

}
