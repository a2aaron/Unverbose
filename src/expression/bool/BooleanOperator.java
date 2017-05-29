package expression.bool;

import expression.IExpression;
import expression.IExpression;
import expression.Operator;
import types.BooleanType;

public interface BooleanOperator extends Operator<BooleanType, BooleanType, BooleanType> {
	public enum BooleanOperators {
		TRUE, FALSE, EQUALS, NOT_EQUALS, AND, OR, NOT,
	}

	@Override
	public default IExpression<BooleanType> apply(IExpression<BooleanType> left, IExpression<BooleanType> right) {
		boolean result = apply(left.getType().getValue().booleanValue(), right.getType().getValue().booleanValue());
		return BooleanHelper.toExpression(new BooleanType(result));
	}

	boolean apply(boolean left, boolean right);
}
