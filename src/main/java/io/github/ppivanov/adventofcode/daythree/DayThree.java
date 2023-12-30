package io.github.ppivanov.adventofcode.daythree;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.ppivanov.adventofcode.App;

public class DayThree {
	public static void Run(int part) throws FileNotFoundException, IOException {
		System.out.println("Result...");
		System.out.println(GetResult(part));
	}

	public static int GetResult(int part) throws FileNotFoundException, IOException {
		String filename = (part == 1) ? "day3" : "day3p2";
		List<String> inputLines = App.readAllLines("src/main/resources/" + filename + ".txt");
		int out = 0;

		for (int i = 0; i < inputLines.size(); i++) {
			String priorLine = i > 0 ? inputLines.get(i - 1) : null;
			String currentLine = inputLines.get(i);
			String nextLine = i < inputLines.size() - 1 ? inputLines.get(i + 1) : null;
			int start = 0;
			int end = 0;
			for (int j = 0; j < currentLine.length(); j++) {
				if (nums.contains(currentLine.charAt(j))) {
					start = j;
					end = endIndex(start, currentLine);
					j = end + 1; // skip forward
					if (isPartNumber(start, end, priorLine, currentLine, nextLine)) {
						out += Integer.parseInt(currentLine.substring(start, end + 1)); // "end + 1" cause substring is
																						// weird
					}
				}
			}
		}

		return out;
	}

	private static int endIndex(int start, String line) {
		int index = start;
		for (int i = start + 1; i < line.length(); i++) {
			if (nums.contains(line.charAt(i))) {
				index = i;
			} else {
				break;
			}
		}

		return index;
	}

	private static boolean isPartNumber(int start, int end, String priorLine, String currentLine, String nextLine) {
		// check current line cause it's cheaper
		if ((start > 0 && isSymbol(currentLine.charAt(start - 1))
				|| (end < currentLine.length() - 1 && isSymbol(currentLine.charAt(end + 1))))) {
			return true;
		}

		int loopStart = start > 0 ? start - 1 : start;
		int loopEnd = end < currentLine.length() - 1 ? end + 1 : end;
		for (int i = loopStart; i <= loopEnd; i++) {
			// default to period if it first or last line
			char plc = priorLine != null ? priorLine.charAt(i) : '.';
			char nlc = nextLine != null ? nextLine.charAt(i) : '.';

			if (isSymbol(plc) || isSymbol(nlc)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isSymbol(char c) {
		return c != '.' && !nums.contains(c);
	}

	private static ArrayList<Character> nums = new ArrayList<Character>() {
		private static final long serialVersionUID = 9150518926892961008L;

		{
			add('0');
			add('1');
			add('2');
			add('3');
			add('4');
			add('5');
			add('6');
			add('7');
			add('8');
			add('9');
		}
	};
}
