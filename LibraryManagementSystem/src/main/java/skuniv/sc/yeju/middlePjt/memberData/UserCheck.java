package skuniv.sc.yeju.middlePjt.memberData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

public class UserCheck implements LoginBean{
	public boolean usercheck(String user) throws IOException {
		String fileName = "C:\\springworks\\LibraryManagementSystem\\userFile.txt";
		FileReader fr = new FileReader(fileName);
		File inputFile = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		
		String line;
		boolean chk = false;
		
		while((line = br.readLine()) != null) {
			String []s1=line.split(" ");
			if(s1[0].equals(user)) {
				System.out.println(">>로그인 성공");
				chk=true;
				break;
			}
		}
		if(chk==false)
			System.out.println(">>로그인을 다시 시도하세요");
		
		br.close();
		return chk;	
	}

}
