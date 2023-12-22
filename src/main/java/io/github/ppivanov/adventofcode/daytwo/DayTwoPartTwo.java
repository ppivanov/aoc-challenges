package io.github.ppivanov.adventofcode.daytwo;

import java.util.HashMap;
import java.util.Map.Entry;

public class DayTwoPartTwo {
	public static int getIdIfEnoughCubes(String gameDetails) {
		// assume format "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
		HashMap<String, Integer> minCubeCount = new HashMap<String, Integer>();

		String[] roundsStr = gameDetails.split(": ");
		String[] rounds = roundsStr[1].split("; ");
		for (String round : rounds) {
			for (String cubeStr : round.split(", ")) {
				String[] cubes = cubeStr.split(" ");
				int numOfCubes = Integer.parseInt(cubes[0]);
				String color = cubes[1];

				evalNewCubePair(minCubeCount, color, numOfCubes);
			}
		}

		int setPower = 1;
		for (Entry<String, Integer> entry : minCubeCount.entrySet()) {
			setPower *= entry.getValue();
		}

		// if not exited already then it's valid
		return setPower;
	}

	private static void evalNewCubePair(HashMap<String, Integer> minCubeCount, String color, int numOfCubes) {
		if (!minCubeCount.containsKey(color)) {
			minCubeCount.put(color, numOfCubes);
		} else if (numOfCubes > minCubeCount.get(color)) {
			minCubeCount.replace(color, numOfCubes);
		}
	}
}
