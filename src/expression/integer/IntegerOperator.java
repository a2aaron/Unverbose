package expression.integer;

import expression.IExpression;
import expression.IExpression;
import expression.Operator;
import types.IntegerType;

public interface IntegerOperator extends Operator<IntegerType, IntegerType, IntegerType> {
	public enum IntegerOperators {
		TRUE, FALSE, EQUALS, NOT_EQUALS, AND, OR, NOT,
	}

	@Override
	public default IExpression<IntegerType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
		int result = apply(left.getType().getValue().intValue(), right.getType().getValue().intValue());
		return new IntegerConstant(new IntegerType(result));
	}

	int apply(int left, int right);
}
