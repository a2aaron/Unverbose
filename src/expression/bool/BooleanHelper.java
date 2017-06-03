package expression.bool;

import expression.IExpression;
import helper.Helper;
import types.BooleanType;
import values.BooleanValue;

/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanHelper {
	public static IExpression<BooleanType> random() {
	    IExpression<BooleanType> expression = BooleanConstant.random();
	    for (int i = 0; i < Helper.randomInt(0, 10); i++)
	        expression = expression.complicate();
		return expression;
	}

    public static IExpression<BooleanType> toExpression(boolean value) {
        return toExpression(new BooleanValue(value));
    }	
	
	public static IExpression<BooleanType> toExpression(BooleanValue value) {
		if (value.getValue().booleanValue() == true) {
			return new BooleanConstant(true);
		} else {
			return new BooleanConstant(false);
		}
	}
}
