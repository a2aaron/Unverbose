package expression;

import helper.ExpressionGenerator;
import types.IType;
import values.IValue;

/**
 * An IExpression is an object which, at it's core, somehow represents a Value.
 * An IExpression may be very long, or very short. All Expressions must return a
 * value and Expressions should be able to be transformed into equivalent
 * Expressions with the same returned value.
 * 
 * Expressions also should implement a toString() method IMPORTANT: An
 * IExpression is NOT a Value, but there are Expressions which are just
 * constants. Why? Because an IExpression represents the symbols for an
 * underlying Value. For example, the expression "false" has a type "Boolean"
 * and value of "false" Likewise, the expression "!true" is also of type
 * "Boolean" and of value "false." However, those expressions will not produce
 * the same toString() result.
 * 
 * @param <T
 *            extends Type> the type that this expression evaluates to
 */
public abstract class Expression<T extends IType> implements IExpression<T> {
	IValue<T, ?> value;

	public Expression() {

	}

	public Expression(IValue<T, ?> value) {
		this.value = value;
	}

	public abstract IExpression<T> complicate();

	@Override
    public abstract IExpression<T> evaluate();
	
	@Override
    public IValue<T, ?> getValue() {
		if (value == null) {
			throw new RuntimeException("Value is null");
		}
		return value;
	}
}
