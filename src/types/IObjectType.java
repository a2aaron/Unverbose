package types;

/**
 * Write a description of interface IObjectType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IObjectType<T extends Object> extends IType<T> {
	public enum ObjectTypes {
		STRING, OBJECT, SCANNER, FILE;
	}
}
