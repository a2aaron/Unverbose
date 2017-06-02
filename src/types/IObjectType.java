package types;

/**
 * Write a description of interface IObjectType here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IObjectType extends IType {
	public enum ObjectTypes {
		STRING, OBJECT, SCANNER, FILE;
	}
}
