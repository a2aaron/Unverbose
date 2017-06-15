
import java.util.ArrayList;

import execution.CodeBlock;
import execution.DeclarationAssignment;
import expression.IExpression;
import expression.bool.BooleanConstant;
import expression.integer.Addition;
import expression.integer.Division;
import expression.integer.IntegerConstant;
import expression.integer.Multiplication;
import expression.integer.Subtraction;
import function.Function;
import function.Getter;
import function.Setter;
import types.BooleanType;
import types.IFunctionType;
import types.IType;
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
		IExpression<BooleanType> booleanTrue = new BooleanConstant(true);
		IExpression<IntegerType> constant = new IntegerConstant(new IntegerValue(5));
		ArrayList<Variable<?>> scope2 = new ArrayList<Variable<?>>();
		for (int i = 0; i < 100; i++) {
			IType type = IType.random();
//			System.out.println(DeclarationAssignment.random(type));
//			System.out.println(Variable.random(type));
//			System.out.println(Getter.random(IFunctionType.randomNonVoid()));
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
