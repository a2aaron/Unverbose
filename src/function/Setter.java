package function;

import execution.Assignment;
import expression.ExpressionVariable;
import helper.Helper;
import signatures.FunctionSignature;
import signatures.IClassLevelSignature.Visibility;
import types.VoidType;
import variables.InstanceVariable;
import variables.LocalVariable;

/**
 * Write a description of class Setter here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Setter extends Function<VoidType> {
	public Setter(FunctionSignature<VoidType> signature, InstanceVariable<?> variable, LocalVariable<?> parameter) {
		super(signature, "set" + Helper.capitalize(variable.getCanonicalName()),
				new Assignment(variable, new ExpressionVariable(parameter)));
		super.parameters.add(parameter);
	}

	public static Setter random() {
		FunctionSignature<VoidType> signature = new FunctionSignature<VoidType>(Visibility.PUBLIC, new VoidType());
		InstanceVariable<?> instVar = InstanceVariable.random();
		LocalVariable<?> localVar = LocalVariable.random();
		return new Setter(signature, instVar, localVar);
	}
}
