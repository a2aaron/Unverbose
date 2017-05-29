package values;

import types.IType;

/**
 * @param <T>
 *            the actual object this value holds
 */
public class Value<T extends Object> {
	T value;

	public Value(T value) {
		this.value = value;
	}

	public T getRawValue() {
		return value;
	}

	@Override
	public String toString() {
		return value.toString();
	}

	public static Value<?> random(IType<?> type) {
		return Value.random(type);
	}
}
