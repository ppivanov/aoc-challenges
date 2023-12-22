package io.github.ppivanov.adventofcode;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

// Advent of Code 2023
public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int days = 2;
		boolean exit = false;
		while (!exit) {
			int daySelection = 0;
			try {
				System.out.println(getOption(""));
				System.out.println(getOption("Exit 0"));
				for (int i = 1; i <= days; i++) {
					System.out.println(getOption("Day " + i));
				}
				System.out.println(getOption(""));
				System.out.print("Select a day: ");
				daySelection = input(scanner);
				System.out.println();

				switch (daySelection) {
				case 0:
					exit = true;
					break;
				case 1:
					DayOne.Run();
					continue;
				case 2:
					DayTwo.Run();
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
