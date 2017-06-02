package values;

import types.VoidType;

public class VoidValue implements IValue<VoidType, Object> {

    @Override
    public Object getValue() {
        throw new RuntimeException("Cannot get value of void!");
    }

    @Override
    public VoidType getType() {
        return new VoidType();
    }

}
