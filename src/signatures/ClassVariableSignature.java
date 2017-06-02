package signatures;

import helper.Helper;
import signatures.IClassLevelSignature.Final;
import signatures.IClassLevelSignature.Static;
import signatures.IClassLevelSignature.Visibility;
import types.IType;

/**
 * Write a description of class VariableSignature here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassVariableSignature<T extends IType> implements ISignature<T> {
	Visibility visibility;
	Static isStatic;
	Final isFinal;
	T type;
	
	public ClassVariableSignature(T type) {
		this(Visibility.NONE, Static.NONE, Final.NONE, type);
	}

	public ClassVariableSignature(Visibility visibility, Static isStatic, Final isFinal, T type) {
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.type = type;
	}

	public ClassVariableSignature(Visibility visibility, T type) {
		this(visibility, Static.NONE, Final.NONE, type);
	}

	public Final getFinal() {
		return isFinal;
	}

	public Static getStatic() {
		return isStatic;
	}

	public Visibility getVisibility() {
		return visibility;
	}
	
	public T getType() {
	    return type;
	}

	@Override
	public String toString() {
		return visibility.getValue() + isStatic.getValue() + isFinal.getValue() + type.getName();
	}

	public static <T extends IType> ClassVariableSignature<T> random(Class<T> clazz) {
		Visibility visibility = Helper.getRandomElement(Visibility.values());
		Static isStatic = Helper.getRandomElement(Static.values());
		Final isFinal = Helper.getRandomElement(Final.values());
		T type = IType.random(clazz);
		return new ClassVariableSignature<T>(visibility, isStatic, isFinal, type);
	}
}
