package variables;

import signatures.LocalVariableSignature;
import types.IType;

public class LocalVariable<T extends IType<?>> extends Variable<T> {
	public LocalVariable(LocalVariableSignature<T> type, String name) {
		super(type, name);
	}

	@Override
    public String toString() {
		return getSignature().getType().getName() + " " + getName();
	}

	public static LocalVariable<? extends IType<?>> random() {
		LocalVariableSignature<?> signature = new LocalVariableSignature(IType.random(IType.randomClass()));
		String name = randomName();
		return new LocalVariable(signature, name);
	}

	public static <T extends IType<?>> LocalVariable<T> random(Class<T> typeClass) {
		LocalVariableSignature<T> signature = new LocalVariableSignature<T>(IType.random(typeClass));
		String name = randomName();
		return new LocalVariable<T>(signature, name);
	}
}
