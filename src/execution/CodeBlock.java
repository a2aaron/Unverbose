package execution;

import java.util.ArrayList;

import expression.Expression;
import helper.Helper;
import types.IType;
import variables.LocalVariable;
import variables.Variable;

public abstract class CodeBlock {

	public CodeBlock() {
	}

	public abstract void execute(ArrayList<Variable<?>> scope);

	@Override
	public abstract String toString();

	public static CodeBlock random(ArrayList<Variable<?>> scope) {
		switch (Helper.randomInt(0, 3)) {
		case 0:
            if (!scope.isEmpty()) {
                Variable<?> variable = (Variable<?>) Helper.getRandomElement(scope.toArray());
                return new Assignment(variable,
                        Expression.random((Class<? extends IType<?>>) variable.getSignature().getType().getClass()));
            }
		case 1:
            if (!scope.isEmpty()) {
                Variable<?> variable = LocalVariable.random();
                return new DeclarationAssignment(variable,
                        Expression.random((Class<? extends IType<?>>) variable.getSignature().getType().getClass()));
            }
		case 2:
			return Declaration.random(IType.randomClass());
		default:
			throw new RuntimeException("Unreachable!");
		}
	}

	public static ArrayList<CodeBlock> randomArrayList() {
		return randomArrayList(Helper.randomInt(1, 10));
	}

	public static ArrayList<CodeBlock> randomArrayList(ArrayList<? extends Variable<?>> importedScope) {
		return randomArrayList(Helper.randomInt(1, 10), importedScope);
	}

	public static ArrayList<CodeBlock> randomArrayList(int size) {
		return randomArrayList(size, new ArrayList<Variable<?>>());
	}

	public static ArrayList<CodeBlock> randomArrayList(int size, ArrayList<? extends Variable<?>> importedScope) {
		ArrayList<CodeBlock> codeBlocks = new ArrayList<CodeBlock>();
		ArrayList<Variable<?>> scope = new ArrayList<Variable<?>>();
		scope.addAll(importedScope);
		for (int i = 0; i < size; i++) {
			CodeBlock random = random(scope);
			random.execute(scope);
			codeBlocks.add(random);
		}
		return codeBlocks;
	}
}
