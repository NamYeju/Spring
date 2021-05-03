package skuniv.sc.yeju.middlePjt.memberData;

public class Member {
	private String ID;
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	public Member(String ID, String name, String phoneNumber, String email, String address) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email; 
		this.address = address;
	}
	public String getID() {return ID;}
	void setName(String name) {this.name = name;}
	public String getName() { return name; }
	public String getPhoneNumber() { return email; }
	public String getEmail() { return email; }
	public String getAddress() { return email; }

}
