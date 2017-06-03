package execution;

import java.util.ArrayList;

import expression.IExpression;
import helper.ExpressionGenerator;
import types.IType;
import variables.Variable;

public class DeclarationAssignment<T extends IType> extends CodeBlock {
	Variable<T> variable;
	IExpression<T> expression;

	public DeclarationAssignment(Variable<T> variable, IExpression<T> expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		variable.setValue(expression.getValue());
		scope.add(variable);
	}

	public Variable<T> getVariable() {
		return variable;
	}

	@Override
	public String toString() {
		return variable.toString() + " = " + expression.toString() + ";";
	}

	public static <T extends IType> DeclarationAssignment<T> random(T type) {
		Variable<T> variable = Variable.random(type);
		IExpression<T> expression = ExpressionGenerator.random(type);
		return new DeclarationAssignment<T>(variable, expression);
	}
}
