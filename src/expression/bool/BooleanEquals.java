package expression.bool;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import expression.integer.Addition;
import expression.integer.IntegerConstant;
import helper.Helper;
import types.BooleanType;
import types.IntegerType;
import values.BooleanValue;
import values.IntegerValue;

/**
 * Write a description of class BooleanEquals here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BooleanEquals extends ExpressionTwoOp<IntegerType, IntegerType, BooleanType> implements BooleanExpression {
	static final Operator<IntegerType, IntegerType, BooleanType> operator = new Operator<IntegerType, IntegerType, BooleanType>() {
		@Override
		public IExpression<BooleanType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
			if (left.getValue().getValue().equals(right.getValue().getValue())) {
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
	
	@Override
	public BooleanValue getValue() {
	    return (BooleanValue) super.getValue();
	}
	
	@Override
	public BooleanExpression evaluate() {
	    return (BooleanExpression) super.evaluate();
	}

	public static BooleanExpression randomFalse() {
		while (true) {
			IntegerConstant left = IntegerConstant.random();
			IntegerConstant right = IntegerConstant.random();
			BooleanEquals equals = new BooleanEquals(left, right);
			if (((Boolean) equals.evaluate().getValue().getValue()).booleanValue() == false) {
				return equals;
			}
		}
	}

	public static BooleanExpression randomTrue() {
		IExpression<IntegerType> left = IntegerConstant.random();
		IExpression<IntegerType> right = new IntegerConstant((IntegerValue) left.getValue());
		return new BooleanEquals(left, right);
	}

    public static BooleanExpression randomEqualTo(boolean value) {
        if (value) {
            return randomTrue();
        } else {
            return randomFalse();
        }
    }
}