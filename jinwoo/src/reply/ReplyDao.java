package reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class ReplyDao implements Dao{
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void con(){
		conn = DataSourceUtils.getConnection(dataSource);
	}
	private void discon(){
		DataSourceUtils.releaseConnection(conn, dataSource);
	}
	

	@Override
	public void insertReply(Reply r) {
		// TODO Auto-generated method stub
		String sql = "insert into j_reply values(j_reply_seq.nextval,?,?,?,sysdate,?)";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getrWriter());
			pstmt.setString(2, r.getrTitle());
			pstmt.setString(3, r.getrContent());
			pstmt.setInt(4, r.getrBoardnum());
			int result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	@Override
	public void deleteReply(int rNum) {
		// TODO Auto-generated method stub
		String sql = "delete j_reply where rNum=?";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			int result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	@Override
	public ArrayList<Reply> selectAllByBoardNum(int bNum) {
		// TODO Auto-generated method stub
		ArrayList<Reply> list = new ArrayList<Reply>();
		String sql = "select * from j_reply where rBoardNum=?";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Reply(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
		
		return list;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
		
	}
	@Override
	public Reply select(int rNum) {
		// TODO Auto-generated method stub
		Reply r = null;
		String sql = "select * from j_reply where rNum=?";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				r = new Reply(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getInt(6));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
		return r;
	}

}
