package be.gerard.rhozeta.core.service;

import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * ApplicationServiceImpl
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public Application findOne(Application.Key key) {
        return new Application(key);
    }

    @Override
    public List<Application> findAll() {
        return Collections.singletonList(findOne(Application.Key.of("a")));//new ArrayList<>();
    }

}
