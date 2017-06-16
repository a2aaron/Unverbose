package expression.bool;

import expression.ExpressionOneOp;
import expression.IExpression;
import expression.OneOpOperator;
import helper.Helper;
import types.BooleanType;
import values.BooleanValue;

/**
 * Write a description of class BooleanNot here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanNot extends ExpressionOneOp<BooleanType, BooleanType> implements BooleanExpression {
    static OneOpOperator<BooleanType, BooleanType> operator = new OneOpOperator<BooleanType, BooleanType>() {
        @Override
        public IExpression<BooleanType> apply(IExpression<BooleanType> expression) {
            if (((Boolean) expression.evaluate().getValue().getValue()).booleanValue() == true) {
                return new BooleanConstant(false);
            } else {
                return new BooleanConstant(true);
            }
        }
    };

    public BooleanNot(IExpression<BooleanType> expression) {
        super(expression, operator);
    }
    
    public BooleanValue getValue() {
        return (BooleanValue) super.getValue();
    }
    
    public BooleanExpression evaluate() {
        return (BooleanExpression) super.evaluate();
    }

    @Override
    public BooleanExpression complicate() {
        switch (Helper.randomInt(0, 2)) {
        case 0:
        case 1:
            IExpression<BooleanType> newExpression = expression.complicate();
            return new BooleanNot(newExpression);

        // return super.complicate();
        default:
            throw new RuntimeException("Unreachable!");
        }
    }

    @Override
    public String toString() {
        if (expression instanceof BooleanConstant) {
            return "!" + expression.toString();
        } else {
            return "!(" + expression.toString() + ")";
        }
    }

    public static BooleanNot randomFalse() {
        return new BooleanNot(new BooleanConstant(true));
    }

    public static BooleanNot randomTrue() {
        return new BooleanNot(new BooleanConstant(false));
    }

    public static BooleanNot randomEqualTo(boolean value) {
        if (value) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
