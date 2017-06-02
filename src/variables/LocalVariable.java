package variables;

import signatures.ClassVariableSignature;
import signatures.LocalVariableSignature;
import types.IType;
import values.IValue;

public class LocalVariable<T extends IType> extends Variable<T> {
	public LocalVariable(LocalVariableSignature<T> type, String name) {
		super(type, name);
	}

	@Override
    public String toString() {
		return getSignature().getType().getName() + " " + getName();
	}

	public static LocalVariable<? extends IType> random() {
		LocalVariableSignature<?> signature = LocalVariableSignature.random();
		String name = randomName();
		return new LocalVariable(signature, name);
	}

	public static <T extends IType> LocalVariable<T> random(T type) {
		LocalVariableSignature<T> signature = new LocalVariableSignature(type);
		String name = randomName();
		return new LocalVariable<T>(signature, name);
	}
}
