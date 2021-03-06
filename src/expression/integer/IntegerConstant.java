package expression.integer;

import expression.Expression;
import expression.IExpression;
import helper.Helper;
import types.IntegerType;
import values.IntegerValue;

/**
 * Write a description of class IntegerConstant here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerConstant extends Expression<IntegerType> implements IntegerExpression  {
	public IntegerConstant(IntegerValue value) {
		super(value);
	}

	@Override
	public IntegerExpression complicate() {
	    int value = this.getValue().getValue().intValue();
	    switch(Helper.randomInt(0, 5)) {
	    case 0: return Subtraction.random(value);
	    case 1: return Addition.random(value);
	    case 2: return Multiplication.random(value);
	    case 3: return Division.random(value);
	    case 4: return Modulo.random(value);
	    default:
	        throw new RuntimeException("Unreachable!");
	    }
		
	}
	
	@Override
	public IntegerValue getValue() {
	    return (IntegerValue) super.getValue();
	}

	@Override
	public IntegerExpression evaluate() {
		return this;
	}

	@Override
	public String toString() {
		return getValue().getValue().toString();
	}

	public static IntegerConstant random() {
		return new IntegerConstant(IntegerValue.random());
	}
}
