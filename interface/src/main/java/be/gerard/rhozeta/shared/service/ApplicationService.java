package be.gerard.rhozeta.shared.service;

import be.gerard.rhozeta.shared.model.Application;

import java.util.List;
import java.util.Optional;

/**
 * ApplicationService
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface ApplicationService {

    Optional<Application> findOne(Application.Key key);

    List<Application> findAll();

}
