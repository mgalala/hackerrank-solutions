package me.mgalala.java;

public class TestStaticOrder {
	private static int var = 1;
	static {
		System.out.printf("static block before: %s \n", var);
		var = 2;
		System.out.printf("static block after: %s \n", var);
	}

	public TestStaticOrder() {
		System.out.printf("constructor before %s \n", var);
		var = 3;
		System.out.printf("constructor after %s \n", var);
	}

	public int getVar() {
		return var;
	}

	public static void main(String[] args) {
		TestStaticOrder testStaticOrder = new TestStaticOrder();
		System.out.println(testStaticOrder.getVar());
	}
}
