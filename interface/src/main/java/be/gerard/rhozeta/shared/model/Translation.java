package be.gerard.rhozeta.shared.model;

import be.gerard.rhozeta.shared.value.AppName;

/**
 * Translation
 *
 * @author bartgerard
 * @version v0.0.1
 */
public class Translation {

    private final AppName appName;

    private final TranslationType type;

    public Translation(AppName appName, TranslationType type) {
        this.appName = appName;
        this.type = type;
    }

}
