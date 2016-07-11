package be.gerard.rhozeta.shared.value;

/**
 * Value
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class ValueObject<T> {

    private final T value;

    public ValueObject(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
