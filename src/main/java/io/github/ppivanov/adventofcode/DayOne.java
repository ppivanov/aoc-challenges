package io.github.ppivanov.adventofcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class DayOne {
	public static void Run() throws FileNotFoundException, IOException {
		String file = "src/main/resources/day1.txt";
		InputStream ifs = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(ifs));
		String currentLine = "";
		int left = -1;
		int right = -1;
		int out = 0;

		while (true) {
			currentLine = reader.readLine();
			if (currentLine == null) {
				break;
			}

			ImmutablePair<Integer, Integer> a = getFirstAndLastInt(currentLine);
			left = a.getLeft();
			right = a.getRight();

			right = right != -1 ? right : left; // if last is not set, default to first
			out += (left * 10 + right);

			left = -1; // reset
			right = -1;
		}

		reader.close();

		System.out.println("Result...");
		System.out.println(out);
	}

	public static int getInt(char ch) {
		try {
			int val = Integer.parseInt(String.valueOf(ch));
			return val;
		} catch (NumberFormatException ex) {
			return -1;
		}
	}

	public static ImmutablePair<Integer, Integer> getFirstAndLastInt(String str) {
		int left = -1;
		int right = -1;

		for (char ch : str.toCharArray()) {
			int val = getInt(ch);
			if (val != -1) {
				if (left == -1) {
					left = val;
				} else {
					right = val;
				}
			}
		}

		return new ImmutablePair<Integer, Integer>(left, right);
	}
}