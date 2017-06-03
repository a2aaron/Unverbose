package function;

import execution.Return;
import expression.ExpressionVariable;
import helper.Helper;
import signatures.FunctionSignature;
import signatures.IClassLevelSignature.Final;
import signatures.IClassLevelSignature.Static;
import signatures.IClassLevelSignature.Visibility;
import types.IFunctionType;
import types.IType;
import variables.InstanceVariable;
import variables.Variable;

/**
 * Write a description of interface Function here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Getter<T extends IFunctionType> extends Function<T> {
	Variable<T> variable;

	public Getter(FunctionSignature<T> signature, InstanceVariable<T> variable) {
		super(signature, "get" + Helper.capitalize(variable.getCanonicalName()),
				new Return<T>(new ExpressionVariable<T>(variable)));
		this.variable = variable;
	}

	// TODO: Becauase FunctionSignature is broken rn this is untyped
	public static <T extends IFunctionType> Getter<T> random(T type) {
		FunctionSignature<T> signature = new FunctionSignature<T>(Visibility.PUBLIC, Static.NONE, Final.NONE,
				type);
		InstanceVariable<T> variableName = InstanceVariable.random(type);
		return new Getter<T>(signature, variableName);
	}
}
