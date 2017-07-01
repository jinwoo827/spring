package member;

import java.util.ArrayList;

public interface Service {
	boolean insertMember(Member m);
	boolean deleteMember(String userId);
	Member findMember(String userId);
	ArrayList<Member> findAll();
	boolean login(String userId,String userPwd);
	boolean updateMember(Member m);
	String checkId(String userId);

}
