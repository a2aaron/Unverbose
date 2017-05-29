package highlevel;

import java.util.ArrayList;

import function.Function;
import variables.InstanceVariable;
import variables.Variable;

public class ClassOutline {
	ArrayList<InstanceVariable<?>> instanceVariables;
	ArrayList<Function<?>> functions;
	ArrayList<Variable<?>> importedScope = new ArrayList<Variable<?>>();

	String name;

	public ClassOutline(ArrayList<InstanceVariable<?>> instanceVariables, ArrayList<Function<?>> functions,
			ArrayList<Variable<?>> importedScope, String name) {
		super();
		this.instanceVariables = instanceVariables;
		this.functions = functions;
		this.importedScope.addAll(importedScope);
		this.name = name;

		for (Function<?> function : functions) {
			function.addScope(importedScope);
		}
	}

	public ArrayList<Function<?>> getFunctions() {
		return functions;
	}

	public ArrayList<Variable<?>> getImportedScope() {
		return importedScope;
	}

	public ArrayList<InstanceVariable<?>> getInstanceVariables() {
		return instanceVariables;
	}

	public String getName() {
		return name;
	}
}
