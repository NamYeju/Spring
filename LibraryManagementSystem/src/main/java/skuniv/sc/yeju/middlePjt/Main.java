package skuniv.sc.yeju.middlePjt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import skuniv.sc.yeju.middlePjt.LibraySystem.Rental;
import skuniv.sc.yeju.middlePjt.LibraySystem.Return;
import skuniv.sc.yeju.middlePjt.LibraySystem.Search;
import skuniv.sc.yeju.middlePjt.memberData.LoginBean;
import skuniv.sc.yeju.middlePjt.memberData.LoginDao;
import skuniv.sc.yeju.middlePjt.signUp.MemberRegisterService;
import skuniv.sc.yeju.middlePjt.signUp.RegisterRequest;
import skuniv.sc.yeju.middlePjt.LibraySystem.printUserpage;
public class Main {

	public static void main(String[] args)throws IOException {

		int num, menuNum;
		String strName, strPhonenum, strEmail, strAddress;
		String str;
		boolean loginState = false;
		Scanner sc = new Scanner(System.in);
		File userFile = new File("C:\\springworks\\LibraryManagementSystem\\userFile.txt");
		if(!userFile.exists())
			userFile.createNewFile();
		FileWriter fw = new FileWriter(userFile, true);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(javaConfig.class);
		MemberRegisterService regSvc = (MemberRegisterService)ctx.getBean("memberRegSvc");
		RegisterRequest regReq = new RegisterRequest();
		Search searchbean = (Search)ctx.getBean("searchBean");
		Rental rentalbean = (Rental)ctx.getBean("rentalBean");
		Return returnbean = (Return)ctx.getBean("returnBean");
		
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
				
				fw.write(regReq.getName()+" ");
				fw.write(regReq.getPhoneNumber()+" ");
				fw.write(regReq.getEmail()+" ");
				fw.write(regReq.getAddress()+"\r\n");
				fw.flush();
			}
			if(num==2) {
				
				System.out.println("Input your email");
				strEmail = sc.next();
				LoginBean loginbean =(LoginBean)ctx.getBean("loginBean");
				LoginDao loginDaobean =(LoginDao)ctx.getBean("loginDaoBean");
				loginDaobean.setEmail(strEmail);
			
				
				loginState=loginbean.usercheck(strEmail);
			
	
			}
			if(num==3) {
				if(loginState == true) {
					do {
					System.out.println("1.검색 2.대여 3.반납 4.조회 5.로그아웃");
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
					if(menuNum == 3) {
						System.out.println("반납할 책 이름 input");
						
						str = sc.next();
						
						
						returnbean.returnbook(str);
					}
					if(menuNum == 4) {
						printUserpage printuserpage=(printUserpage)ctx.getBean("printpage");
						printuserpage.print();
					}
					}while(menuNum!=5);
				}
				else System.out.println("login first");

			}
		}while(num!=4);
	  
		System.out.println("시스템 종료");
	}

}
