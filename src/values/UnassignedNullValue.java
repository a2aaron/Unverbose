package values;

import types.IType;

public class UnassignedNullValue<T extends IType> extends NullValue<T> {
    public UnassignedNullValue(T type) {
        super(type);
    }
    
	@Override
	public String toString() {
		return "unassigned null";
	}
}
