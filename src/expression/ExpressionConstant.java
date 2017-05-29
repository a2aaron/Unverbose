package expression;

import types.IType;

public class ExpressionConstant<T extends IType<?>> extends Expression<T> implements IExpression<T> {
	public ExpressionConstant(T value) {
		super(value);
	}

	@Override
	public IExpression<T> complicate() {
		throw new RuntimeException("TODO");
	}

	@Override
	public IExpression<T> evaluate() {
		throw new RuntimeException("TODO");
	}
	
	@Override
	public String toString() {
	    return this.getType().getValue().toString();
	}
}
