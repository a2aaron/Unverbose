package expression.bool;

import expression.Expression;
import expression.ExpressionOneOp;
import expression.OneOpOperator;
import helper.Helper;
import types.BooleanType;

/**
 * Write a description of class BooleanNot here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanNot extends ExpressionOneOp<BooleanType, BooleanType> {
	static OneOpOperator<BooleanType, BooleanType> operator = new OneOpOperator<BooleanType, BooleanType>() {
		@Override
		public Expression<BooleanType> apply(Expression<BooleanType> expression) {
			if (expression.evaluate().getType().getValue().booleanValue() == true) {
				return new BooleanConstant(false);
			} else {
				return new BooleanConstant(true);
			}
		}
	};

	public BooleanNot(Expression<BooleanType> expression) {
		super(expression, operator);
	}
	
	@Override
	public Expression<BooleanType> complicate() {
		switch (Helper.randomInt(0, 2)) {
		case 0:
		case 1:
			Expression<BooleanType> newExpression = expression.complicate();
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

	public static Expression<BooleanType> randomFalse() {
		return new BooleanNot(new BooleanConstant(true));
	}

	public static Expression<BooleanType> randomTrue() {
		return new BooleanNot(new BooleanConstant(false));
	}

    public static Expression<BooleanType> randomEqualTo(BooleanType type) {
        if (type.getValue().booleanValue()) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
