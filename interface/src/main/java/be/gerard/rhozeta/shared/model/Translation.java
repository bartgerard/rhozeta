package be.gerard.rhozeta.shared.model;

import be.gerard.rhozeta.shared.value.ValueObject;
import org.springframework.hateoas.ResourceSupport;

/**
 * Translation
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Translation extends ResourceSupport {

    private final Application.Key appKey;

    private final Translation.Type type;

    private final Translation.Key key;

    private final Translation.Value value;

    public Translation(Application.Key appKey, Type type, Key key, Value value) {
        this.appKey = appKey;
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public Application.Key getAppKey() {
        return appKey;
    }

    public Translation.Type getType() {
        return type;
    }

    public Translation.Key getKey() {
        return key;
    }

    public Translation.Value getValue() {
        return value;
    }

    public static class Key extends ValueObject<String> {

        public Key(String value) {
            super(value);
        }

        public static Key of(String value) {
            return new Key(value);
        }

    }

    public enum Type {
        ACTION,
        FIELD,
        TITLE,
        ERROR
    }

    public static class Value extends ValueObject<String> {

        public Value(String value) {
            super(value);
        }

        public static Value of(String value) {
            return new Value(value);
        }

    }

}
