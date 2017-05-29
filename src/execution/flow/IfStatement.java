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
public class IfStatement extends FlowControl {
	public IfStatement(Expression<BooleanType> condition, ArrayList<CodeBlock> codeBlock) {
		super("if", condition, codeBlock);
	}

	public static IfStatement random() {
		return new IfStatement(BooleanHelper.random(), CodeBlock.randomArrayList());
	}
}
