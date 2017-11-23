package com.sunrise.common.exception;

public interface SensibleClone<T extends SensibleClone<T>> extends Cloneable {
  public T sensibleClone();
}
