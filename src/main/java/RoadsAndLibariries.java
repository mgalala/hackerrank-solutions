import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class RoadsAndLibariries {
	public static void main(String[] args) {
		InputStream is = SpareArraysBruteForce.class.getClassLoader().getResourceAsStream("roads_libs.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		final Scanner scanner = new Scanner(br);

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String[] nmC_libC_road = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmC_libC_road[0]);

			int m = Integer.parseInt(nmC_libC_road[1]);

			int c_lib = Integer.parseInt(nmC_libC_road[2]);

			int c_road = Integer.parseInt(nmC_libC_road[3]);

			int[][] cities = new int[m][2];

			for (int i = 0; i < m; i++) {
				String[] citiesRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < 2; j++) {
					int citiesItem = Integer.parseInt(citiesRowItems[j]);
					cities[i][j] = citiesItem;
				}
			}

			long result = roadsAndLibraries(n, c_lib, c_road, cities);
			System.out.println(result);
		}

		scanner.close();
	}

	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		HashMap<Integer, TreeSet<Integer>> groupOfCities = new HashMap<>();
		HashMap<Integer, Integer> checkedRoads = new HashMap<>();

		for (int i = 0; i < cities.length; i++) {
			int firstOfPair = cities[i][0];
			int secondOfPair = cities[i][1];

			boolean firstOfPairExistInRoads = groupOfCities.containsKey(firstOfPair);
			boolean firstOfPairExistInCheckedRoads = checkedRoads.containsKey(firstOfPair);
			boolean secondOfPairExistInRoads = groupOfCities.containsKey(secondOfPair);
			boolean secondOfPairExistInCheckedRoads = checkedRoads.containsKey(secondOfPair);

			if (firstOfPairExistInRoads | firstOfPairExistInCheckedRoads | secondOfPairExistInRoads
					| secondOfPairExistInCheckedRoads) {
				if (firstOfPairExistInRoads || firstOfPairExistInCheckedRoads) {
					if (firstOfPairExistInRoads) {
						updateWhenSubjectExistsInRoads(groupOfCities, checkedRoads, firstOfPair, secondOfPair,
								secondOfPairExistInCheckedRoads);
					} else {
						// first pair exists in checked roads
						updateWhenSubjectExistsInCheckedRoads(groupOfCities, checkedRoads, firstOfPair, secondOfPair,
								secondOfPairExistInCheckedRoads);
					}

					if (groupOfCities.containsKey(secondOfPair) && groupOfCities.containsKey(firstOfPair)) {
						groupOfCities.get(firstOfPair).addAll(groupOfCities.get(secondOfPair));
						groupOfCities.remove(secondOfPair);
					}
				} else if (secondOfPairExistInRoads || secondOfPairExistInCheckedRoads) {
					if (secondOfPairExistInRoads) {
						updateWhenSubjectExistsInRoads(groupOfCities, checkedRoads, secondOfPair, firstOfPair,
								firstOfPairExistInCheckedRoads);
					} else {
						updateWhenSubjectExistsInCheckedRoads(groupOfCities, checkedRoads, secondOfPair, firstOfPair,
								firstOfPairExistInCheckedRoads);
					}
				}
			} else {
				TreeSet<Integer> connectedCities = new TreeSet<>();
				connectedCities.add(secondOfPair);
				connectedCities.add(firstOfPair);

				groupOfCities.put(firstOfPair, connectedCities);
				checkedRoads.put(secondOfPair, firstOfPair);
			}
		}

		int totalMinumum = 0;
		int totalCitiesAppeared = 0;
		// calculate costs of repairing roads
		for (Map.Entry<Integer, TreeSet<Integer>> entry : groupOfCities.entrySet()) {
			// calculate cost of fixing roads
			int size = entry.getValue().size();
			int costOfFixingRoadsInThisEntry = (Integer.valueOf(size - 1) * Integer.valueOf(c_road)) + c_lib;
			// calculate cost of building lib in each city
			int costOfLibInEachCity = size * c_lib;
			totalMinumum = totalMinumum + Math.min(costOfFixingRoadsInThisEntry, costOfLibInEachCity);
			totalCitiesAppeared = totalCitiesAppeared + size;
		}

		// if not all cities appeared in the algorithm, then there is no option but
		// building a lib in every absent city
		return totalMinumum + ((n - totalCitiesAppeared) * c_lib);
	}

	private static void updateWhenSubjectExistsInCheckedRoads(HashMap<Integer, TreeSet<Integer>> roads,
			HashMap<Integer, Integer> checkedRoads, int subject, int additional, boolean additonalExistInCheckedRoads) {
		Integer key = checkedRoads.get(subject);
		TreeSet<Integer> connectedCities = roads.get(key);
		if (connectedCities != null && !connectedCities.contains(additional)) {
			connectedCities.add(additional);
			if (!connectedCities.contains(key)) {
				connectedCities.add(key);
			}
		}

		if (!additonalExistInCheckedRoads) {
			checkedRoads.put(additional, key);
		}
	}

	private static void updateWhenSubjectExistsInRoads(HashMap<Integer, TreeSet<Integer>> roads,
			HashMap<Integer, Integer> checkedRoads, int subject, int additional,
			boolean additionalExistInCheckedRoads) {

		TreeSet<Integer> connectedCities = roads.get(subject);
		if (connectedCities != null && !connectedCities.contains(additional)) {
			connectedCities.add(additional);
			if (!connectedCities.contains(subject)) {
				connectedCities.add(subject);
			}
		}

		if (!additionalExistInCheckedRoads) {
			checkedRoads.put(additional, subject);
		}
	}
}
