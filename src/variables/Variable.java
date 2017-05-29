package variables;

import java.text.MessageFormat;

import helper.Helper;
import signatures.ISignature;
import signatures.Signature;
import types.IType;

/**
 * Write a description of class Variable here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Variable<T extends IType<?>> {
	ISignature<T> signature;
	String name;

	public Variable(ISignature<T> signature, String name) {
		this.signature = signature;
		this.name = name;
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

	public void set(T type) {
		signature.setType(type);
	}

	public String toDebugString() {
		return MessageFormat.format("{0} {1} (= {2})", signature, name, signature.getType().getValue());
	}

	@Override
	public String toString() {
		return MessageFormat.format("{0} {1}", signature, name, signature.getType().getValue());
	}

	public static Variable<?> random() {
		Signature<?> signature = Signature.random(IType.randomClass());
		String name = randomName();
		return new Variable(signature, name);
	}

	public static <T extends IType<?>> Variable<T> random(Class<T> typeClass) {
		Signature<T> signature = Signature.random(typeClass);
		String name = randomName();
		return new Variable<T>(signature, name);
	}

	public static String randomName() {
		return Helper.randomString(Helper.randomInt(1, 10));
	}
}
