package service;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberService {
	private static MemberService instance = new MemberService();
	private MemberService(){}
	public static MemberService getInstance(){
		return instance;
	}
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	public boolean join(MemberVO member){
		MemberVO savedMember = dao.select(member.getId());
		
		if(savedMember!=null){
			return false;
		}else{
			int result = dao.insert(member);
			if(result==1){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean login(String id, String password){
		MemberVO savedMember = dao.select(id);
		
		if(savedMember!=null && savedMember.getPassword().equals(password)){
			//해당 아이디가 존재하고 비밀번호가 일치하면 성공
			return true;
		}else{
			return false;
		}
	}
}
