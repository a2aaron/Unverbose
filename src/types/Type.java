package types;

import values.NullValue;
import values.UnassignedNullValue;

/**
 * A Type holds a textual name for itself (such as "int") and an actual value
 * for that type.
 * 
 * T is the underlying value of the Type
 */
class Type implements IType {
    String name;
    
    /**
     * 
     * @param name
     *            the name of this type (like "int") Sets the nullValue paramter
     *            to UnassignedNullValue
     */
    public Type(String name) {
        this.name = name;
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
