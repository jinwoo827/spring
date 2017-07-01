package board;

import java.util.ArrayList;

public interface Dao {
	void insertBoard(Board b);
	void deleteBoard(int bNum);
	void updateBoard(Board b);
	Board findBoard(int bNum);
	ArrayList<Board> findAllBoard();

}
