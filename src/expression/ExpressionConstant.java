package expression;

import types.IType;

public class ExpressionConstant<T extends IType<?>> extends Expression<T> {
	public ExpressionConstant(T value) {
		super(value);
	}

	@Override
	public Expression<T> complicate() {
		throw new RuntimeException("TODO");
	}

	@Override
	public Expression<T> evaluate() {
		throw new RuntimeException("TODO");
	}
	
	@Override
	public String toString() {
	    return this.getType().getValue().toString();
	}
}
