package helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Write a description of class Helper here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Helper {
	public static final Random random = new Random();
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

	public static String capitalize(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}

	public static <T> T getRandomElement(T[] array) {
		return array[(Helper.randomInt(0, array.length))];
	}

	public static char randomCharacter() {
		int index = Helper.randomInt(0, Helper.alphabet.length());
		return Helper.alphabet.charAt(index);
	}

	public static int randomInt(int lower, int upper) {
		return random.nextInt(upper - lower) + lower;
	}

	public static String randomString(int length) {
		String string = "";
		for (int i = 0; i < length; i++) {
			string += randomCharacter();
		}
		return string;
	}
	
	public static <T extends Object> ArrayList<T> shuffle(ArrayList<T> input) {
	    ArrayList<T> output = (ArrayList<T>) input.clone();
	    Collections.shuffle(output);
	    return output;
	}
}
