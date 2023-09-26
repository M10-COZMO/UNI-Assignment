package en.finedust;

import java.util.Scanner;

public class Week {
	
	private static final String ENTER_THE_YEAR = "Enter the year: ";
	private static final String ENTER_THE_NUMBER_OF_THE_WEEK = "Enter the number of the week: ";
	private static final String ENTER_THE_DATA_FOR_THIS_WEEK = "Enter the data for this week: ";
	private static final int DAY_IN_A_WEEK = 7;
	private static final String AVERAGE_VALUE_TOO_HIGH_ATTENTION_MESSAGE = "- ATTENTION AVERAGE VALUE TOO HIGH -";
	private static final String MAX_VALUE_TOO_HIGH_ALLARM_MESSAGE = "- ATTENTION MAX VALUE TOO HIGH -";
	private int year;
	private int nWeek;
	private double[] fineDustWeekValue = new double[DAY_IN_A_WEEK];
	
	public Week(int _year, int _nWeek, double[] _fineDustWeekValue) {
		this.year = _year;
		this.nWeek = _nWeek;
		this.fineDustWeekValue = _fineDustWeekValue;
	}
	
	public Week() {
		
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int _year) {
		this.year = _year;
	}
	
	public int getnWeek() {
		return nWeek;
	}
	
	public void setnWeek(int _nWeek) {
		this.nWeek = _nWeek;
	}
	
	public double[] getFineDustWeekValue() {
		return fineDustWeekValue;
	}
	
	public void setFineDustWeekValue(double[] _fineDustWeekValue) {
		this.fineDustWeekValue = _fineDustWeekValue;
	}
	
	private double maxValue() {
		double max = fineDustWeekValue[0];
		for (int i = 0; i <= fineDustWeekValue.length; i++) {
			if(fineDustWeekValue[i] > max) {
				max = fineDustWeekValue[i];
			}
		}
		return max;
	}
	
	private double averageValue() {
		double sum = 0;
		for (int i = 0; i < fineDustWeekValue.length; i++) {
			sum = sum + fineDustWeekValue[i];
		}
		return sum/fineDustWeekValue.length;
	}
	
	public String maxValueAllarm() {
		double x = maxValue();
		if(x > 75) {
			return MAX_VALUE_TOO_HIGH_ALLARM_MESSAGE;
		}
		return null;
	}
	
	public String averageValueAllarm() {
		double x = averageValue();
		if(x > 50) {
			return AVERAGE_VALUE_TOO_HIGH_ATTENTION_MESSAGE;
		}
		return null;
	}
	
	public void compileWeek() {
		Scanner in = new Scanner(System.in);
		
		System.out.println(ENTER_THE_YEAR);
		year = in.nextInt();
		
		System.out.println(ENTER_THE_NUMBER_OF_THE_WEEK);
		nWeek = in.nextInt();
		
		System.out.println(ENTER_THE_DATA_FOR_THIS_WEEK);
		for (int i = 0; i < fineDustWeekValue.length; i++) {
		}
	}

}
