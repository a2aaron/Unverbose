package signatures;

import types.IType;

/**
 * At it's core, a signature is just a type.
 */
public interface ISignature<T extends IType<?>> {
	public T getType();

	public void setType(T type);
}
