package execution;

import java.util.ArrayList;

import expression.Expression;
import helper.ExpressionGenerator;
import types.IType;
import variables.Variable;

public class DeclarationAssignment<T extends IType<?>> extends CodeBlock {
	Variable<T> variable;
	Expression<T> expression;

	public DeclarationAssignment(Variable<T> variable, Expression<T> expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		variable.set(expression.getType());
		scope.add(variable);
	}

	public Variable<T> getVariable() {
		return variable;
	}

	@Override
	public String toString() {
		return variable.toString() + " = " + expression.toString() + ";";
	}

	public static <T extends IType<?>> DeclarationAssignment<T> random(Class<T> typeClass) {
		Variable<T> variable = Variable.random(typeClass);
		Expression<T> expression = ExpressionGenerator.random(typeClass);
		return new DeclarationAssignment<T>(variable, expression);
	}
}
