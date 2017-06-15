package expression;

import types.IType;

public interface OneOpOperator<In extends IType, Out extends IType> {
	public IExpression<Out> apply(IExpression<In> expression);
}
