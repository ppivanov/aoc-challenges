package io.github.ppivanov.adventofcode.dayone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.ppivanov.adventofcode.App;

public class DayOne {
	public static void Run(int part) throws FileNotFoundException, IOException {
		System.out.println("Result...");
		System.out.println(GetResult(part));
	}

	public static int GetResult(int part) throws FileNotFoundException, IOException {
		String filename = (part == 1) ? "day1" : "day1p2";
		BufferedReader reader = App.readFile("src/main/resources/" + filename + ".txt");
		String currentLine = "";
		int left = -1;
		int right = -1;
		int out = 0;

		while (true) {
			currentLine = reader.readLine();
			if (currentLine == null) {
				break;
			}

			ImmutablePair<Integer, Integer> pair = (part == 1) ? getFirstAndLastInt(currentLine)
					: DayOnePartTwo.getFirstAndLastInt(currentLine);

			left = pair.getLeft();
			right = pair.getRight();

			right = right != -1 ? right : left; // if last is not set, default to first
			out += (left * 10 + right);

			left = -1; // reset
			right = -1;
		}

		reader.close();

		return out;
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