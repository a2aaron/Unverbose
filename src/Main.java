
import java.util.ArrayList;

import expression.IExpression;
import expression.bool.BooleanConstant;
import expression.integer.IntegerConstant;
import function.Function;
import types.IFunctionType;
import types.IntegerType;
import values.IntegerValue;
import variables.Variable;

/**
 * Write a description of class Main here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main {
	public static void main(String args[]) {
		System.out.println("");
		BooleanConstant booleanTrue = new BooleanConstant(true);
		IExpression<IntegerType> constant = new IntegerConstant(new IntegerValue(5));
		ArrayList<Variable<?>> scope2 = new ArrayList<Variable<?>>();
		for (int i = 0; i < 100; i++) {
//			Class<? extends IType> typeClass = IType.randomClass();
//			System.out.println(DeclarationAssignment.random(typeClass));
//			System.out.println(Variable.random(typeClass));
//			System.out.println(Getter.random(IFunctionType.randomNonVoidClass()));
//			System.out.println(Setter.random());
//			booleanTrue = booleanTrue.complicate();
//			System.out.println(booleanTrue);
//			CodeBlock random = CodeBlock.random(scope2);
//			random.execute(scope2);
//		    constant = constant.complicate();
//		    System.out.println(constant);
			System.out.println(Function.random(IFunctionType.random()));
		}
		System.out.println("E");
	}
}