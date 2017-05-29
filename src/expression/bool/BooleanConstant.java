package expression.bool;

import expression.IExpression;
import expression.ExpressionConstant;
import helper.Helper;
import types.BooleanType;

/**
 * Write a description of class BooleanConstant here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanConstant extends ExpressionConstant<BooleanType> {
	public BooleanConstant(boolean value) {
		super(new BooleanType(value));
	}

	public BooleanConstant(BooleanType value) {
		super(value);
	}

	public static IExpression<BooleanType> random() {
		return BooleanHelper.toExpression(types.BooleanType.random());
	}

    @Override
    public IExpression<BooleanType> complicate() {
        boolean type = this.getType().getValue();
        switch (Helper.randomInt(0, 6)) {
        case 0:
            return new BooleanConstant(type);
        case 1:
            return BooleanNot.randomEqualTo(type);
        case 2:
            return BooleanAnd.randomEqualTo(type);
        case 3:
            return BooleanOr.randomEqualTo(type);
        case 4:
            return BooleanEquals.randomEqualTo(type);
        case 5:
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
