/**
 * 
 */

/**
 * @author mgalala
 *         https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class CountingValley {
	static int countingValleys(int n, String s) {
		char[] charArray = s.toCharArray();
		boolean alreadyInValley = false;
		int toSeeLevel = 0;
		int count = 0;

		for (char c : charArray) {
			if (c == 'D') {
				toSeeLevel = toSeeLevel - 1;
			} else {
				toSeeLevel = toSeeLevel + 1;
			}

			if (toSeeLevel < 0 && !alreadyInValley && c == 'D') {
				if (!alreadyInValley) {
					alreadyInValley = true;
				}
				count++;
			} else if (toSeeLevel >= 0) {
				// he returned back to see level
				alreadyInValley = false;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU")); // 1
		System.out.println(countingValleys(8, "DDUUUUDD")); // 1
		System.out.println(countingValleys(12, "DDUUUUDDDDUU")); // 2
		System.out.println(countingValleys(12, "DDUUDDUDUUUD")); // 2
	}
}
