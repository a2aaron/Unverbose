package expression.integer;

import expression.Expression;
import expression.IExpression;
import types.IntegerType;

/**
 * Write a description of class IntegerConstant here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerConstant extends Expression<IntegerType> {
	public IntegerConstant(IntegerType value) {
		super(value);
	}

	@Override
	public IExpression<IntegerType> complicate() {
		return Addition.random(this.getType());
	}

	@Override
	public IExpression<IntegerType> evaluate() {
		return this;
	}

	@Override
	public String toString() {
		return getType().getValue().toString();
	}

	public static IntegerConstant random() {
		return new IntegerConstant(IntegerType.random());
	}
}
