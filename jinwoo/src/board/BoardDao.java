package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class BoardDao implements Dao{
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	//커넥션 연결
	private void con() {
		if (conn == null) {
			conn = DataSourceUtils.getConnection(dataSource);
	//		log.info(conn + "커넥션생성");
		}
	}
	
	//디스컨
	private void discon() {
		if (conn != null) {
			DataSourceUtils.releaseConnection(conn, dataSource);
			conn = null;
	//		log.info(conn + "디스컨");
		}
	}
	
	
	///
	private Board makeBoardByResultSet(ResultSet rs){
		Board b = new Board();
		try{			
			b.setbNum(rs.getInt(1));
			b.setbWriter(rs.getString(2));
			b.setbTitle(rs.getString(3));
			b.setbContents(rs.getString(4));
			b.setbDate(rs.getDate(5));
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		return b;
	}
	

	@Override
	public void insertBoard(Board b) {
		// TODO Auto-generated method stub
		String sql = "insert into j_board values(j_board_seq.nextval,?,?,?,sysdate)";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getbWriter());
			pstmt.setString(2, b.getbTitle());
			pstmt.setString(3, b.getbContents());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		
	}

	@Override
	public void deleteBoard(int bNum) {
		// TODO Auto-generated method stub
		String sql = "delete j_board where bNum=?";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		
	}

	@Override
	public void updateBoard(Board b) {
		// TODO Auto-generated method stub
		String sql = "update j_baord set bTitle=?, bContents=? where bNum=?";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getbTitle());
			pstmt.setString(2, b.getbContents());
			pstmt.setInt(1, b.getbNum());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		
	}

	@Override
	public Board findBoard(int bNum) {
		// TODO Auto-generated method stub
		Board b = null;
		String sql = "select * from j_board where bNum=?";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();
			if(rs.next()){
				b = this.makeBoardByResultSet(rs);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return b;
	}

	@Override
	public ArrayList<Board> findAllBoard() {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from j_board";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(this.makeBoardByResultSet(rs));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return list;
	}
	

}
