package expression;

import types.IType;

public interface IExpression<T extends IType<?>> {
	public IExpression<T> evaluate();

	public T getType();
}
