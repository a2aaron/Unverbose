package execution.flow;

import java.util.ArrayList;

import execution.CodeBlock;
import expression.IExpression;
import expression.bool.BooleanHelper;
import types.BooleanType;
import variables.Variable;

/**
 * Write a description of class IfStatement here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class IfStatement extends FlowControl {
	public IfStatement(IExpression<BooleanType> condition, ArrayList<CodeBlock> codeBlock) {
		super("if", condition, codeBlock);
	}

	public static IfStatement random() {
		return new IfStatement(BooleanHelper.random(), CodeBlock.randomArrayList(3));
	}
	
	public static IfStatement random(ArrayList<Variable<?>> scope) {
	    return new IfStatement(BooleanHelper.random(), CodeBlock.randomArrayList(3, scope));
	}

    @Override
    public void execute(ArrayList<Variable<?>> scope) {
        ArrayList<Variable<?>> tempScope = (ArrayList<Variable<?>>) scope.clone();
        if (condition.evaluate().getType().getValue()) {
            executeBody(tempScope);
        } else {
            return;
        }
    }
}

