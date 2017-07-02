package reply;

import java.util.ArrayList;



public class ReplyService implements Service{
	private Dao dao;

	@Override
	public void insertReply(Reply r) {
		// TODO Auto-generated method stub
		dao.insertReply(r);
	}

	@Override
	public void deleteReply(int rNum) {
		// TODO Auto-generated method stub
		dao.deleteReply(rNum);
	}

	@Override
	public ArrayList<Reply> selectAllByBoardNum(int bNum) {
		// TODO Auto-generated method stub
		return dao.selectAllByBoardNum(bNum);
	}

	@Override
	public void setReplyDao(Dao dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}

	@Override
	public Reply select(int rNum) {
		// TODO Auto-generated method stub
		return dao.select(rNum);
	}
	
}
