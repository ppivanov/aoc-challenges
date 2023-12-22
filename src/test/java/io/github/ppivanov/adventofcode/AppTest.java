package io.github.ppivanov.adventofcode;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import io.github.ppivanov.adventofcode.dayone.DayOne;
import io.github.ppivanov.adventofcode.daytwo.DayTwo;

/**
 * Unit test for simple App.
 */
public class AppTest {
	@Test
	public void dayOne_One() throws FileNotFoundException, IOException {
		int expected = 54940;
		int actual = DayOne.GetResult(1);
		assertEquals(expected, actual);
	}

	@Test
	public void dayOne_Two() throws FileNotFoundException, IOException {
		int expected = 54208;
		int actual = DayOne.GetResult(2);
		assertEquals(expected, actual);
	}

	@Test
	public void dayTwo_One() throws FileNotFoundException, IOException {
		int expected = 3035;
		int actual = DayTwo.GetResult(1);
		assertEquals(expected, actual);
	}

	@Test
	public void dayTwo_Two() throws FileNotFoundException, IOException {
		int expected = 66027;
		int actual = DayTwo.GetResult(2);
		assertEquals(expected, actual);
	}
}
