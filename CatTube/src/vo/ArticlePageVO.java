package vo;

import java.util.List;

public class ArticlePageVO {
	private List<BoardVO> articleList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	
	public ArticlePageVO(){}
	public ArticlePageVO(List<BoardVO> articleList, int startPage, int endPage, int currentPage, int totalPage) {
		super();
		this.articleList = articleList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	
	public List<BoardVO> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<BoardVO> articleList) {
		this.articleList = articleList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
