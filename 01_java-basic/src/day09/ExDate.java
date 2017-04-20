package day09;

import java.util.Calendar;

public class ExDate {
	private int year;
	private int month;
	private int day;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public ExDate(int i, int j, int k) {
		this.year = i;
		this.month = j;
		this.day = k;
	}

	public ExDate() {
		this(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1,
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	}

	public void showData() {
		System.out.printf("%d년 %d월 %d일 \n", year, month, day);		
	}

}
