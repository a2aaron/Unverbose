package types;

import helper.Helper;

/**
 * Write a description of class IType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IType {
	public String getName();

	public static IType random() {
        switch (Helper.randomInt(0, 2)) {
        case 0:
            return new BooleanType();
        case 1:
            return new IntegerType();
        default:
            throw new RuntimeException("Unreachable!");
        }
	}

	   public static IType randomWithVoid() {
	        switch (Helper.randomInt(0, 2)) {
	        case 0:
	            return new BooleanType();
	        case 1:
	            return new IntegerType();
	        case 2:
	            return new VoidType();
	        default:
	            throw new RuntimeException("Unreachable!");
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
