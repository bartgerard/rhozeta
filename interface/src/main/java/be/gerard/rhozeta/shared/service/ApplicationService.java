package be.gerard.rhozeta.shared.service;

import be.gerard.rhozeta.shared.model.Application;

import java.util.List;

/**
 * ApplicationService
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface ApplicationService {

    Application findOne(Application.Key key);

    List<Application> findAll();

}
