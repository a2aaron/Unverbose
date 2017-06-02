package expression.integer;

import expression.IExpression;
import types.IntegerType;
import values.IntegerValue;

/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerHelper {
	public static IExpression<IntegerType> toExpression(int value) {
		return new IntegerConstant(new IntegerValue(value));
	}

	public static IExpression<IntegerType> toExpression(IntegerValue value) {
		return new IntegerConstant(value);
	}
}
