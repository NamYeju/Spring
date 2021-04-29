package skuniv.sc.yeju.middlePjt.signUp;

import skuniv.sc.yeju.middlePjt.memberData.Member;
import skuniv.sc.yeju.middlePjt.memberData.MemberDao;

public class MemberRegisterService {
	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getName(), req.getPhoneNumber(), 
		req.getEmail(), req.getAddress());
		memberDao.insert(newMember);
		
	}
}
