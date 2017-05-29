package expression.bool;

import expression.Expression;
import types.BooleanType;

/**
 * Write a description of class BooleanExpression here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanHelper {
	public static Expression<BooleanType> random() {
		return BooleanConstant.random();
	}

    public static Expression<BooleanType> toExpression(boolean value) {
        return toExpression(new BooleanType(value));
    }	
	
	public static Expression<BooleanType> toExpression(BooleanType value) {
		if (value.getValue().booleanValue() == true) {
			return new BooleanConstant(true);
		} else {
			return new BooleanConstant(false);
		}
	}
}
