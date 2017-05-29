package expression.bool;

import expression.Expression;
import helper.Helper;
import types.BooleanType;

/**
 * Write a description of class BooleanOr here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanOr extends BooleanExpressionTwoOp {
    static final BooleanOperator operator = new BooleanOperator() {
        @Override
        public boolean apply(boolean left, boolean right) {
            return left || right;
        }
    };

    public BooleanOr(boolean left, boolean right) {
        super(left, right, operator, "||");
    }

    public static Expression<BooleanType> randomFalse() {
        return new BooleanOr(false, false);
    }

    public static Expression<BooleanType> randomTrue() {
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

    public static Expression<BooleanType> randomEqualTo(BooleanType type) {
        if (type.getValue().booleanValue()) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
