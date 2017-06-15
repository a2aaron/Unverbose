package expression.bool;

import expression.ExpressionConstant;
import expression.IExpression;
import expression.bool.BooleanOperator.BooleanOperators;
import helper.Helper;
import types.BooleanType;
import values.BooleanValue;

/**
 * Write a description of class BooleanConstant here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanConstant extends ExpressionConstant<BooleanType> {
    public BooleanConstant(boolean value) {
        super(new BooleanValue(value));
    }

    public BooleanConstant(BooleanValue value) {
        super(value);
    }

    public static IExpression<BooleanType> random() {
        return BooleanHelper.toExpression(BooleanValue.random());
    }

    @Override
    public IExpression<BooleanType> complicate() {
        boolean type = ((Boolean) this.getValue().getValue()).booleanValue();
        if (Helper.random.nextBoolean()) {
            return new BooleanConstant(type);
        }
        switch (Helper.getRandomElement(BooleanOperators.values())) {
        case NOT:
            return BooleanNot.randomEqualTo(type);
        case AND:
            return BooleanAnd.randomEqualTo(type);
        case OR:
            return BooleanOr.randomEqualTo(type);
        case EQUALS:
            return BooleanEquals.randomEqualTo(type);
        case NOT_EQUALS:
            return BooleanNotEquals.randomEqualTo(type);
        default:
            throw new RuntimeException("Unreachable!");
        }
    }

    @Override
    public IExpression<BooleanType> evaluate() {
        return this;
    }
}
