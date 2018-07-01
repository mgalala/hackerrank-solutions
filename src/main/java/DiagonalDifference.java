public class DiagonalDifference {

	static int diagonalDifference(int[][] arr) {
		int leftToRightSum = 0;
		int rightToLeftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					// it is left to right diagonal
					leftToRightSum = leftToRightSum + arr[i][j];
				}

				if ((i + j) == (arr.length) - 1) {
					// it is right to left diagonal
					rightToLeftSum = rightToLeftSum + arr[i][j];
				}
			}
		}

		return Math.abs(leftToRightSum - rightToLeftSum);
	}

	public static void main(String[] args) {
		int n = 3;
		// 11 2 4
		// 4 5 6
		// 10 8 -12
		int[][] arr = new int[n][n];
		arr[0][0] = 11;
		arr[0][1] = 2;
		arr[0][2] = 4;

		arr[1][0] = 4;
		arr[1][1] = 5;
		arr[1][2] = 6;

		arr[2][0] = 10;
		arr[2][1] = 8;
		arr[2][2] = -12;
		System.out.println(diagonalDifference(arr));
	}
}
