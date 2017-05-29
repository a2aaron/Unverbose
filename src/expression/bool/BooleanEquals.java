package expression.bool;

import expression.IExpression;
import expression.ExpressionTwoOp;
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
		public IExpression<BooleanType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
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
	public BooleanEquals(IExpression<IntegerType> left, IExpression<IntegerType> right) {
		super(left, right, operator, "==");
	}

	@Override
	public IExpression<BooleanType> complicate() {
		switch (Helper.randomInt(0, 2)) {
		case 0: {
			IExpression<IntegerType> newLeft = getLeft();
			IExpression<IntegerType> newRight = getRight();
			if (Helper.random.nextBoolean()) {
				newLeft = Addition.random(newLeft.getType().getValue());
			}

			if (Helper.random.nextBoolean()) {
				newRight = Addition.random(newRight.getType().getValue());
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
		IExpression<IntegerType> left = IntegerConstant.random();
		IExpression<IntegerType> right = new IntegerConstant(left.getType());
		return new BooleanEquals(left, right);
	}

    public static IExpression<BooleanType> randomEqualTo(boolean value) {
        if (value) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}