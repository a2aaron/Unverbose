
import java.util.ArrayList;

import expression.IExpression;
import expression.bool.BooleanConstant;
import expression.integer.Addition;
import expression.integer.Division;
import expression.integer.IntegerConstant;
import expression.integer.Multiplication;
import expression.integer.Subtraction;
import function.Function;
import types.BooleanType;
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
		IExpression<BooleanType> booleanTrue = new BooleanConstant(true);
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
//		    System.out.println(new Division(new Subtraction(32, 7), new Addition(25, 5)).complicate());
//		     System.out.println(new Division(new Subtraction(5, 4), new Addition(5, 3)));
			System.out.println(Function.random(IFunctionType.random()));
		}
		System.out.println("E");
	}
}
//     (2    /    1)    *    ((165  -   3)   / 9) / (((9 / 3) / (3 + -2)) / (1 * 1 * 1)) - ((3 - -1) - 3) * (7 / 1) / (-4 + -13 -   -1    * 9 + 25 / 5 - -4)
// ((-6 + 8) / (1 * 1)) * ((3 + 162 - 2 + 1
