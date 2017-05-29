package execution;

import java.util.ArrayList;

import expression.Expression;
import types.IType;
import variables.Variable;

public class Assignment<T extends IType<?>> extends CodeBlock {

	Variable<T> variable;
	Expression<T> expression;

	public Assignment(Variable<T> variable, Expression<T> expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		if (scope.indexOf(variable) == -1) {
			System.out.println("fuck");
		}
		variable.set(expression.getType());
	}

	@Override
	public String toString() {
		return variable.getName() + " = " + expression.toString() + ";";
	}

}
