package be.gerard.rhozeta.core.service;

import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * ApplicationServiceImpl
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final List<Application> applications = new ArrayList<>();

    @PostConstruct
    private void init() {
        applications.add(new Application(Application.Key.of("rhozeta")));
        applications.add(new Application(Application.Key.of("delta")));
    }

    @Override
    public Optional<Application> findOne(Application.Key key) {
        return applications.stream()
                .filter(user -> Objects.equals(key, user.getKey()))
                .findFirst();
    }

    @Override
    public List<Application> findAll() {
        return applications;
    }

    @Override
    public Application create(Application application) {
        applications.add(application);
        return application;
    }

    @Override
    public Application update(Application application, Application.Key key) {
        findOne(key).map(Function.identity())
                .orElseThrow(IllegalArgumentException::new);

        return application;
    }

}
