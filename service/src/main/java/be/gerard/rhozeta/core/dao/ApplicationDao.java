package be.gerard.rhozeta.core.dao;

import be.gerard.rhozeta.core.model.ApplicationRecord;
import be.gerard.rhozeta.shared.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ApplicationDao
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface ApplicationDao extends JpaRepository<ApplicationRecord, Application.Key> {
}
