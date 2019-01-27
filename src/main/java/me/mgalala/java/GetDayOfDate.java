/**
 * 
 */
package me.mgalala.java;

/**
 * @author mgalala
 *         https://www.hackerrank.com/challenges/java-date-and-time/problem
 */
public class GetDayOfDate {

	public static void main(String[] args) {
		System.out.println(getDay("15", "9", "2018"));
	}

	private static String getDay(String i, String j, String k) {
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(Integer.parseInt(k), Integer.parseInt(j) - 1, Integer.parseInt(i));

		return calendar
				.getDisplayName(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.LONG, java.util.Locale.getDefault())
				.toUpperCase();

	}
}
