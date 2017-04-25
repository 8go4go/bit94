package day12.exam;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
    	Exam02 q = new Exam02();
    	
    	Scanner sc = new Scanner(System.in);
    	boolean isExit = false;
    	Calendar c = Calendar.getInstance();
    	c.setTime(new Date());
    	
    	int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		
    	while(!isExit) {
    		System.out.println("항목을 선택하세요 : (1. 현재달, 2. 이전달, 3. 더움덜, 4. 종료)");
    		int menu = Integer.parseInt(sc.nextLine());
    		
    		switch(menu) {
    		case 1:
    			c.setTime(new Date());
    			year = c.get(Calendar.YEAR);
    			System.out.println("특정월를 입력하세요");
    			month = c.get(Calendar.MONTH) + 1;
    			q.showYear(year, month);
    			break;
    		case 2:
    			System.out.println("이전달선택하셨습니다.");
    			month = month - 1;
    			if(month < 0) {
    				month = 12;
    				year = year - 1;
    			}
    			
    			q.showYear(year, month);
    			break;
    		case 3:
    			System.out.println("이후달선택하셨습니다.");
    			month = month + 1;
    			
    			if(month > 12) {
    				month = 0;
    				year = year + 1;
    			}
    			q.showYear(year, month);
    			break;
    		case 4:
    			isExit = true;
    			break;
    		}
    	}
	}
    
    
	private void showYear(int year, int month) {
		String[][] cals = getCalendar(year, month);
		for (int i = 0; i < cals.length; i++) {
			if (i < 2) {
				for (String val : cals[i])
					System.out.print(val);
			} else {
				for (int j = 0; j < cals[i].length; j++) {
					if (j % 7 == 0)
						System.out.println("");
					System.out.print(cals[i][j]);
				}
			}
		}
	}
    
    private String[][] getCalendar(int year, int month) {
    	Calendar c = Calendar.getInstance();
    	c.set(year, month - 1, 1);
    	String[] dayWord = {
                "  일   ", "   월   ", "   화   ", "   수   ", "   목   ", "   금   ", "   토  \n"
        };
    	
    	String yearVal = String.valueOf(c.get(Calendar.YEAR))  +"년  "; // 년도
    	String monthVal = String.valueOf(c.get(Calendar.MONTH) + 1)  +"월 \n"; // 년도
    	int dayWeek = c.get(Calendar.DAY_OF_WEEK);
    	
    	String[][] cals = new String[3][];
    	
    	cals[0] = new String[]{yearVal, monthVal};
    	cals[1] = dayWord;
    	cals[2] = makeDays(dayWeek - 1, c);
    	return cals;
    }
    
    private String[] makeDays(int skip, Calendar c) {
    	String[] cals = new String[42];
    	
    	c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    	
    	int day = 1;
    	for(int i=0; i< cals.length; i++) {
    		if(skip > i) {
    			cals[i] = "  " + "  ";
    		} else {
    			if(c.get(Calendar.DATE) >= day)
    				if(day < 10)
    					cals[i] = " " + String.valueOf(day++) + "  ";
    				else
    					cals[i] = String.valueOf(day++) + "  ";
    			else 
    				cals[i] = "";
    		}
    	}
    	return cals;
    }

}
