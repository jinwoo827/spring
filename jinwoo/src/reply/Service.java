package reply;

import java.util.ArrayList;



public interface Service {
	void insertReply(Reply r);
	void deleteReply(int rNum);
	ArrayList<Reply> selectAllByBoardNum(int bNum);
	void setReplyDao(Dao dao);
	Reply select(int rNum);

}
