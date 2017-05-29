package expression.bool;

import expression.Expression;
import expression.ExpressionTwoOp;
import expression.Operator;
import types.BooleanType;

public class BooleanTwoOp<T extends BooleanType> extends ExpressionTwoOp<T, T, BooleanType> {
	public BooleanTwoOp(Expression<T> left, Expression<T> right, Operator<T, T, BooleanType> operator, String symbol) {
		super(left, right, operator, symbol);
	}

}
