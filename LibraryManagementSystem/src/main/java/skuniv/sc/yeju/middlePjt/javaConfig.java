package skuniv.sc.yeju.middlePjt;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import skuniv.sc.yeju.middlePjt.LibraySystem.Rental;
import skuniv.sc.yeju.middlePjt.LibraySystem.RentalBean;
import skuniv.sc.yeju.middlePjt.LibraySystem.Return;
import skuniv.sc.yeju.middlePjt.LibraySystem.ReturnBean;
import skuniv.sc.yeju.middlePjt.LibraySystem.Search;
import skuniv.sc.yeju.middlePjt.LibraySystem.SearchBean;
import skuniv.sc.yeju.middlePjt.LibraySystem.printUserpage;
import skuniv.sc.yeju.middlePjt.memberData.LoginBean;
import skuniv.sc.yeju.middlePjt.memberData.LoginDao;
import skuniv.sc.yeju.middlePjt.memberData.MemberDao;
import skuniv.sc.yeju.middlePjt.memberData.UserCheck;
import skuniv.sc.yeju.middlePjt.memberData.editProfile;
import skuniv.sc.yeju.middlePjt.signUp.MemberRegisterService;

@Configuration
public class javaConfig {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	
	 @Bean 
	 public SearchBean searchBean() {
		 return new Search(); 
	}
	 

	@Bean
	public RentalBean rentalBean() {
		return new Rental();

	}
	@Bean
	public ReturnBean returnBean() {
		return new Return();
	}
	
	@Bean
	public LoginBean loginBean() {
		return new UserCheck();
		
	}
	
	@Bean
	public LoginDao loginDaoBean() {
		return new LoginDao();
		
	}
	
	@Bean
	public printUserpage printpage() {
		return new printUserpage();
		
	}
	@Bean
	public editProfile editprofile() {
		return new editProfile();
	}

}


