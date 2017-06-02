package types;

import helper.Helper;
import values.NullValue;

/**
 * Write a description of class IType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IType {
	public String getName();;

	public static IType random() {
		return random(randomClass());
	}

	public static <T extends IType> T random(Class<T> clazz) {
		if (clazz == BooleanType.class) {
			return (T) BooleanType.random();
		} else if (clazz == IntegerType.class) {
			return (T) IntegerType.random();
		} else if (clazz == VoidType.class) {
			return (T) new VoidType();
		} else {
			throw new RuntimeException("Bad Class Type: " + clazz.getCanonicalName());
		}
	}

	public static Class<? extends IType> randomClass() {
		switch (Helper.randomInt(0, 2)) {
		case 0:
			return BooleanType.class;
		case 1:
			return IntegerType.class;
		default:
			throw new RuntimeException("Unreachable!");
		}
	}
}
