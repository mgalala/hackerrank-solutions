import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AnagramSolution {
	public static void main(String[] args) {
		System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}

	static int makeAnagram(String a, String b) {
		HashMap<Character, Integer> aMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> bMap = new HashMap<Character, Integer>();

		for (int i = 0, j = 0; i < a.length() || j < b.length(); i++, j++) {
			if (i < a.length()) {
				Integer count = aMap.get(a.charAt(i));
				aMap.put(a.charAt(i), count == null || count == 0 ? 1 : count + 1);
			}

			if (j < b.length()) {
				Integer count = bMap.get(b.charAt(j));
				bMap.put(b.charAt(j), count == null || count == 0 ? 1 : count + 1);
			}
		}
		int countOfDifference = 0;

		Set<Character> itemFoundInB = new HashSet<>();

		for (java.util.Map.Entry<Character, Integer> entry : aMap.entrySet()) {
			Character character = entry.getKey();
			Integer countInA = entry.getValue();

			Integer countInB = bMap.get(character);
			if (countInB != null) {
				itemFoundInB.add(character);
				countOfDifference = countOfDifference + Math.abs(countInA - countInB);
			} else {
				countOfDifference = countOfDifference + countInA;
			}
		}

		Set<Character> bMapKeySet = bMap.keySet();
		bMapKeySet.removeAll(itemFoundInB);
		for (Character character : bMapKeySet) {
			countOfDifference = countOfDifference + bMap.get(character);
		}

		return countOfDifference;
	}
}
