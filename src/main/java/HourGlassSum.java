import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HourGlassSum {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		int maxSum = Integer.MIN_VALUE;
		int hourGlassSum = 0;
		for (int i = 0; i <= arr.length - 3; i++) {
			for (int j = 2; j < arr[0].length; j++) {
				hourGlassSum = // first row
						arr[i][j - 2] + arr[i][j - 1] + arr[i][j]
						// second roÏw
								+ arr[i + 1][j - 1]
								// third row
								+ arr[i + 2][j - 2] + arr[i + 2][j - 1] + arr[i + 2][j];
				maxSum = Math.max(maxSum, hourGlassSum);
			}
		}
		return maxSum;
	}

	public static void main(String[] args) throws FileNotFoundException {
		InputStream is = HourGlassSum.class.getClassLoader().getResourceAsStream("hourglass.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int nRows = 6;
		int nColumns = 6;

		int[][] arr = new int[nRows][nColumns];

		for (int i = 0; i < nRows; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < nColumns; j++) {
				int arrItem = 0;
				try {
					arrItem = Integer.parseInt(arrRowItems[j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					// System.err.println("Element couldn't be found");
				}

				arr[i][j] = arrItem;
			}
		}

		System.out.println(hourglassSum(arr));
		scanner.close();
	}
}
