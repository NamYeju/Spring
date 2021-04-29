package skuniv.sc.yeju.middlePjt.LibraySystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Search implements SearchBean {
	public void search(String name) throws IOException {
		FileReader fr = new FileReader("C:\\springworks\\LibraryManagementSystem\\src\\main\\java\\skuniv\\sc\\yeju\\middlePjt\\LibraySystem\\bookList.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		boolean chk = false;
		
		while(true) {
			line = br.readLine();
			if(line == null)
				break;
			else {
				if(line.contains(name)) {
					chk = true;
					break;
				}
			}
		}
		if(chk == true) System.out.println(">>책 존재");
		if(chk == false) System.out.println(">>책 존재 안함");
		br.close();
		fr.close();
	}
}
