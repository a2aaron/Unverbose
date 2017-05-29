package expression.integer;

import expression.Expression;
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
	public Expression<IntegerType> complicate() {
		return Addition.random(this.getType());
	}

	@Override
	public Expression<IntegerType> evaluate() {
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
