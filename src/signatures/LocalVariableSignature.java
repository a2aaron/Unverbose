package signatures;

import types.IType;

public class LocalVariableSignature<T extends IType<?>> implements ISignature<T> {
	T type;

	public LocalVariableSignature(T type) {
		this.type = type;
	}

	@Override
	public T getType() {
		return type;
	}

	@Override
	public void setType(T type) {
		this.type = type;
	}

	public static LocalVariableSignature<?> random() {
		IType<?> type = IType.random(IType.randomClass());
		return new LocalVariableSignature(type);
	}
}
