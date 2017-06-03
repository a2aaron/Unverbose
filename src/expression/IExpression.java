package expression;

import java.util.ArrayList;

import types.IType;
import values.IValue;
import variables.Variable;

public interface IExpression<T extends IType> {
	public IExpression<T> evaluate();
	public IExpression<T> complicate();
	public IValue<T, ?> getValue();
}
