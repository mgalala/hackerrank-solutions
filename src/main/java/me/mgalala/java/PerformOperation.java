package me.mgalala.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation isOdd() {
		return n -> (n % 2 != 0);
	}

	public PerformOperation isPrime() {
		return a -> {
			for (int i = 2; 2 * i < a; i++) {
				if (a % i == 0)
					return false;
			}
			return true;
		};

	}

	public PerformOperation isPalindrome() {
		return s -> {
			String original, reverse;
			reverse = "";

			original = String.valueOf(s);
			for (int i = original.length() - 1; i >= 0; i--)
				reverse = reverse + original.charAt(i);

			return original.equals(reverse);
		};
	}

	public static class Solution {

		public static void main(String[] args) throws IOException {
			MyMath ob = new MyMath();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			PerformOperation op;
			boolean ret = false;
			String ans = null;
			while (T-- > 0) {
				String s = br.readLine().trim();
				StringTokenizer st = new StringTokenizer(s);
				int ch = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				if (ch == 1) {
					op = ob.isOdd();
					ret = ob.checker(op, num);
					ans = (ret) ? "ODD" : "EVEN";
				} else if (ch == 2) {
					op = ob.isPrime();
					ret = ob.checker(op, num);
					ans = (ret) ? "PRIME" : "COMPOSITE";
				} else if (ch == 3) {
					op = ob.isPalindrome();
					ret = ob.checker(op, num);
					ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

				}
				System.out.println(ans);
			}
		}
	}

}
