package test00;

import java.sql.Timestamp;

public class boardVO {
	private String title; //제목
	private String content; //내용
	private String name;//글쓴사람이름
	private Timestamp rgstday;//등록일
	private int idx; //시퀀스
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getRgstday() {
		return rgstday;
	}
	public void setRgstday(Timestamp rgstday) {
		this.rgstday = rgstday;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	@Override
	public String toString() {
		return "MemberVO [title=" + title + ", content=" + content + ", name=" + name + ", rgstday=" + rgstday
				+ ", idx=" + idx + "]";
	}
}
