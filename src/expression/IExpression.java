package expression;

import types.IType;
import values.IValue;

public interface IExpression<T extends IType> {
	public IExpression<T> evaluate();
	public IExpression<T> complicate();
	public IValue<T, ?> getValue();
}
