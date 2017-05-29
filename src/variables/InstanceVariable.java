package variables;

import signatures.VariableSignature;
import types.IType;

public class InstanceVariable<T extends IType<?>> extends Variable<T> {
	public InstanceVariable(VariableSignature<T> signature, String name) {
		super(signature, name);
	}

	@Override
	public String getName() {
		return "this." + super.getName();
	}

	public static InstanceVariable<?> random() {
		VariableSignature<?> signature = VariableSignature.random(IType.randomClass());
		String name = randomName();
		return new InstanceVariable(signature, name);
	}
}