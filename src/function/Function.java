package function;

import java.util.ArrayList;

import execution.CodeBlock;
import execution.Declaration;
import execution.DeclarationAssignment;
import execution.Return;
import execution.flow.FlowControl;
import expression.ExpressionConstant;
import helper.Helper;
import signatures.FunctionSignature;
import types.IFunctionType;
import types.IType;
import types.VoidType;
import variables.LocalVariable;
import variables.Variable;

/**
 * Write a description of class OneLinerFunction here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Function<T extends IFunctionType<?>> {
	FunctionSignature<T> functionSignature;
	ArrayList<LocalVariable<?>> parameters = new ArrayList<LocalVariable<?>>();
	String functionName;

	ArrayList<Variable<?>> importedScope = new ArrayList<Variable<?>>();
	ArrayList<LocalVariable<?>> localScope = new ArrayList<LocalVariable<?>>();
	ArrayList<CodeBlock> codeBlocks = new ArrayList<CodeBlock>();

	public Function(FunctionSignature<T> functionSignature, String functionName, ArrayList<CodeBlock> codeBlocks,
			ArrayList<LocalVariable<?>> parameters) {
		this.functionSignature = functionSignature;
		this.functionName = functionName;
		this.codeBlocks = codeBlocks;
		this.parameters = parameters;
	}

	public Function(FunctionSignature<T> functionSignature, String functionName, CodeBlock codeBlock) {
		this.functionSignature = functionSignature;
		this.functionName = functionName;
		codeBlocks.add(codeBlock);
	}

	public void addScope(ArrayList<Variable<?>> scope) {
		importedScope.addAll(scope);
	}

	public T execute(ArrayList<LocalVariable<?>> parameters) {
		ArrayList<Variable<?>> scope = new ArrayList<Variable<?>>();
		scope.addAll(localScope);
		scope.addAll(importedScope);
		scope.addAll(parameters);
		for (CodeBlock codeBlock : codeBlocks) {
			if (codeBlock instanceof Return) {
				return ((Return<T>) codeBlock).get();
			} else {
				codeBlock.execute(scope);
			}
		}
		if (this.functionSignature.getType() instanceof VoidType) {
			return (T) new Return<VoidType>(new ExpressionConstant<VoidType>(new VoidType()));
		} else {
			throw new RuntimeException("End of function reached but not a void type!");
		}
	}
	
	public ArrayList<CodeBlock> getCodeBlocks() {
		return codeBlocks;
	}

	public String getFunctionName() {
		return functionName;
	}

	public FunctionSignature<T> getFunctionSignature() {
		return functionSignature;
	}

	public ArrayList<LocalVariable<?>> getParameters() {
		return parameters;
	}

	public ArrayList<Variable<?>> getTotalScope() {
		ArrayList<Variable<?>> totalScope = new ArrayList<Variable<?>>();
		totalScope.addAll(parameters);
		totalScope.addAll(importedScope);
		for (CodeBlock codeBlock : codeBlocks) {
			if (codeBlock instanceof Declaration) {
				totalScope.add(((Declaration<?>) codeBlock).getVariable());
			} else if (codeBlock instanceof DeclarationAssignment) {
				totalScope.add(((DeclarationAssignment<?>) codeBlock).getVariable());
			}
		}

		return totalScope;
	}

	@Override
	public String toString() {
	    String string = functionSignature.toString() + " " + functionName + "(";
		for (int i = 0; i < parameters.size(); i++) {
			string += parameters.get(i).toString();
			if (i != parameters.size() - 1) {
				string += ", ";
			}
		}
		string += ") {\n";
		
		int indentLevel = 1;
		for (CodeBlock codeBlock : codeBlocks) {
		    string += toStringCodeBlock(codeBlock, indentLevel);
		}
		string += "}";
		return string;
	}
	
	public String indent(int num) {
	    String string = "";
	    for (int i = 0; i < num; i++) {
	        string += "\t";
	    }
	    return string; 
	}
	
	public String toStringCodeBlock(CodeBlock codeBlock, int indentLevel) {
	    String string = "";
        if (codeBlock instanceof FlowControl) {
            string += indent(indentLevel) + ((FlowControl) codeBlock).headerString();
            indentLevel += 1;
            for (CodeBlock innerCodeBlock : ((FlowControl) codeBlock).getCodeBlocks()) {
                string += toStringCodeBlock(innerCodeBlock, indentLevel);
            }
            indentLevel -= 1;
            string += indent(indentLevel) + "}\n";
        } else {
            string += indent(indentLevel) + codeBlock.toString() + "\n";
        }
        return string;
	}

	public static <T extends IFunctionType<?>> Function<T> random(Class<T> typeClass) {
		FunctionSignature<T> signature = FunctionSignature.randomFunctionSignature(typeClass);
		String functionName = Helper.randomString(10);
		ArrayList<LocalVariable<?>> parameters = randomParameters(Helper.randomInt(0, 4));
		ArrayList<CodeBlock> codeBlocks = CodeBlock.randomArrayList(parameters);
		Function<T> function = new Function<T>(signature, functionName, codeBlocks, parameters);

		if (!(function.getFunctionSignature().getType() instanceof VoidType)) {
			function.getCodeBlocks().add(Return.randomFromScope(function.getTotalScope(), signature.getType().getClass()));
		}
		return function;
	}

	public static ArrayList<LocalVariable<?>> randomParameters(int amount) {
		ArrayList<LocalVariable<?>> parameters = new ArrayList<LocalVariable<?>>();
		for (int i = 0; i < amount; i++) {
			parameters.add(LocalVariable.random(IType.randomClass()));
		}
		return parameters;
	}
}
