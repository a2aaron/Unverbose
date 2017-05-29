package expression;

import helper.Helper;
import types.IType;

/**
 * The ExpressionOneOp class takes one expression and an operator and applies
 * the operator to the expression
 *
 * @param <In>
 *            The input value
 * @param <Out>
 *            The returned value
 */
public class ExpressionOneOp<In extends IType<?>, Out extends IType<?>> extends Expression<Out> {
	protected Expression<In> expression;
	OneOpOperator<In, Out> operator;

	public ExpressionOneOp(Expression<In> expression, OneOpOperator<In, Out> operator) {
		this.expression = expression;
		this.operator = operator;
	}

	@Override
	public Expression<Out> complicate() {
		switch (Helper.randomInt(0, 1)) {
		case 0: {
			Expression<In> newExpression = expression.complicate();
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
	public Expression<Out> evaluate() {
		return operator.apply(expression);
	}

	@Override
	public Out getType() {
		return evaluate().getType();
	}

	@Override
	public String toString() {
		return expression.toString();
	}
}
