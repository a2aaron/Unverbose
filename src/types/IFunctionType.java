package types;

import helper.Helper;

/**
 * Write a description of interface IFunctionType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IFunctionType<T extends Object> extends IType<T> {
	public enum FunctionTypes {
		VOID
	}

	public static <T extends IFunctionType<?>> T random(Class<T> typeClass) {
		if (typeClass.getSuperclass() == PrimativeType.class) {
			return (T) PrimativeType.random();
		} else if (typeClass.getSuperclass() == ObjectType.class) {
			return (T) ObjectType.random();
		} else if (typeClass == VoidType.class) {
			return (T) new VoidType();
		}
		throw new RuntimeException("Unreachable! Class Name: " + typeClass.getCanonicalName());
	}

	public static Class<? extends IFunctionType<?>> randomClass() {
		switch (Helper.randomInt(0, 3)) {
		case 0:
			return PrimativeType.randomClass();
		case 1: // return ObjectType.randomClass(); // TODO
		case 2:
			return VoidType.class;
		default:
			throw new RuntimeException("Unreachable!");
		}
	}

	public static Class<? extends IFunctionType<?>> randomNonVoidClass() {
		switch (Helper.randomInt(0, 1)) {
		case 0:
			return PrimativeType.randomClass();
		case 1: // return ObjectType.randomClass(); // TODO
		default:
			throw new RuntimeException("Unreachable!");
		}
	}
}
