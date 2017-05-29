package signatures;

import helper.Helper;
import signatures.IClassLevelSignature.Final;
import signatures.IClassLevelSignature.Static;
import signatures.IClassLevelSignature.Visibility;
import types.IFunctionType;
import types.IType;
import types.VoidType;

/**
 * Write a description of class FunctionSignature here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunctionSignature<T extends IFunctionType<?>> extends Signature<T> implements ISignature<T> {
	public FunctionSignature(Visibility visibility, Static isStatic, Final isFinal, T type) {
		super(visibility, isStatic, isFinal, type);
	}

	public FunctionSignature(Visibility visibility, T type) {
		super(visibility, type);
	}

	public static <T extends IType<?>> Signature<T> random(Class<T> typeClass) {
		throw new RuntimeException("use randomFunctionSignature");
	}

	// TODO: figure out how to type parametize this without name clashes
	public static <T extends IFunctionType<?>> FunctionSignature<T> randomFunctionSignature(Class<T> typeClass) {
		Visibility visibility = Helper.getRandomElement(Visibility.values());
		Static isStatic = Helper.getRandomElement(Static.values());
		Final isFinal = Helper.getRandomElement(Final.values());
		T type = IFunctionType.random(typeClass);
		return new FunctionSignature<T>(visibility, isStatic, isFinal, type);
	}

	public static FunctionSignature<VoidType> randomVoid() {
		Visibility visibility = Helper.getRandomElement(Visibility.values());
		Static isStatic = Helper.getRandomElement(Static.values());
		Final isFinal = Helper.getRandomElement(Final.values());
		VoidType type = new VoidType();
		return new FunctionSignature<VoidType>(visibility, isStatic, isFinal, type);
	}
}
