package expression;

import helper.Helper;
import types.IType;
import values.IValue;

/**
 * The ExpressionOneOp class takes one expression and an operator and applies
 * the operator to the expression
 *
 * @param <In>
 *            The input value
 * @param <Out>
 *            The returned value
 */
public class ExpressionOneOp<In extends IType, Out extends IType> extends Expression<Out> {
	protected IExpression<In> expression;
	OneOpOperator<In, Out> operator;

	public ExpressionOneOp(IExpression<In> expression, OneOpOperator<In, Out> operator) {
		this.expression = expression;
		this.operator = operator;
	}

	@Override
	public IExpression<Out> complicate() {
		switch (Helper.randomInt(0, 1)) {
		case 0: {
			IExpression<In> newExpression = expression.complicate();
			return new ExpressionOneOp<In, Out>(newExpression, operator);
		}
		case 1:
			return this.evaluate();
		case 2:
			return this;
		default:
			throw new RuntimeException("Unreachable!");
		}
	}

	@Override
	public IExpression<Out> evaluate() {
		return operator.apply(expression);
	}

	@Override
	public IValue<Out, ?> getValue() {
		return evaluate().getValue();
	}

	@Override
	public String toString() {
		return expression.toString();
	}
}
