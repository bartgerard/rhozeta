package be.gerard.rhozeta.shared.model;

import be.gerard.rhozeta.shared.value.ValueObject;

/**
 * Application
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Application {

    private final Key key;

    public Application(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public static class Key extends ValueObject<String> {

        public Key(String key) {
            super(key);
        }

    }

}
