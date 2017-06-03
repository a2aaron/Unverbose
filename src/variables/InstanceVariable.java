package variables;

import signatures.ClassVariableSignature;
import types.IType;
import values.IValue;

public class InstanceVariable<T extends IType> extends Variable<T> {
	public InstanceVariable(ClassVariableSignature<T> signature, String name) {
		super(signature, name);
	}

	@Override
	public String getName() {
		return "this." + super.getName();
	}
	

    public static <T extends IType> InstanceVariable<T> random(T type) {
        ClassVariableSignature<T> signature = ClassVariableSignature.random(type);
        String name = randomName();
        return new InstanceVariable<T>(signature, name);
    }

	public static InstanceVariable<? extends IType> random() {
		return random(IType.random());
	}
}