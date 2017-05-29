package expression.bool;

import expression.Expression;
import helper.Helper;
import types.BooleanType;

/**
 * Write a description of class BooleanAnd here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanAnd extends BooleanExpressionTwoOp {
	static final BooleanOperator operator = new BooleanOperator() {
		@Override
		public boolean apply(boolean left, boolean right) {
			return left && right;
		}
	};
	
    public BooleanAnd(boolean left, boolean right) {
        super(left, right, operator, "&&");
    }

	public static Expression<BooleanType> randomFalse() {
		switch (Helper.randomInt(0, 3)) {
		case 0:
			return new BooleanAnd(true, false);
		case 1:
			return new BooleanOr(false, true);
		case 2:
			return new BooleanOr(false, false);
		}
		return null;
	}
	
	public static Expression<BooleanType> randomTrue() {
		return new BooleanAnd(true, true);
	}

    public static Expression<BooleanType> randomEqualTo(BooleanType type) {
        if (type.getValue().booleanValue()) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
