package be.gerard.rhozeta.shared.model;

import be.gerard.rhozeta.shared.value.ValueObject;

/**
 * Application
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Application {

    private Key key;

    public Application() {
    }

    public Application(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public static class Key extends ValueObject<String> {

        public Key(String value) {
            super(value);
        }

        public static Key of(String value) {
            return new Key(value);
        }

    }

}
