package expression.bool;

import expression.IExpression;
import expression.Operator;
import types.BooleanType;
import values.BooleanValue;

public interface BooleanOperator extends Operator<BooleanType, BooleanType, BooleanType> {
	public enum BooleanOperators {
		EQUALS, NOT_EQUALS, AND, OR, NOT,
	}

	@Override
	public default IExpression<BooleanType> apply(IExpression<BooleanType> left, IExpression<BooleanType> right) {
		boolean result = apply((Boolean) left.getValue().getValue(), (Boolean) right.getValue().getValue());
		return BooleanHelper.toExpression(new BooleanValue(result));
	}

	boolean apply(boolean left, boolean right);
}
