import java.util.TreeMap;

public class IceCreamParlor {
	public static void main(String[] args) {
		int[] cost = { 1, 4, 5, 3, 2 };
		int money = 4;

		TreeMap<Integer, Integer> keysIndexed = new TreeMap<>();

		for (int i = 0; i < cost.length; i++) {
			int flavorCost = cost[i];
			if (flavorCost >= money) {
				continue;
			}

			if (keysIndexed.containsKey(money - flavorCost)) {
				System.out.println(keysIndexed.get(money - flavorCost) + " " + (i + 1));
				break;
			} else {
				keysIndexed.put(flavorCost, i + 1);
			}

		}
	}
}
