package types;

import helper.Helper;

/**
 * Write a description of interface IFunctionType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IFunctionType extends IType {
	public enum FunctionTypes {
		VOID
	}

	public static IFunctionType random() {
        switch (Helper.randomInt(0, 2)) {
        case 0:
            return PrimativeType.random();
        // case 1: // return ObjectType.randomClass(); // TODO
        case 1:
            return new VoidType();
        default:
            throw new RuntimeException("Unreachable!");
        }
	}

	public static Class<? extends IFunctionType> randomClass() {
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

	public static IFunctionType randomNonVoid() {
		switch (Helper.randomInt(0, 1)) {
		case 0:
			return PrimativeType.random();
		case 1: // return ObjectType.randomClass(); // TODO
		default:
			throw new RuntimeException("Unreachable!");
		}
	}
}
