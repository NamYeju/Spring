package skuniv.sc.yeju.middlePjt.memberData;

public class Member {
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	public Member(String name, String phoneNumber, String email, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email; 
		this.address = address;
	}
	void setName(String name) {this.name = name;}
	public String getName() { return name; }
	public String getPhoneNumber() { return email; }
	public String getEmail() { return email; }
	public String getAddress() { return email; }

}
