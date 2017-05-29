package types;

/**
 * Write a description of class VoidType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class VoidType extends Type<Void> implements IFunctionType<Void> {
	public VoidType() {
		super("void", null);
	}

	@Override
	public Void getValue() {
		throw new RuntimeException("Cannot get value of Void!");
	}
}