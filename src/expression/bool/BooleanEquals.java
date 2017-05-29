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
public class BooleanEquals extends ExpressionTwoOp<IntegerType, IntegerType, BooleanType> {
	static final Operator<IntegerType, IntegerType, BooleanType> operator = new Operator<IntegerType, IntegerType, BooleanType>() {
		@Override
		public Expression<BooleanType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
			if (left.getType().getValue().equals(right.getType().getValue())) {
				return new BooleanConstant(true);
			} else {
				return new BooleanConstant(false);
			}
		}
	};

	/**
	 * Constructor for objects of class BooleanEquals
	 */
	public BooleanEquals(Expression<IntegerType> left, Expression<IntegerType> right) {
		super(left, right, operator, "==");
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

	public static BooleanEquals randomFalse() {
		while (true) {
			IntegerConstant left = IntegerConstant.random();
			IntegerConstant right = IntegerConstant.random();
			BooleanEquals equals = new BooleanEquals(left, right);
			if (equals.evaluate().getType().getValue().booleanValue() == false) {
				return equals;
			}
		}
	}

	public static BooleanEquals randomTrue() {
		Expression<IntegerType> left = IntegerConstant.random();
		Expression<IntegerType> right = new IntegerConstant(left.getType());
		return new BooleanEquals(left, right);
	}

    public static Expression<BooleanType> randomEqualTo(BooleanType type) {
        if (type.getValue().booleanValue()) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}