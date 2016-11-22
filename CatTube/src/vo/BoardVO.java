package vo;

import java.sql.Timestamp;

public class BoardVO {
	private int num;				// 번호
	private String title;           // 제목
	private String content;         // 내용
	private String writer;          // 작성자
	private Timestamp writeDate;    // 날짜
	private int readCount;          // 조회수
	private int voteCount;          // 추천수
	private String videoPath;       // 동영상 경로 
	private String imagePath;       // 썸네일 경로
	private String closed;          // 공개, 비공개

	public BoardVO() {}

	public BoardVO(String title, String content, String writer, Timestamp writeDate, int readCount, int voteCount,
			String videoPath, String imagePath, String closed) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.voteCount = voteCount;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
		this.closed = closed;
	}

	public BoardVO(int num, String title, String content, String writer, Timestamp writeDate, int readCount,
			int voteCount, String videoPath, String imagePath, String closed) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.readCount = readCount;
		this.voteCount = voteCount;
		this.videoPath = videoPath;
		this.imagePath = imagePath;
		this.closed = closed;
	}

	public int getNum() {
		return num;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public Timestamp getWriteDate() {
		return writeDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getClosed() {
		return closed;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}
}
