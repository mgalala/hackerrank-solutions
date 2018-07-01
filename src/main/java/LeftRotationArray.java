import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LeftRotationArray {

	public static void main(String[] args) {
		InputStream is = HourGlassSum.class.getClassLoader().getResourceAsStream("leftrotation.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int n = 20;
		int shifts = 10;

		int[] input = new int[n];
		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			input[i] = aItem;
		}

		int[] output = leftRotate(input, shifts);
		for (int i = 0; i < output.length; i++) {
			if (i < output.length - 1) {
				System.out.print(output[i] + " ");
			} else {
				System.out.print(output[i]);
			}

		}

		scanner.close();
	}

	private static int[] leftRotate(int[] input, int shifts) {
		int[] output = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			int newPosition = i - shifts;
			if (newPosition < 0) {
				newPosition = newPosition + input.length;
			}
			output[newPosition] = input[i];
		}
		return output;
	}
}
