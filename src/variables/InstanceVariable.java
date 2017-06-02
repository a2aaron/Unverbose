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

	public static InstanceVariable<? extends IType> random() {
		ClassVariableSignature<?> signature = ClassVariableSignature.random(IType.randomClass());
		String name = randomName();
		return new InstanceVariable(signature, name);
	}
}