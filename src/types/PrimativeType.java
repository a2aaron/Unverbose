package types;

import helper.Helper;

/**
 * Write a description of class PrimativeType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class PrimativeType<T extends Object> extends Type<T> implements IPrimativeType<T>, IFunctionType<T> {
	enum PrimativeTypes {
		INT, BOOLEAN;
	}

	public PrimativeType(String name, T value) {
		super(name, value);
	}

	public static PrimativeType<?> random() {
		switch (Helper.getRandomElement(PrimativeTypes.values())) {
		case BOOLEAN:
			return BooleanType.random();
		case INT:
			return IntegerType.random();
		default:
			throw new RuntimeException("Unreachable!");
		}
	}

	public static Class<? extends IFunctionType<?>> randomClass() {
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
