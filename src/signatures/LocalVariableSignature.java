package signatures;

import types.IType;

/**
 * Write a description of class Signature here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class LocalVariableSignature<T extends IType> implements ISignature<T> {
	T type;

	public LocalVariableSignature(T type){ 
	    this.type = type;
	}
	
	public T getType() {
	    return type;
	}

	@Override
	public String toString() {
		return type.getName();
	}

	public static LocalVariableSignature<?> random() {
		return new LocalVariableSignature(IType.random());
	}
}
