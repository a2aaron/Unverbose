package execution;

import java.util.ArrayList;

import types.IType;
import values.UnassignedNullValue;
import variables.LocalVariable;
import variables.Variable;

public class Declaration<T extends IType> extends CodeBlock {
	Variable<T> variable;

	public Declaration(Variable<T> variable) {
		this.variable = variable;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		scope.add(variable);
	}

	public Variable<T> getVariable() {
		return variable;
	}

	@Override
	public String toString() {
		return variable.toString() + ";";
	}

	public static <T extends IType> Declaration<T> random(Class<T> typeClass) {
		LocalVariable<T> variable = LocalVariable.random(IType.random(typeClass));
		variable.setNullValue(new UnassignedNullValue<T>(variable.getSignature().getType()));
		return new Declaration<T>(variable);
	}
}
