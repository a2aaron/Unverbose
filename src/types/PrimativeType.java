package types;

import helper.Helper;

/**
 * Write a description of class PrimativeType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class PrimativeType extends Type implements IPrimativeType, IFunctionType {
	enum PrimativeTypes {
		INT, BOOLEAN;
	}

	public PrimativeType(String name) {
		super(name);
	}

	public static PrimativeType random() {
		switch (Helper.getRandomElement(PrimativeTypes.values())) {
		case BOOLEAN:
			return new BooleanType();
		case INT:
			return new IntegerType();
		default:
			throw new RuntimeException("Unreachable!");
		}
	}

	public static Class<? extends IFunctionType> randomClass() {
		switch (Helper.getRandomElement(PrimativeTypes.values())) {
		case BOOLEAN:
			return BooleanType.class;
		case INT:
			return IntegerType.class;
		default:
			throw new RuntimeException("Unreachable!");
		}
	}
}
