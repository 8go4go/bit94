package day15.exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mail {
	private Integer num;
	private String isCheck;
	private String reciver;
	private String sender;
	private String title;
	private String content;
	private String date;
	public Mail(Integer num, String sender, String reciver, String title, String content) {
		this(num, sender, reciver, title, content, new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
	}
	
	public Mail(Integer num, String sender, String reciver, String title, String content, String date) {
		this.num = num;
		this.sender = sender;
		this.reciver = reciver;
		this.title = title;
		this.content = content;
		this.date = date;
		this.isCheck="미확인";
	}
	
	/**
	 * @return the isCheck
	 */
	String getIsCheck() {
		return isCheck;
	}

	/**
	 * @param isCheck the isCheck to set
	 */
	void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}

	/**
	 * @return the num
	 */
	Integer getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return the sender
	 */
	String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the date
	 */
	String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the reciver
	 */
	String getReciver() {
		return reciver;
	}

	/**
	 * @param reciver the reciver to set
	 */
	void setReciver(String reciver) {
		this.reciver = reciver;
	}

	/**
	 * @return the title
	 */
	String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	void setContent(String content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mail [num=" + num + ", isCheck=" + isCheck + ", reciver=" + reciver + ", sender=" + sender + ", title="
				+ title + ", content=" + content + ", date=" + date + "]";
	}
}
