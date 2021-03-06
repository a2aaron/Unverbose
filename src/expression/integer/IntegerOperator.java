package expression.integer;

import expression.IExpression;
import expression.Operator;
import types.IntegerType;
import values.IntegerValue;

@FunctionalInterface
public interface IntegerOperator extends Operator<IntegerType, IntegerType, IntegerType> {
	@Override
	public default IExpression<IntegerType> apply(IExpression<IntegerType> left, IExpression<IntegerType> right) {
		int result = apply(((Integer) left.getValue().getValue()).intValue(), ((Integer) right.getValue().getValue()).intValue());
		return new IntegerConstant(new IntegerValue(result));
	}

	int apply(int left, int right);
}
