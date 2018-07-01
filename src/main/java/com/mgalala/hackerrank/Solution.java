package com.mgalala.hackerrank;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int[] oddNumbers(int l, int r) {
		return null;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int l = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int r = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int[] res = oddNumbers(l, r);

		for (int resItr = 0; resItr < res.length; resItr++) {
			bufferedWriter.write(String.valueOf(res[resItr]));

			if (resItr != res.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
