package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class MemberDao implements Dao {
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Log log = LogFactory.getLog(getClass());
	
	//Dao에 데이터 소스 주입
	public MemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
		log.debug(dataSource + "주입완료");
	}
	
	//커넥션 연결
	private void con() {
		if (conn == null) {
			conn = DataSourceUtils.getConnection(dataSource);
			log.debug(conn + "커넥션생성");
		}
	}
	
	//디스컨
	private void discon() {
		if (conn != null) {
			DataSourceUtils.releaseConnection(conn, dataSource);
			log.debug(conn + "디스컨");
		}
	}
		
	//멤버 타입으로 넣기
	private Member makeMemberByResultSet(ResultSet rs){
		Member m = null;
		try{			
			while(rs.next()){
			m = new Member();
			m.setUserId(rs.getString(1));
			m.setUserPwd(rs.getString(2));
			m.setUserName(rs.getString(3));
			m.setUserMsg(rs.getString(4));
			m.setUserDate(rs.getDate(5));
			m.setUserType(rs.getInt(6));
			}
		
		} catch (SQLException e){
			e.printStackTrace();
		}
		return m;
	}

	@Override//가입
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "insert into j_member values(?,?,?,?,sysdate,?)";
		try {
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserMsg());
			pstmt.setInt(5, m.getUserType());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return result;
	}

	@Override//탈퇴
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "delete j_member where userId=?";
		try {
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return result;
	}

	@Override
	public Member selectMember(String userId) {
		// TODO Auto-generated method stub
		Member m = null;
		String sql = "select * from j_member where userId=?";
		try {
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
	//			m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),rs.getInt(6));
				m = this.makeMemberByResultSet(rs);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return m;
	}

	@Override
	public ArrayList<Member> selectAllMember() {
		// TODO Auto-generated method stub
		ArrayList<Member> list = new ArrayList<Member>();
		String sql = "select * from j_member";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(this.makeMemberByResultSet(rs));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return list;
	}

	@Override
	public boolean login(String userId, String userPwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "select id from j_member where userId=? and userPwd=?";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return flag;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "update j_member set userPwd=?, userMsg=? where userId=?";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getUserMsg());
			pstmt.setString(3, m.getUserId());
			result = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return result;
	}

	@Override
	public String checkId(String userId) {
		// TODO Auto-generated method stub
		String id = "";
		String sql = "select id from j_member where userId=?";
		try{
			this.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				id = rs.getString(1);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			this.discon();
		}
		return id;
	}

}
