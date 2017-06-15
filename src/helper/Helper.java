package helper;

import java.util.ArrayList;
import java.util.Collection;
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
	    if (array.length == 0) {
	        throw new RuntimeException("Array is empty!");
	    }
		return array[(Helper.randomInt(0, array.length))];
	}

	public static char randomCharacter() {
		int index = Helper.randomInt(0, Helper.alphabet.length());
		return Helper.alphabet.charAt(index);
	}

	public static int randomInt(int lower, int upper) {
	    if (upper - lower <= 0) {
	        throw new RuntimeException("Bad Bound: " + (upper - lower) + " lower: " + lower + " upper: " + upper);
	    }
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

    public static int randomFactor(int value) {
        return getRandomElement(factors(value).toArray(new Integer[0]));
    }
    
    public static Collection<Integer> factors(int value) {
        Collection<Integer> factors = new ArrayList<Integer>();
        if (value == 0) {
            return factors;
        }
        if (value < 0) {
            value *= -1;
        }
        
        for (int i = 1; i * i <= value; i++) {
            if (value % i == 0) {
                factors.add(i);
                factors.add(value / i);
            }
        }
        return factors;
    }
}
