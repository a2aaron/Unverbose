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
public class WhileLoop extends FlowControl {
    public WhileLoop(IExpression<BooleanType> condition, ArrayList<CodeBlock> codeBlock) {
        super("while", condition, codeBlock);
    }
    
    public void execute(ArrayList<Variable<?>> scope) {
        @SuppressWarnings("unchecked")
        // must be type safe because scope is a ArrayList<Variable<?>> so .clone() should so be a ArrayList<Variable<?>> 
        ArrayList<Variable<?>> tempScope = (ArrayList<Variable<?>>) scope.clone();
        while ((boolean) condition.evaluate().getValue().getValue()) {
            execute(tempScope);
        }
    }
    
    
    public static WhileLoop random() {
        return new WhileLoop(BooleanHelper.random(), CodeBlock.randomArrayList());
    }
}
