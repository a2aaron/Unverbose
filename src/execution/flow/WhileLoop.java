package execution.flow;

import java.util.ArrayList;

import execution.CodeBlock;
import expression.Expression;
import expression.bool.BooleanHelper;
import types.BooleanType;

/**
 * Write a description of class IfStatement here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WhileLoop extends FlowControl {
	public WhileLoop(Expression<BooleanType> condition, ArrayList<CodeBlock> codeBlock) {
		super("while", condition, codeBlock);
	}

	public static WhileLoop random() {
		return new WhileLoop(BooleanHelper.random(), CodeBlock.randomArrayList());
	}
}
