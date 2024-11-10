package Member;

import java.util.Date;

public class MemberDTO {
	private int memberIndex;
	private String memberId;
	private String memberPw;
	private String memberName;
	private Date memberBirth;
	private String memberEmail;
	private Date registerDate;
	private String memberGrade;
	
	public MemberDTO(int index, String id, String pw, String name, Date birth, String email, Date registerDate, String grade) {
		this.memberIndex = index;
		this.memberId = id;
		this.memberPw = pw;
		this.memberName = name;
		this.memberBirth = birth;
		this.memberEmail = email;
		this.registerDate = registerDate;
		this.memberGrade = grade;
	}
	
	public int getMemberIndex() {
		return memberIndex;
	}
	public void setMemberIndex(int memberIndex) {
		this.memberIndex = memberIndex;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	
}
