package day12.exam;

import java.util.Calendar;
import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
    	Exam01 q = new Exam01();
    	
    	Scanner sc = new Scanner(System.in);
    	boolean isExit = false;
    	while(!isExit) {
    		System.out.println("항목을 선택하세요 : (1. 특정년도 날짜보기, 2. 특정월  날짜 보기, 3. 종료)");
    		int menu = Integer.parseInt(sc.nextLine());
    		int year = -1;
    		int month = -1;
    		switch(menu) {
    		case 1:
    			System.out.println("년도를 입력하세요");
    			year = Integer.parseInt(sc.nextLine());
    			q.showYear(year);
    			break;
    		case 2:
    			System.out.println("년도를 입력하세요");
    			year = Integer.parseInt(sc.nextLine());
    			System.out.println("특정월를 입력하세요");
    			month = Integer.parseInt(sc.nextLine());
    			q.showYear(year, month);
    			break;
    		case 0:
    			isExit = true;
    			break;
    		}
    	}
	}
    
    private void showYear(int year) {
		Cals c = getCalendar(year);
		
		for(int zz=0; zz < c.size() ; zz++) {
			String[][] cals = c.getMonth(zz);
	    	for(int i=0; i < cals.length; i++) {
	    		if(i < 2) {
		    		for(String val : cals[i])
		    			System.out.print(val);
	    		} else {
	    			for(int j=0; j < cals[i].length; j++) {
	    				if(j % 7 == 0)
	    					System.out.println("");
	    				System.out.print(cals[i][j]);
	    			}
	    		}
	    	}
	    	System.out.println();
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
    
    
    private Cals getCalendar(int year) {
    	Calendar c = Calendar.getInstance();
    	Cals cals = new Cals();
    	for(int i=0; i < 12; i++) {
	    	c.set(year, i, 1);
	    	String[] dayWord = {
	                "  일   ", "   월   ", "   화   ", "   수   ", "   목   ", "   금   ", "   토  \n"
	        };
	    	
	    	String yearVal = String.valueOf(c.get(Calendar.YEAR))  +"년  "; // 년도
	    	String monthVal = String.valueOf(c.get(Calendar.MONTH) + 1)  +"월 \n"; // 년도
	    	int dayWeek = c.get(Calendar.DAY_OF_WEEK);
	    	
	    	String[][] monthArr = new String[3][];
	    	
	    	monthArr[0] = new String[]{yearVal, monthVal};
	    	monthArr[1] = dayWord;
	    	monthArr[2] = makeDays(dayWeek - 1, c);
	    	cals.addMonth(monthArr);
    	}
    	return cals;
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
