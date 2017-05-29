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
public class VariableSignature<T extends IType<?>> implements ISignature<T> {
	Visibility visibility;
	Static isStatic;
	Final isFinal;
	T type;

	public VariableSignature(T type) {
		this(Visibility.NONE, Static.NONE, Final.NONE, type);
	}

	public VariableSignature(Visibility visibility, Static isStatic, Final isFinal, T type) {
		this.visibility = visibility;
		this.isStatic = isStatic;
		this.isFinal = isFinal;
		this.type = type;
	}

	public VariableSignature(Visibility visibility, T type) {
		this(visibility, Static.NONE, Final.NONE, type);
	}

	public Final getFinal() {
		return isFinal;
	}

	public Static getStatic() {
		return isStatic;
	}

	@Override
    public T getType() {
		return type;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	@Override
    public void setType(T type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return visibility.getValue() + isStatic.getValue() + isFinal.getValue() + type.getName();
	}

	public static <T extends IType<?>> VariableSignature<T> random(Class<T> typeClass) {
		Visibility visibility = Helper.getRandomElement(Visibility.values());
		Static isStatic = Helper.getRandomElement(Static.values());
		Final isFinal = Helper.getRandomElement(Final.values());
		T type = IType.random(typeClass);
		return new VariableSignature<T>(visibility, isStatic, isFinal, type);
	}
}
