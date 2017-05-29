package execution.flow;

import java.util.ArrayList;
import execution.CodeBlock;
import execution.Return;
import expression.IExpression;
import helper.Helper;
import types.BooleanType;
import variables.Variable;

/**
 * Write a description of class Statement here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class FlowControl extends CodeBlock {
	String keyword;
	IExpression<BooleanType> condition;
	ArrayList<CodeBlock> codeBlocks;

	public FlowControl(String keyword, IExpression<BooleanType> condition2, ArrayList<CodeBlock> codeBlocks) {
		this.keyword = keyword;
		this.condition = condition2;
		this.codeBlocks = codeBlocks; 
	}

	@Override
	public abstract void execute(ArrayList<Variable<?>> scope); 
	
	void executeBody(ArrayList<Variable<?>> scope) {
		for (CodeBlock codeBlock : codeBlocks) {
            if (codeBlock instanceof Return) {
                throw new RuntimeException("TODO");
            } else {
                codeBlock.execute(scope);
            }
		}
	}

	@Override
	public String toString() {
		String string = headerString();
		for (CodeBlock codeBlock : codeBlocks) {
            string += "\t" + codeBlock.toString() + "\n";
        }
		string += "}";
		return string;
	}
	
	public String headerString() {
	    return keyword + " (" + condition.toString() + ") {\n";
	}
	
	public ArrayList<CodeBlock> getCodeBlocks() {
	    return codeBlocks;
	}

    public static FlowControl random(ArrayList<Variable<?>> scope) {
        switch (Helper.randomInt(0, 2)) {
        case 0:
            return WhileLoop.random();
        case 1:
            return IfStatement.random(scope);
        }
        return null;
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
