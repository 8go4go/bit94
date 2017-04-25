package day12.exam;

import java.util.Calendar;

public class Quiz01 {
    public static void main(String[] args) {
    	Quiz01 q = new Quiz01();
    	
    	String[][] cals = q.getCalendar(2017, 4);
    	
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
	}
    
    private String[][] getCalendar(int year, int month) {
    	Calendar c = Calendar.getInstance();
    	c.set(year, month, 1);
    	String[] dayWord = {
                "  일   ", "   월   ", "   화   ", "   수   ", "   목   ", "   금   ", "   토  \n"
        };
    	
    	String yearVal = String.valueOf(c.get(Calendar.YEAR))  +"년  "; // 년도
    	String monthVal = String.valueOf(c.get(Calendar.MONTH) + 1)  +"월 \n"; // 년도
    	int dayWeek = c.get(Calendar.DAY_OF_WEEK);
    	
    	String[][] cals = new String[3][];
    	
    	cals[0] = new String[]{yearVal, monthVal};
    	cals[1] = dayWord;
    	cals[2] = make7(dayWeek - 1, c);
    	return cals;
    }
    
    private String[] make7(int skip, Calendar c) {
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
