package io.github.ppivanov.adventofcode.dayone;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang3.tuple.ImmutablePair;

public class DayOnePartTwo {
	public static ImmutablePair<Integer, Integer> getFirstAndLastInt(String str) {
		int left = -1;
		int right = -1;

		int iLeft = -1;
		int iRight = -1;

		for (String numStr : numsArray) {
			int first = str.indexOf(numStr);
			int last = str.lastIndexOf(numStr);

			if (first != -1 && (first < iLeft || iLeft == -1)) {
				iLeft = first;
				left = numberMap.get(str.substring(iLeft, iLeft + numStr.length()));
			}
			if (last != -1 && last > iRight) {
				iRight = last;
				right = numberMap.get(str.substring(iRight, iRight + numStr.length()));
			}
		}

		return new ImmutablePair<Integer, Integer>(left, right);
	}

	private static HashMap<String, Integer> numberMap = new HashMap<String, Integer>() {
		private static final long serialVersionUID = -7814928221765248092L;

		{
			put("one", 1);
			put("two", 2);
			put("three", 3);
			put("four", 4);
			put("five", 5);
			put("six", 6);
			put("seven", 7);
			put("eight", 8);
			put("nine", 9);
			put("1", 1);
			put("2", 2);
			put("3", 3);
			put("4", 4);
			put("5", 5);
			put("6", 6);
			put("7", 7);
			put("8", 8);
			put("9", 9);
		}
	};

	private static ArrayList<String> numsArray = new ArrayList<String>() {
		private static final long serialVersionUID = 4399420966173079583L;

		{
			add("one");
			add("two");
			add("three");
			add("four");
			add("five");
			add("six");
			add("seven");
			add("eight");
			add("nine");
			add("1");
			add("2");
			add("3");
			add("4");
			add("5");
			add("6");
			add("7");
			add("8");
			add("9");
		}
	};
}