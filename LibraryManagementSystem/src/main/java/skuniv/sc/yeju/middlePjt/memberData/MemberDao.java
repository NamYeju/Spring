package skuniv.sc.yeju.middlePjt.memberData;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	//private static long nextIdx = 0;
	private Map<String, Member> map = new HashMap<>();
	public Member selectByEmail(String email) { return map.get(email); }
	public void insert(Member member) {
		map.put(member.getEmail(), member);
	}
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	public Collection<Member> selectAll() {
	        return map.values();
	    }
}
