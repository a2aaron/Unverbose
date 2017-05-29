package expression;

import types.IType;

public interface OneOpOperator<In extends IType<?>, Out extends IType<?>> {
	public Expression<Out> apply(Expression<In> expression);
}
