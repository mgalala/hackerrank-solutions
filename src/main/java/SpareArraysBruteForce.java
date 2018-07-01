import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SpareArraysBruteForce {

	// Complete the matchingStrings function below.
	static int[] matchingStrings(String[] strings, String[] queries) {
		int[] output = new int[queries.length];
		int numberOfMatches = 0;
		for (int i = 0; i < queries.length; i++) {
			for (int j = 0; j < strings.length; j++) {
				if (queries[i].equals(strings[j])) {
					numberOfMatches++;
				}
			}
			output[i] = numberOfMatches;
			numberOfMatches = 0;
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		InputStream is = SpareArraysBruteForce.class.getClassLoader().getResourceAsStream("sparearrays.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int stringsCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}

		int queriesCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		int[] res = matchingStrings(strings, queries);
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < res.length; i++) {
			output.append(String.valueOf(res[i]));

			if (i != res.length - 1) {
				output.append("\n");
			}
		}
		System.out.println(output.toString());
		scanner.close();
	}
}