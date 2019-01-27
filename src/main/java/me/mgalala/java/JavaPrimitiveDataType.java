package me.mgalala.java;

/**
 * https://www.hackerrank.com/challenges/java-datatypes
 * 
 * @author mgalala
 *
 */
class JavaPrimitiveDataType {
	public static void main(String[] argh) {

		String[] arr = { "-150", "150000", "1500000000", "213333333333333333333333333333333333", "-100000000000000" };
		String[] arr1 = { "0", "1", "-1", "18446744073709551616", "-18446744073709551616", "18446744073709551615",
				"-18446744073709551616", "32768", "-32768", "32767", "-32767", "2147483648", "2147483647",
				"-2147483648", "-214748364", "128", "127", "-128", "-127", "123123123333333333333333333333333313123123",
				"234444444444444444444444444444444444444", "-1222222" };
		print(arr1);
	}

	private static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			try {
				long x = Long.valueOf(arr[i]);

				System.out.println(x + " can be fitted in:");
				if (x >= -128 && x <= 127)
					System.out.println("* byte");
				if (x >= -Math.pow(2, 15) && x < Math.pow(2, 15))
					System.out.println("* short");
				if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1)
					System.out.println("* int");
				if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63) - 1)
					System.out.println("* long");
			} catch (Exception e) {
				System.out.println(arr[i] + " can't be fitted anywhere.");
			}

		}
	}
}
