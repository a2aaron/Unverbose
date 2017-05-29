package expression.integer;

import expression.Expression;
import expression.IExpression;
import helper.Helper;
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
	    int value = this.getType().getValue().intValue();
	    switch(Helper.randomInt(0, 2)) {
	    case 0: return Subtraction.random(value);
	    case 1: return Addition.random(value);
	    default:
	        throw new RuntimeException("Unreachable!");
	    }
		
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
