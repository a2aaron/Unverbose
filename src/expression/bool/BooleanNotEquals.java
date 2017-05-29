package expression.bool;

import expression.Expression;
import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import expression.integer.Addition;
import expression.integer.IntegerConstant;
import helper.Helper;
import types.BooleanType;
import types.IntegerType;

/**
 * Write a description of class BooleanEquals here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanNotEquals extends ExpressionTwoOp<IntegerType, IntegerType, BooleanType> {
	static final Operator<IntegerType, IntegerType, BooleanType> operator = new Operator<IntegerType, IntegerType, BooleanType>() {
		@Override
		public Expression<BooleanType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
			if (!left.getType().equals(right.getType())) {
				return new BooleanConstant(true);
			} else {
				return new BooleanConstant(false);
			}
		}
	};

	/**
	 * Constructor for objects of class BooleanEquals
	 */
	public BooleanNotEquals(Expression<IntegerType> left, Expression<IntegerType> right) {
		super(left, right, operator, "!=");
	}

	@Override
	public Expression<BooleanType> complicate() {
		switch (Helper.randomInt(0, 2)) {
		case 0: {
			Expression<IntegerType> newLeft = getLeft();
			Expression<IntegerType> newRight = getRight();
			if (Helper.random.nextBoolean()) {
				newLeft = Addition.random(newLeft.getType());
			}

			if (Helper.random.nextBoolean()) {
				newRight = Addition.random(newRight.getType());
			}
			return new BooleanNotEquals(newLeft, newRight);
		}
		case 1: {
			return evaluate();
			// return super.complicate();
		}
		default:
			throw new RuntimeException("Unreachable!");
		}
	}

	public static BooleanNotEquals randomFalse() {
		IntegerConstant left = IntegerConstant.random();
		IntegerConstant right = new IntegerConstant(left.getType());
		return new BooleanNotEquals(left, right);
	}

	public static BooleanNotEquals randomTrue() {
		while (true) {
			IntegerConstant left = IntegerConstant.random();
			IntegerConstant right = IntegerConstant.random();
			BooleanNotEquals equals = new BooleanNotEquals(left, right);
			if (equals.evaluate().getType().getValue().booleanValue() == true) {
				return equals;
			}
		}
	}

    public static Expression<BooleanType> randomEqualTo(BooleanType type) {
        if (type.getValue().booleanValue()) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
