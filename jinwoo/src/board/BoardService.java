package board;

import java.util.ArrayList;
import java.util.Map;

public class BoardService implements Service{
	private Dao dao;
	public BoardService(Dao dao){
		this.dao = dao;
	}

	@Override
	public void insertBoard(Board b) {
		// TODO Auto-generated method stub
		dao.insertBoard(b);
	}

	@Override
	public void deleteBoard(int bNum) {
		// TODO Auto-generated method stub
		dao.deleteBoard(bNum);
	}

	@Override
	public void updateBoard(Board b) {
		// TODO Auto-generated method stub
		dao.updateBoard(b);
	}

	@Override
	public Board findBoard(int bNum) {
		// TODO Auto-generated method stub
		return dao.findBoard(bNum);
	}

	

	@Override
	public ArrayList<Board> findAllBoard() {
		// TODO Auto-generated method stub
		return dao.findAllBoard();
	}

}
