package execution;

import java.util.ArrayList;

import expression.ExpressionVariable;
import expression.IExpression;
import helper.ExpressionGenerator;
import helper.Helper;
import types.IType;
import values.IValue;
import values.UnassignedNullValue;
import variables.Variable;

public class Return<T extends IType> extends CodeBlock {
	IExpression<T> expression;

	public Return(IExpression<T> expression) {
		super();
		this.expression = expression;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		throw new RuntimeException("Don't execute return methods");
	}

	public IValue<T, ?> get() {
		return expression.getValue();
	}

	@Override
	public String toString() {
		return "return " + expression.toString() + ";";
	}

	
    public static <T extends IType> Return<T> randomFromScope(ArrayList<Variable<?>> scope, T type) {
	    for (Variable<?> variable : Helper.shuffle(scope)) {
	        boolean unassigned = variable.getValue() instanceof UnassignedNullValue;
	        if (type.equals(variable.getSignature().getType()) && !unassigned) {
	            @SuppressWarnings("unchecked") 
	            // Guaranteed type safe. Proof:
	            // the type of variable is Variable<?1 extends IType>
	            // the type of variable.getSignature().getType().getClass() is Class<?1 extends IType>
	            // if Class<T extends IType> == Class<?1 extends IType>
	            // then T == ?1, so
	            // Variable<T> == Variable<?1>
	            Variable<T> returnedVariable = (Variable<T>) variable;
	            return new Return<T>(new ExpressionVariable<T>(returnedVariable));
	        }
	    }
	    return new Return<T>(ExpressionGenerator.random(type));
	}
}
