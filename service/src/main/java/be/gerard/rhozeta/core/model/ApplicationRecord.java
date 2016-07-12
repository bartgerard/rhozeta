package be.gerard.rhozeta.core.model;

import be.gerard.rhozeta.shared.model.Application;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ApplicationRecord
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Entity
public class ApplicationRecord {

    @Id
    private final Application.Key key;

    public ApplicationRecord(Application.Key key) {
        this.key = key;
    }

    public Application.Key getKey() {
        return key;
    }

}
