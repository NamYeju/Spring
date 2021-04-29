package skuniv.sc.yeju.middlePjt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import skuniv.sc.yeju.middlePjt.LibraySystem.Rental;
import skuniv.sc.yeju.middlePjt.LibraySystem.Search;
import skuniv.sc.yeju.middlePjt.signUp.MemberRegisterService;
import skuniv.sc.yeju.middlePjt.signUp.RegisterRequest;
public class Main {
	public static void main(String[] args)throws IOException {
		int num, menuNum;
		String strName, strPhonenum, strEmail, strAddress;
		String str;
		Scanner sc = new Scanner(System.in);
		File userFile = new File("C:\\springworks\\LibraryManagementSystem\\userFile.txt");
		if(!userFile.exists())
			userFile.createNewFile();
		FileWriter fw = new FileWriter(userFile, true);
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		MemberRegisterService regSvc = (MemberRegisterService)ctx.getBean("memberRegSvc");
		RegisterRequest regReq = new RegisterRequest();
		Search searchbean =(Search)ctx.getBean("searchBean");
		Rental rentalbean =(Rental)ctx.getBean("rentalBean");
		
		do {
			System.out.println("1. 회원가입 2.로그인 3.도서시스템 이용 4.종료");
			 num = sc.nextInt();
			if(num==1) {			
				System.out.println("Input your name");
				strName = sc.next();
				regReq.setName(strName);
				System.out.println("Input your phone number");
				strPhonenum = sc.next();
				regReq.setPhoneNumber(strPhonenum);
				System.out.println("Input your email");
				strEmail = sc.next();
				regReq.setEmail(strEmail);
				System.out.println("Input your address");
				strAddress = sc.next();
				regReq.setAddress(strAddress);
				regSvc.regist(regReq);
				
				fw.write(regReq.getName());
				fw.write(regReq.getPhoneNumber());
				fw.write(regReq.getEmail());
				fw.write(regReq.getAddress()+"\r\n");
				fw.flush();
			}
			if(num==2) {
				System.out.println("Input your email");
				strEmail = sc.nextLine();
				if(strEmail.equals(regReq.getEmail())){
					System.out.println("임시msg -> system");
				}
				else {
					System.out.println("You have to sign in first");
				}
			}
			if(num==3) {
				System.out.println("1.검색 2.대여 3.반납");
				menuNum = sc.nextInt();
				if(menuNum == 1) {	
					System.out.println("검색할 책 이름 input");
					str = sc.next();
					searchbean.search(str);	
				}
				if(menuNum == 2) {
					System.out.println("대여할 책 이름 input");
					str = sc.next();
					rentalbean.rental(str);
				}
			}
		}while(num!=4);
	  
		System.out.println("시스템 종료");
	}

}
