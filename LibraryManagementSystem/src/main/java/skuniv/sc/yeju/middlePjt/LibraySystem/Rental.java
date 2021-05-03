package skuniv.sc.yeju.middlePjt.LibraySystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import skuniv.sc.yeju.middlePjt.memberData.LoginDao;

public class Rental implements RentalBean, updateUserpage {
	@Autowired
	LoginDao logindao;
	
	public void rental(String name)throws IOException {
		// 책없을시
		// 책은 있는데 누가 대여중일때
		// 책 존재 & 대여 가능
		String fileName = "C:\\springworks\\LibraryManagementSystem\\src\\main\\java\\skuniv\\sc\\yeju\\middlePjt\\LibraySystem\\bookList.txt";
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		boolean chk = false;
		String[] bookState = {"재고있음", "재고없음"};

		while(true) {
			line = br.readLine();
			if(line==null)
				break;
			else {
				if(line.contains(name)) {
					chk = true;
					if(line.contains(bookState[0])) {
						System.out.println(">>대여완료");
						changeState(fileName, name, bookState[0], bookState[1]);
						
						update(logindao.getID(), line);
						break;
					}
					else if(line.contains(bookState[1])) {
						System.out.println(">>현재 해당 책 재고가 없으므로 대여 불가능");
						break;
					}
				}
				else
					chk = false;
			}
			
		}
		if(chk == false) System.out.println(">>도서리스트에 해당 책이 없으므로 대여 불가능");
		br.close();
		fr.close();
	}

	public void changeState(String filename, String bookname, String original, String replace) throws IOException {
		String line;
		String repLine;
		String temp="";
		
		File inputFile = new File(filename);
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		
		while((line = br.readLine()) != null) {
			if(line.contains(bookname)) {
				repLine = line.replaceAll(original, replace);
				temp+=repLine+"\r\n";
			}
			else {
				temp+=line+"\r\n";
			}
		}
		FileWriter fw=new FileWriter(inputFile);
		fw.write(temp);
		fw.close();
		br.close();

	}

	public void update(String userID, String bookinfo) throws IOException {
		File userpageFile = new File("C:\\springworks\\LibraryManagementSystem\\"+userID+".txt");
		String pattern = "yyyy-MM-dd aa hh:mm";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date lastModifiedDate = new Date();
		
		if(!userpageFile.exists())
			userpageFile.createNewFile();
		
		FileWriter fw = new FileWriter(userpageFile, true);
		fw.write(bookinfo.substring(0,bookinfo.length()-5));
		fw.write(" 대여 "+simpleDateFormat.format(lastModifiedDate)+"\r\n");
		
		fw.close();		
	}	
}
