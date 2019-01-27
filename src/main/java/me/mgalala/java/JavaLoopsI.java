package me.mgalala.java;

/**
 * https://www.hackerrank.com/challenges/java-loops-i/problem
 * 
 * @author mgalala
 *
 */
public class JavaLoopsI {

	public static void main(String[] args) {
		int N = 2;
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d\n", N, i, N * i);
		}
	}
}
