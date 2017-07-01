package member;

import java.util.ArrayList;

public interface Dao {
	int insertMember(Member m);
	int deleteMember(String userId);
	Member selectMember(String userId);
	ArrayList<Member> selectAllMember();
	boolean login(String userId, String userPwd);
	int updateMember(Member m);
	String checkId(String userId);

}
