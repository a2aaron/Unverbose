package expression.integer;

import expression.IExpression;
import expression.ExpressionTwoOp;
import expression.Operator;
import types.IntegerType;
import values.IntegerValue;

/**
 * Write a description of class Addition here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Addition extends ExpressionTwoOp<IntegerType, IntegerType, IntegerType> {
	static final Operator<IntegerType, IntegerType, IntegerType> operator = new IntegerOperator() {
        @Override
        public int apply(int left, int right) {
            return left + right;
        }
	};

	public Addition(IExpression<IntegerType> left, IExpression<IntegerType> right) {
		super(left, right, operator, "+");
	}

	public static Addition random() {
		IntegerValue left = IntegerValue.random();
		IntegerValue right = IntegerValue.random();
		return new Addition(new IntegerConstant(left), new IntegerConstant(right));
	}

	public static Addition random(int value) {
		IntegerValue left = IntegerValue.random();
		int right = value - left.getValue().intValue();
		return new Addition(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
	}
}