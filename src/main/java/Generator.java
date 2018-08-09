import java.util.Random;

public class Generator {
	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			System.out.print(getRandomNumberInRange(1, 200000) + " ");
		}
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
