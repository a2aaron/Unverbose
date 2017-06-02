package signatures;

import types.IType;

public interface IClassLevelSignature extends ISignature {
	public enum Final {
		FINAL("final "), NONE("");

		public String value;

		private Final(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	};

	public enum Static {
		STATIC("static "), NONE("");

		public String value;

		private Static(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum Visibility {
		PUBLIC("public "), PRIVATE("private "), PROTECTED("protected "), NONE("");

		public String value;

		private Visibility(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public Final getFinal();

	public Static getStatic();

	public Visibility getVisibility();
}
