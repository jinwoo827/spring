package member;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MemberService implements Service{
	private Dao dao;
	private Log log = LogFactory.getLog(getClass());
	public MemberService(Dao dao){
		this.dao = dao;
		log.debug(dao+"¡÷¿‘");
	}

	@Override
	public boolean insertMember(Member m) {
		// TODO Auto-generated method stub
		int result = dao.insertMember(m);
		if(result <= 0){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteMember(String userId) {
		// TODO Auto-generated method stub
		int result = dao.deleteMember(userId);
		if(result <= 0){
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public Member findMember(String userId) {
		// TODO Auto-generated method stub
		return dao.selectMember(userId);
	}

	@Override
	public ArrayList<Member> findAll() {
		// TODO Auto-generated method stub
		return dao.selectAllMember();
	}

	@Override
	public boolean login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return dao.login(userId, userPwd);
	}

	@Override
	public boolean updateMember(Member m) {
		// TODO Auto-generated method stub
		int result = dao.updateMember(m);
		if(result <= 0){
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String checkId(String userId) {
		// TODO Auto-generated method stub
		return dao.checkId(userId);
	}

}
