package types;

import helper.Helper;
import values.NullValue;

/**
 * Write a description of class PrimativeType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObjectType<T extends Object> extends Type<T> implements IObjectType<T>, IFunctionType<T> {
	public ObjectType(String type, T value) {
		super(Helper.capitalize(type), value);
	}

	public static ObjectType<?> random() {
		return new ObjectType<Object>(Helper.getRandomElement(ObjectTypes.values()).toString(), new NullValue());
	}

	public static Class<? extends IFunctionType<?>> randomClass() {
		throw new RuntimeException("TODO");
	}
}
