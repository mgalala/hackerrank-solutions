package me.mgalala.java;

/**
 * https://www.hackerrank.com/challenges/java-output-formatting/problem?h_r=next-challenge&h_v=zen
 * 
 * @author mgalala
 *
 */
public class StringFormat {

	public static void main(String[] args) {
		String[] strings = { "java", "cpp", "python" };
		int[] integers = { 100, 65, 50 };
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = strings[i];
			int x = integers[i];

			System.out.printf("%-15s%03d\n", s1, x);
		}
		System.out.println("================================");

	}
}
