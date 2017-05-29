package execution;

import java.util.ArrayList;
import expression.IExpression;
import expression.ExpressionVariable;
import helper.ExpressionGenerator;
import helper.Helper;
import types.IType;
import variables.Variable;

public class Return<T extends IType<?>> extends CodeBlock {
	IExpression<T> expression;

	public Return(IExpression<T> expression) {
		super();
		this.expression = expression;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		throw new RuntimeException("Don't execute return methods");
	}

	public T get() {
		return expression.getType();
	}

	@Override
	public String toString() {
		return "return " + expression.toString() + ";";
	}

	public static <T extends IType<?>> Return<T> randomFromScope(ArrayList<Variable<?>> scope, Class<T> typeClass) {
	    Variable<T> returnedVariable; 
	    for (Variable<?> variable : Helper.shuffle(scope)) {
	        if (typeClass.equals(variable.getSignature().getType().getClass())) {
	            returnedVariable = (Variable<T>) variable;
	            return new Return<T>(new ExpressionVariable<T>(returnedVariable));
	        }
	    }
	    return new Return<T>(ExpressionGenerator.random(typeClass));
	}
}
