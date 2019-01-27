package me.mgalala.java;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * https://www.hackerrank.com/challenges/java-currency-formatter/problem
 * 
 * @author mgalala
 *
 */
public class CurrencyFormatter {

	public static void main(String[] args) {
		double payment = Double.valueOf("12324.134");

		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("US: " + nf.format(payment));

		Locale indianLocale = new Locale(Locale.ENGLISH.toString(), "IN");

		nf = NumberFormat.getCurrencyInstance(indianLocale);
		System.out.println("India: " + nf.format(payment));

		nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println("China: " + nf.format(payment));

		nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		nf.setMaximumFractionDigits(2);
		System.out.println("France: " + nf.format(payment));
	}
}