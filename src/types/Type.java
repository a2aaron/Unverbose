package types;

import expression.IExpression;
import values.NullValue;
import values.UnassignedNullValue;

/**
 * A Type holds a textual name for itself (such as "int") and an actual value
 * for that type.
 * 
 * T is the underlying value of the Type
 */
class Type<T extends Object> implements IType<T>, IExpression<IType<?>> {
	T value;
	String name;
	NullValue nullValue;

	/**
	 * 
	 * @param name
	 *            the name of this type (like "int") Sets the nullValue paramter
	 *            to UnassignedNullValue
	 */
	public Type(String name) {
		this.name = name;
		this.value = null;
		this.nullValue = new UnassignedNullValue();
	}

	/**
	 * 
	 * @param name
	 *            the name of this type (like "int")
	 * @param value
	 *            the value of this type (like "4") If value is null, then the
	 *            NullValue parameter is set to NullValue
	 */
	public Type(String name, T value) {
		this.name = name;
		this.value = value;
		if (value == null) {
			nullValue = new NullValue();
		}
	}

	@Override
	public IExpression<IType<?>> evaluate() {
		return this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Type<?> getType() {
		return this;
	}

	@Override
	public Object getValue() {
		if (value == null) {
			return nullValue;
		} else {
			return value;
		}
	}

	@Override
    public void setNullValue(NullValue nullValue) {
		this.nullValue = nullValue;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getName() + " | " + getValue().toString();
	}
}
