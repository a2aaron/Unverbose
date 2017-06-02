package values;

import types.IType;

public class NullValue<T extends IType> extends Value<T, Object> {
	public NullValue(T type) {
		super(type, null);
	}

	@Override
	public String toString() {
		return "null";
	}
}
