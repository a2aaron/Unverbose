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
        @SuppressWarnings("unchecked")
        // must be type safe because scope is a ArrayList<Variable<?>> so .clone() should so be a ArrayList<Variable<?>>
        ArrayList<Variable<?>> tempScope = (ArrayList<Variable<?>>) scope.clone();
        if ((boolean) condition.evaluate().getValue().getValue()) {
            executeBody(tempScope);
        } else {
            return;
        }
    }
}

