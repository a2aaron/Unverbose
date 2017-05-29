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
        ArrayList<Variable<?>> tempScope = (ArrayList<Variable<?>>) scope.clone();
        while (condition.evaluate().getType().getValue()) {
            execute(tempScope);
        }
    }
    
    
    public static WhileLoop random() {
        return new WhileLoop(BooleanHelper.random(), CodeBlock.randomArrayList());
    }
}
