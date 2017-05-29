
import java.util.ArrayList;

import execution.CodeBlock;
import execution.DeclarationAssignment;
import expression.IExpression;
import expression.bool.BooleanConstant;
import function.Function;
import function.Getter;
import function.Setter;
import types.BooleanType;
import types.IFunctionType;
import types.IType;
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
		ArrayList<Variable<?>> scope2 = new ArrayList<Variable<?>>();
		for (int i = 0; i < 100; i++) {
//			Class<? extends IType<?>> typeClass = IType.randomClass();
//			System.out.println(DeclarationAssignment.random(typeClass));
//			System.out.println(Variable.random(typeClass));
//			System.out.println(Getter.random(IFunctionType.randomNonVoidClass()));
//			System.out.println(Setter.random());
//			booleanTrue = booleanTrue.complicate();
//			System.out.println(booleanTrue);
//			CodeBlock random = CodeBlock.random(scope2);
//			random.execute(scope2);
			System.out.println(Function.random(IFunctionType.randomClass()));
		}
		System.out.println("E");
	}
}