package me.mgalala.java;

public class JavaLoopII {
	public static void main(String[] argh) {
		int a = 5;
		int b = 3;
		int n = 5;

		for (int j = 0; j < n; j++) {
			a += b;
			System.out.print(a + " ");
			b *= 2;
		}
		System.out.printf("\n");
	}
}