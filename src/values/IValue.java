package values;

import types.IType;

public interface IValue<T extends IType, V extends Object> {
    public V getValue();
    public T getType();
}
