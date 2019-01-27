package me.mgalala.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EndOfFile {

	public static void main(String[] args) {
		withSystemIn();

		withFile();
	}

	private static void withFile() {
		try (Stream<String> stream = Files
				.lines(Paths.get("src", "main", "resources", "me", "mgalala", "java", "eof_test.txt"))) {
			AtomicInteger counter = new AtomicInteger(0);

			stream.forEach(e -> {
				counter.getAndIncrement();
				System.out.printf("%s %s\n", counter.get(), e);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void withSystemIn() {
		AtomicInteger counter = new AtomicInteger(0);

		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
		final Spliterator<String> splt = Spliterators.spliterator(scanner, Long.MAX_VALUE,
				Spliterator.ORDERED | Spliterator.NONNULL);
		StreamSupport.stream(splt, false).forEach(e -> {
			counter.getAndIncrement();
			System.out.printf("%s %s\n", counter.get(), e);
		});
	}
}