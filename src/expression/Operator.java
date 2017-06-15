package expression;

import types.IType;

/**
 * An operator is a symbol which takes two expressions and yeilds a third
 * expression
 *
 * @param <L>
 *            The left input
 * @param <R>
 *            The right input
 * @param <T>
 *            The returned value
 */
public interface Operator<L extends IType, R extends IType, T extends IType> {
	public IExpression<T> apply(IExpression<L> left, IExpression<R> right);
}