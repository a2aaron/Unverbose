package expression.bool;

import expression.IExpression;
import expression.ExpressionTwoOp;
import expression.Operator;
import types.BooleanType;
import types.IType;
import values.BooleanValue;

public class BooleanTwoOp<T extends IType> extends ExpressionTwoOp<T, T, BooleanType> {
	public BooleanTwoOp(IExpression<T> left, IExpression<T> right, Operator<T, T, BooleanType> operator, String symbol) {
		super(left, right, operator, symbol);
	}

}
