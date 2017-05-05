package own.jadezhang.base.common.domain;

import java.io.Serializable;
import java.math.BigInteger;

public class BaseDomain<T> implements Serializable {
	protected static final long serialVersionUID = 6667600871541308622L;
	// ID
	private T id;

	public T getId() {
		if (id instanceof BigInteger)
			return (T) Long.valueOf(String.valueOf(this.id));
		else
			return this.id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
