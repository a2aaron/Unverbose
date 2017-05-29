package expression;

import helper.ExpressionGenerator;
import types.IType;

public interface IExpression<T extends IType<?>> {
	public IExpression<T> evaluate();
	public IExpression<T> complicate();
	public T getType();
	
	public static <T extends IType<?>> IExpression<T> random(Class<T> clazz) {
	    return ExpressionGenerator.random(clazz);
	}
}
