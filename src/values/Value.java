package values;

import types.IType;

/**
 * @param <T>
 *            the actual object this value holds
 */
class Value<T extends IType, V extends Object> implements IValue<T, V> {
    T type;
	V value;

	public Value(T type, V value) {
	    this.type = type;
		this.value = value;
	}

	@Override
	public V getValue() {
		return value;
	}
	
    @Override
    public T getType() {
        return type;
    }

	@Override
	public String toString() {
		return value.toString();
	}

	public static <T extends IType> Value<T, ?> random(T type) {
		return Value.random(type);
	}
}
