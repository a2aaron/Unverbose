package execution.flow;

import java.util.ArrayList;

import execution.CodeBlock;
import expression.Expression;
import helper.Helper;
import types.BooleanType;
import variables.Variable;

/**
 * Write a description of class Statement here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlowControl extends CodeBlock {
	String keyword;
	Expression<BooleanType> condition;
	ArrayList<CodeBlock> codeBlock;

	public FlowControl(String keyword, Expression<BooleanType> condition2, ArrayList<CodeBlock> codeBlock) {
		this.keyword = keyword;
		this.condition = condition2;
		this.codeBlock = codeBlock;
	}

	@Override
	public void execute(ArrayList<Variable<?>> scope) {
		throw new RuntimeException("TODO");
	}

	@Override
	public String toString() {
		return keyword + " (" + condition + ") {\n" + "\t" + codeBlock + "\n" + "}";
	}

	public static FlowControl random() {
		switch (Helper.randomInt(0, 2)) {
		case 0:
			return WhileLoop.random();
		case 1:
			return IfStatement.random();
		}
		return null;
	}
}
