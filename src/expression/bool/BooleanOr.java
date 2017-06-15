package expression.bool;

import expression.IExpression;
import helper.Helper;
import types.BooleanType;

/**
 * Write a description of class BooleanOr here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanOr extends BooleanTwoOp {
    static final BooleanOperator operator = new BooleanOperator() {
        @Override
        public boolean apply(boolean left, boolean right) {
            return left || right;
        }
    };

    public BooleanOr(boolean left, boolean right) {
        super(left, right, operator, "||");
    }

    public static IExpression<BooleanType> randomFalse() {
        return new BooleanOr(false, false);
    }

    public static IExpression<BooleanType> randomTrue() {
        switch (Helper.randomInt(0, 3)) {
        case 0:
            return new BooleanOr(true, true);
        case 1:
            return new BooleanOr(false, true);
        case 2:
            return new BooleanOr(true, false);
        }
        return null;
    }

    public static IExpression<BooleanType> randomEqualTo(boolean value) {
        if (value) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
