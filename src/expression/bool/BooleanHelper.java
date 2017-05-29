package expression.bool;

import expression.IExpression;
import types.BooleanType;

/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanHelper {
	public static IExpression<BooleanType> random() {
		return BooleanConstant.random();
	}

    public static IExpression<BooleanType> toExpression(boolean value) {
        return toExpression(new BooleanType(value));
    }	
	
	public static IExpression<BooleanType> toExpression(BooleanType value) {
		if (value.getValue().booleanValue() == true) {
			return new BooleanConstant(true);
		} else {
			return new BooleanConstant(false);
		}
	}
}
