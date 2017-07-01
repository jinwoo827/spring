package board;

import java.util.ArrayList;
import java.util.Map;

public interface Service {
	void insertBoard(Board b);
	void deleteBoard(int bNum);
	void updateBoard(Board b);
	Board findBoard(int bNum);
	ArrayList<Board> findAllBoard();

}
