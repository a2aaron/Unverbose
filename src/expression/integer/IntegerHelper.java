package expression.integer;

import expression.Expression;
import types.IntegerType;

/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IntegerHelper {
	public static Expression<IntegerType> toExpression(int value) {
		return new IntegerConstant(new IntegerType(value));
	}

	public static Expression<IntegerType> toExpression(IntegerType value) {
		return new IntegerConstant(value);
	}
}
