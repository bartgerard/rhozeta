package be.gerard.rhozeta.shared.value;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value
 *
 * @author bartgerard
 * @version v0.0.1
 */
public abstract class ValueObject<T extends Serializable> implements Serializable {

    private final T value;

    public ValueObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ValueObject<?> that = (ValueObject<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return Objects.toString(value);
    }

}
