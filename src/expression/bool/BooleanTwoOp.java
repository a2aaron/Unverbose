package expression.bool;

import expression.IExpression;
import expression.ExpressionTwoOp;
import expression.Operator;
import types.BooleanType;

public class BooleanTwoOp<T extends BooleanType> extends ExpressionTwoOp<T, T, BooleanType> {
	public BooleanTwoOp(IExpression<T> left, IExpression<T> right, Operator<T, T, BooleanType> operator, String symbol) {
		super(left, right, operator, symbol);
	}

}
