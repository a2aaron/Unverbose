package expression.integer;

import expression.IExpression;
import types.IntegerType;

/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerHelper {
	public static IExpression<IntegerType> toExpression(int value) {
		return new IntegerConstant(new IntegerType(value));
	}

	public static IExpression<IntegerType> toExpression(IntegerType value) {
		return new IntegerConstant(value);
	}
}
