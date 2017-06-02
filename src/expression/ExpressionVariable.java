package expression;

import types.IType;
import values.IValue;
import variables.Variable;

public class ExpressionVariable<T extends IType> extends Expression<T> {
	Variable<T> variable;

	public ExpressionVariable(Variable<T> variable) {
		super(variable.getValue());
		this.variable = variable;
	}

	@Override
	public IExpression<T> complicate() {
		throw new RuntimeException("TODO");
	}

	@Override
	public IExpression<T> evaluate() {
		throw new RuntimeException("TODO");
	}

	public Variable<T> getVariable() {
		return variable;
	}

	@Override
    public String toString() {
		return variable.getName();
	}
}