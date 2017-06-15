package signatures;

import helper.Helper;
import signatures.IClassLevelSignature.Final;
import signatures.IClassLevelSignature.Static;
import signatures.IClassLevelSignature.Visibility;
import types.IType;

/**
 * Write a description of class FunctionSignature here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunctionSignature<T extends IType> implements ISignature<T> {
    T type;
    Visibility visibility;
    Static isStatic;
    Final isFinal;
    
	public FunctionSignature(Visibility visibility, Static isStatic, Final isFinal, T type) {
        this.type = type;
        this.visibility = visibility;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
    }
	
	public FunctionSignature(Visibility visibility, T type) {
		this(visibility, Static.NONE, Final.NONE, type);
	}
	
	public T getType() {
        return type;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public Static getStatic() {
        return isStatic;
    }

    public Final getFinal() {
        return isFinal;
    }

    // TODO: figure out how to type parametize this without name clashes
    public static <T extends IType> FunctionSignature<T> random(T type) {
        Visibility visibility = Helper.getRandomElement(Visibility.values());
        Static isStatic = Helper.getRandomElement(Static.values());
        Final isFinal = Helper.getRandomElement(Final.values());
        return new FunctionSignature<T>(visibility, isStatic, isFinal, type);
    }
    
    // TODO: figure out how to type parametize this without name clashes
	public static FunctionSignature<? extends IType> random() {
		return random(IType.random());
	}
	
	   @Override
	    public String toString() {
	        return visibility.getValue() + isStatic.getValue() + isFinal.getValue() + type.getName();
	    }
}
