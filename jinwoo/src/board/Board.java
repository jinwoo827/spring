package board;

import java.sql.Date;

public class Board {
	
	private int bNum;
	private String bWriter;
	private String bTitle;
	private String bContents;
	private Date bDate;
	
	
	public Board() {
		super();
	}


	public Board(int bNum, String bWriter, String bTitle, String bContents, Date bDate) {
		super();
		this.bNum = bNum;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.bContents = bContents;
		this.bDate = bDate;
	}


	public int getbNum() {
		return bNum;
	}


	public void setbNum(int bNum) {
		this.bNum = bNum;
	}


	public String getbWriter() {
		return bWriter;
	}


	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public String getbContents() {
		return bContents;
	}


	public void setbContents(String bContents) {
		this.bContents = bContents;
	}


	public Date getbDate() {
		return bDate;
	}


	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}


	@Override
	public String toString() {
		return "Board [bNum=" + bNum + ", bWriter=" + bWriter + ", bTitle=" + bTitle + ", bContents=" + bContents
				+ ", bDate=" + bDate + "]";
	}
	
	
	
	

}
