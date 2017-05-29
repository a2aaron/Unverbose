package expression.integer;

import expression.IExpression;
import expression.ExpressionTwoOp;
import expression.Operator;
import types.IntegerType;

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
		IntegerType left = IntegerType.random();
		IntegerType right = IntegerType.random();
		return new Addition(new IntegerConstant(left), new IntegerConstant(right));
	}

	public static Addition random(IntegerType value) {
		IntegerType left = IntegerType.random();
		int right = value.getValue().intValue() - left.getValue().intValue();
		return new Addition(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
	}
}