package skuniv.sc.yeju.middlePjt.LibraySystem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import skuniv.sc.yeju.middlePjt.memberData.LoginDao;

public class Return implements ReturnBean, updateUserpage{
	@Autowired
	LoginDao logindao;
	
	public void returnbook(String name)throws IOException {

		String fileName = "C:\\springworks\\LibraryManagementSystem\\src\\main\\java\\skuniv\\sc\\yeju\\middlePjt\\LibraySystem\\bookList.txt";
		String user_fileName = "C:\\springworks\\LibraryManagementSystem\\"+logindao.getID()+".txt";
		FileReader fr = new FileReader(fileName);
		FileReader fr2 = new FileReader(user_fileName);
		BufferedReader br = new BufferedReader(fr);
		BufferedReader br2 = new BufferedReader(fr2);
		String line = null;
		String line2 = null;
		String line3 = null;
		boolean chk = false;
		boolean chk2 = false;
		boolean chk3 = false;
		String[] bookState = {"재고있음", "재고없음"};
		File file = new File(user_fileName);
		
		while(true) {
			line = br.readLine();
			if(line == null)
				break;
			else {
				if(line.contains(name)) {
					chk = true;
					break;
				}
				else chk = false;
			}
		}
		if(chk == true) {
			if(file.exists()) {
				while(true) {
					line2 = br2.readLine();
					if(line2 == null)
						break;
					else {
						if(line2.contains(name)) {
							chk2 = true;
							if(line2.contains("대여"))
								chk3 = true;
							else chk3 = false;
							break;						
						}	
					}
			
				}
				if(chk2 == true) {
					if(chk3 == true) {
						System.out.println(">>반납완료");
						changeState(fileName, name, bookState[1], bookState[0]);
						update(logindao.getID(), line);	
					}
					else
						System.out.println(">>해당 책은 이미 반납완료");

				}
				else if(chk2==false){
					System.out.println(">>해당 책을 대여한 기록이 존재하지 않음");
				}
			}
			else
				System.out.println(">>사용자의 대여/반납한 기록이 존재하지 않음.");
			}
		else
			System.out.println(">>해당 책은 도서관에 존재하지 않습니다");


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
		fw.write(" 반납 "+simpleDateFormat.format(lastModifiedDate)+"\r\n");
		
		fw.close();
		
	}
}
