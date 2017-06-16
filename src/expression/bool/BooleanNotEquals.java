package expression.bool;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import expression.integer.Addition;
import expression.integer.IntegerConstant;
import helper.Helper;
import types.BooleanType;
import types.IntegerType;
import values.IntegerValue;

/**
 * Write a description of class BooleanEquals here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanNotEquals extends ExpressionTwoOp<IntegerType, IntegerType, BooleanType> {
	static final Operator<IntegerType, IntegerType, BooleanType> operator = new Operator<IntegerType, IntegerType, BooleanType>() {
		@Override
		public IExpression<BooleanType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
			if (!left.getValue().equals(right.getValue())) {
				return new BooleanConstant(true);
			} else {
				return new BooleanConstant(false);
			}
		}
	};

	/**
	 * Constructor for objects of class BooleanEquals
	 */
	public BooleanNotEquals(IExpression<IntegerType> left, IExpression<IntegerType> right) {
		super(left, right, operator, "!=");
	}

	@Override
	public IExpression<BooleanType> complicate() {
		switch (Helper.randomInt(0, 2)) {
		case 0: {
			IExpression<IntegerType> newLeft = getLeft();
			IExpression<IntegerType> newRight = getRight();
			if (Helper.random.nextBoolean()) {
				newLeft = Addition.random((int) newLeft.getValue().getValue());
			}

			if (Helper.random.nextBoolean()) {
				newRight = Addition.random((int) newRight.getValue().getValue());
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
		IntegerConstant right = new IntegerConstant(left.getValue());
		return new BooleanNotEquals(left, right);
	}

	public static BooleanNotEquals randomTrue() {
		while (true) {
			IntegerConstant left = IntegerConstant.random();
			IntegerConstant right = IntegerConstant.random();
			BooleanNotEquals equals = new BooleanNotEquals(left, right);
			if (((Boolean) equals.evaluate().getValue().getValue()).booleanValue() == true) {
				return equals;
			}
		}
	}

    public static IExpression<BooleanType> randomEqualTo(boolean value) {
        if (value) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}
