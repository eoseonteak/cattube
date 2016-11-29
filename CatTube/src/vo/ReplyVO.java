package vo;

import java.util.Date;

public class ReplyVO {
	private String articleNum;
	private String reNo;
	private String reWriter;
	private String reMemo;
	private Date reDate;
	private String reParent;
	private String reDepth;
	private int reOrder;
	
	
	public ReplyVO(){}
	public ReplyVO(String articleNum, String reNo, String reWriter, String reMemo, Date reDate,
			String reParent, String reDepth, int reOrder) {
		super();
		this.articleNum = articleNum;
		this.reNo = reNo;
		this.reWriter = reWriter;
		this.reMemo = reMemo;
		this.reDate = reDate;
		this.reParent = reParent;
		this.reDepth = reDepth;
		this.reOrder = reOrder;
	}
	
	public String getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(String articleNum) {
		this.articleNum = articleNum;
	}
	public String getReNo() {
		return reNo;
	}
	public void setReNo(String reNo) {
		this.reNo = reNo;
	}
	public String getReWriter() {
		return reWriter;
	}
	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}
	public String getReMemo() {
		return reMemo;
	}
	public void setReMemo(String reMemo) {
		this.reMemo = reMemo;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	public String getReParent() {
		return reParent;
	}
	public void setReParent(String reParent) {
		this.reParent = reParent;
	}
	public String getReDepth() {
		return reDepth;
	}
	public void setReDepth(String reDepth) {
		this.reDepth = reDepth;
	}
	public int getReOrder() {
		return reOrder;
	}
	public void setReOrder(int reOrder) {
		this.reOrder = reOrder;
	}
}
