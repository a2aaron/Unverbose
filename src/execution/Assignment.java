package execution;

import java.util.ArrayList;

import expression.IExpression;
import types.IType;
import variables.Variable;

public class Assignment<T extends IType> extends CodeBlock {

	Variable<T> variable;
	IExpression<T> expression;

	public Assignment(Variable<T> variable, IExpression<T> expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		if (scope.indexOf(variable) == -1) {
			throw new RuntimeException(variable + " not in scope!?");
		}
		variable.setValue(expression.getValue());
	}

	@Override
	public String toString() {
		return variable.getName() + " = " + expression.toString() + ";";
	}

}
