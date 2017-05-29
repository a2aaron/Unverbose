package variables;

import helper.Helper;
import signatures.IClassLevelSignature.Final;
import signatures.IClassLevelSignature.Static;
import signatures.IClassLevelSignature.Visibility;
import signatures.Signature;

public class SignatureNoType extends Signature {

	public SignatureNoType(Visibility visibility, Static isStatic, Final isFinal) {
		super(visibility, isStatic, isFinal, null);
	}

	@Override
	public String toString() {
		return getVisibility().getValue() + getIsStatic().getValue() + getIsFinal().getValue();
	}

	public static SignatureNoType random() {
		Visibility visibility = Helper.getRandomElement(Visibility.values());
		Static isStatic = Helper.getRandomElement(Static.values());
		Final isFinal = Helper.getRandomElement(Final.values());
		return new SignatureNoType(visibility, isStatic, isFinal);
	}
}
