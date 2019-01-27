package me.mgalala.java;

/**
 * https://www.hackerrank.com/challenges/java-if-else/problem
 * 
 * @author mgalala
 *
 */
public class IfConditions {

	public static void main(String[] args) {
		int N = 3;

		if (N % 2 == 1 || ((6 <= N) && (N <= 20) && N % 2 == 0)) {
			System.out.println("Weird");
		} else if (((2 <= N) && N <= 5 && N % 2 == 0) || (20 < N && N % 2 == 0)) {
			System.out.println("Not Weird");
		}
	}
}