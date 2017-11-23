package com.fuck.mobile.loader;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class CompoundEnumeration<E> implements Enumeration<E> {
	private Enumeration<E>[] enums;
	private int index = 0;

	public CompoundEnumeration(Enumeration<E>[] paramArrayOfEnumeration) {
		enums = paramArrayOfEnumeration;
	}

	private boolean next() {
		while (index < enums.length) {
			if ((enums[index] != null) && (enums[index].hasMoreElements())) {
				return true;
			}
			index += 1;
		}
		return false;
	}

	public boolean hasMoreElements() {
		return next();
	}

	public E nextElement() {
		if (!next()) {
			throw new NoSuchElementException();
		}
		return (E) enums[index].nextElement();
	}
}