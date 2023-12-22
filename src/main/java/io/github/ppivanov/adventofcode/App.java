package io.github.ppivanov.adventofcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import io.github.ppivanov.adventofcode.dayone.DayOne;
import io.github.ppivanov.adventofcode.daytwo.DayTwo;

// Advent of Code 2023
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int days = 2;
		boolean exit = false;
		while (!exit) {
			int daySelection = 0;
			int part = 0;
			try {
				System.out.println(getOption(""));
				System.out.println(getOption("Exit 0"));
				for (int d = 1; d <= days; d++) {
					for (int e = 1; e <= 2; e++) {
						System.out.println(getOption("Day " + d + " part " + e));
					}
				}
				System.out.println(getOption(""));
				System.out.print("Select a day: ");
				daySelection = input(scanner);
				System.out.print("Which part: ");
				part = input(scanner);
				System.out.println();
				if (part > 2) {
					daySelection = 0; //
				}

				switch (daySelection) {
				case 0:
					exit = true;
					break;
				case 1:
					DayOne.Run(part);
					continue;
				case 2:
					DayTwo.Run(part);
					continue;
				default:
					System.out.println("Invalid input! Please enter a number.");
					break;
				}
			} catch (Exception ex) {
				System.out.println("ERROR");
				System.out.println(ex.getMessage());
				ex.printStackTrace();
				break;
			}
		}

		System.out.println("Exiting...");
		scanner.close();
	}

	public static int input(final Scanner scanner) {
		try {
			int val = scanner.nextInt();
			return val;
		} catch (InputMismatchException ex) {
			ex.printStackTrace();
			scanner.nextLine();
			return -1;
		}
	}

	public static BufferedReader readFile(String filename) throws FileNotFoundException {
		InputStream ifs = new FileInputStream(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(ifs));

		return reader;
	}

	private static String getOption(final String text) {
		int width = 32;
		char padValue = '*';
		int textLength = text.length();
		boolean isOddLength = textLength % 2 == 1;

		int leftPad = (width - textLength) / 2;
		int rightPad = leftPad;
		if (isOddLength) {
			rightPad--;
		} else {
			rightPad -= 2;
		}

		if (textLength == 0) {
			return StringUtils.leftPad("", width, padValue);
		} else {
			return String.format("%s %s %s", StringUtils.leftPad("", leftPad, padValue), text,
					StringUtils.leftPad("", rightPad, padValue));
		}
	}
}
