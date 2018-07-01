import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddNumbersWithList {

	static int[] oddNumbers(int l, int r) {
		List<Integer> ouput = new ArrayList<>();

		for (int i = l; i <= r; i++) {
			if (i >= 1 && (i & 1) != 0) {
				// it is odd
				ouput.add(i);
			}

		}

		int[] ret = new int[ouput.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = ouput.get(i).intValue();
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(Arrays.toString(oddNumbers(1, 1)));
	}
}
