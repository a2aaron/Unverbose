package expression;

import helper.Helper;
import types.IType;

/**
 * Write a description of class ExpressionTwoOp here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExpressionTwoOp<L extends IType<?>, R extends IType<?>, T extends IType<?>> extends Expression<T> {
	Expression<L> left;
	Expression<R> right;
	Operator<L, R, T> operator;
	String symbol;

	public ExpressionTwoOp(Expression<L> left, Expression<R> right, Operator<L, R, T> operator, String symbol) {
		this.left = left;
		this.right = right;
		this.symbol = symbol;
		this.operator = operator;
	}

	@Override
	public Expression<T> complicate() {
		switch (Helper.randomInt(0, 1)) {
		case 0: {
			Expression<L> newLeft = left;
			Expression<R> newRight = right;
			if (Helper.random.nextBoolean()) {
				newLeft = left.complicate();
			}

			if (Helper.random.nextBoolean()) {
				newRight = right.complicate();
			}
			return new ExpressionTwoOp<L, R, T>(newLeft, newRight, operator, symbol);
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
	public Expression<T> evaluate() {
		return operator.apply(this.left, this.right);
	}

	public Expression<L> getLeft() {
		return left;
	}

	public Expression<R> getRight() {
		return right;
	}

	@Override
	public T getType() {
		return evaluate().getType();
	}

	@Override
	public String toString() {
		if (right == null) {
			System.out.println("Fuck");
		}
		if (left == null) {
			System.out.println("Fuck");
		}
		return left.toString() + " " + symbol + " " + right.toString();
	}
}
/*
 * An Expression is a type which takes a value and can be evaluated to return
 * that value It has type Expression<T extends Value>
 * 
 * A TwoOpExpression is a type which takes an Operator and two Expressions<T
 * extends Value> and can return another Expression<T>. Thus, it has type
 * TwoOpExpression<T extends Value> and is also an expression
 * 
 * An Operator is NOT an expression. It is the logic for a TwoOpExpression,
 * takes two expressions (both hold value of type T) and reutrns expression of
 * type T it is type Operator<T extends Value>
 */