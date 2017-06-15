package types;

import helper.Helper;

/**
 * Write a description of class PrimativeType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObjectType extends Type implements IObjectType, IFunctionType {
	public ObjectType(String type) {
		super(Helper.capitalize(type));
	}

	public static ObjectType random() {
		return new ObjectType(Helper.getRandomElement(ObjectTypes.values()).toString());
	}
}
