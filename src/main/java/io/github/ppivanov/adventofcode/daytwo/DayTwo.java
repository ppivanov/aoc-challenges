package io.github.ppivanov.adventofcode.daytwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import io.github.ppivanov.adventofcode.App;

public class DayTwo {
	public static void Run(int part) throws FileNotFoundException, IOException {
		System.out.println("Result...");
		System.out.println(GetResult(part));
	}

	public static int GetResult(int part) throws FileNotFoundException, IOException {
		String filename = (part == 1) ? "day2" : "day2p2";
		BufferedReader reader = App.readFile("src/main/resources/" + filename + ".txt");
		String currentLine = "";
		int accumulator = 0;

		while (true) {
			currentLine = reader.readLine();
			if (currentLine == null) {
				break;
			}

			accumulator += (part == 1) ? getIdIfEnoughCubes(currentLine)
					: DayTwoPartTwo.getIdIfEnoughCubes(currentLine);
		}

		reader.close();

		return accumulator;
	}

	private static int getIdIfEnoughCubes(String gameDetails) {
		// assume format "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
		String[] roundsStr = gameDetails.split(": ");
		String[] rounds = roundsStr[1].split("; ");
		for (String round : rounds) {
			for (String cubeStr : round.split(", ")) {
				String[] cubes = cubeStr.split(" ");
				int numOfCubes = Integer.parseInt(cubes[0]);

				// is the number going over the limit?
				if (numOfCubes > cubeLimits.get(cubes[1])) {
					return 0;
				}
			}
		}

		// if not exited already then it's valid
		return Integer.parseInt(roundsStr[0].split(" ")[1]);
	}

	private static HashMap<String, Integer> cubeLimits = new HashMap<String, Integer>() {
		private static final long serialVersionUID = 6088584098670949506L;

		{
			put("red", 12);
			put("green", 13);
			put("blue", 14);
		}
	};
}