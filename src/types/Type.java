package types;

import values.NullValue;
import values.UnassignedNullValue;

/**
 * A Type holds a textual name for itself (such as "int") and an actual value
 * for that type.
 * 
 * T is the underlying value of the Type
 */
class Type<T extends Object> implements IType<T> {
    String name;
    T value;
    NullValue nullValue;
    
    /**
     * 
     * @param name
     *            the name of this type (like "int") Sets the nullValue paramter
     *            to UnassignedNullValue
     */
    public Type(String name, T value) {
        this.name = name;
        this.value = value;
        if (value == null) {
            nullValue = new NullValue();
        }
    }
    
    public Type(String name) {
        this.name = name;
        if (value == null) {
            nullValue = new UnassignedNullValue();
        }
    }
    
    @Override
    public T getValue() {
        return value;
    }
    
    @Override
    public void setValue(T value) {
        this.value = value;
    }
    
    public NullValue getNullValue() {
        return nullValue;
    }

    @Override
    public void setNullValue(NullValue nullValue) {
        this.nullValue = nullValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
