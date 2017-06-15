package variables;

import java.text.MessageFormat;

import helper.Helper;
import signatures.ClassVariableSignature;
import signatures.ISignature;
import types.IType;
import types.VoidType;
import values.IValue;
import values.NullValue;
import values.UnassignedNullValue;

/**
 * Write a description of class Variable here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Variable<T extends IType> {
    ISignature<T> signature;
	String name;
    NullValue<?> nullValue;
    IValue<T, ?> value;
    
	public Variable(ISignature<T> signature, String name, IValue<T, ?> value) {
	    if (signature.getType() instanceof VoidType) {
	        throw new RuntimeException("cannot make void type variable!");
	    }
		this.signature = signature;
		this.name = name;
		this.value = value;
        if (value == null) {
            nullValue = new NullValue<T>(signature.getType());
        }
	}
	
    public Variable(ISignature<T> signature, String name) {
        this.signature = signature;
        this.name = name;
        this.nullValue = new UnassignedNullValue<T>(signature.getType());
    }

	public final String getCanonicalName() {
		return name;
	}

	public String getName() {
		return name;
	}

	public ISignature<T> getSignature() {
		return signature;
	}

	public void setValue(IValue<T, ?> value) {
		this.value = value;
	}
	
	public IValue<T, ?> getValue() {
	    return value;
	}

    public NullValue<?> getNullValue() {
        return nullValue;
    }

    public void setNullValue(NullValue<?> nullValue) {
        this.nullValue = nullValue;
    }
	
	public String toDebugString() {
		return MessageFormat.format("{0} {1} (= {2})", signature, name, getValue());
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0} {1}", signature, name, getValue());
	}

	public static Variable<? extends IType> random() {
	    ClassVariableSignature<?> signature = ClassVariableSignature.random(IType.random());
		String name = randomName();
		return new Variable(signature, name);
	}

	public static <T extends IType> Variable<T> random(T type) {
	    ClassVariableSignature<T> signature = ClassVariableSignature.random(type);
		String name = randomName();
		return new Variable<T>(signature, name);
	}

	public static String randomName() {
		return Helper.randomString(Helper.randomInt(1, 10));
	}
}
