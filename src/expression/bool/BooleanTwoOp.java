package expression.bool;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import types.BooleanType;
import types.IType;

public class BooleanTwoOp<T extends IType> extends ExpressionTwoOp<T, T, BooleanType> {
	public BooleanTwoOp(IExpression<T> left, IExpression<T> right, Operator<T, T, BooleanType> operator, String symbol) {
		super(left, right, operator, symbol);
	}

}
