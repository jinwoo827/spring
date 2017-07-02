package reply;

import java.sql.Date;

public class Reply {
	private int rNum;
	private String rWriter;
	private String rTitle;
	private String rContent;
	private Date rDate;
	private int rBoardnum;
	
	public Reply(){}

	public Reply(int rNum, String rWriter, String rTitle, String rContent, Date rDate, int rBoardnum) {
		super();
		this.rNum = rNum;
		this.rWriter = rWriter;
		this.rTitle = rTitle;
		this.rContent = rContent;
		this.rDate = rDate;
		this.rBoardnum = rBoardnum;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public String getrWriter() {
		return rWriter;
	}

	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public int getrBoardnum() {
		return rBoardnum;
	}

	public void setrBoardnum(int rBoardnum) {
		this.rBoardnum = rBoardnum;
	}

	@Override
	public String toString() {
		return "[rNum=" + rNum + ", rWriter=" + rWriter + ", rTitle=" + rTitle + ", rContent=" + rContent
				+ ", rDate=" + rDate + ", rBoardnum=" + rBoardnum + "]";
	}
	
	
	

}
