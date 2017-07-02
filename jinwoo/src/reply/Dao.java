package reply;

import java.util.ArrayList;

import javax.sql.DataSource;

public interface Dao {
	void insertReply(Reply r);
	void deleteReply(int rNum);
	ArrayList<Reply> selectAllByBoardNum(int bNum);
	void setDataSource(DataSource dataSource);
	Reply select(int rNum);

}
