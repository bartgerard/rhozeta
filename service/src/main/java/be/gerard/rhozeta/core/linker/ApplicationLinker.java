package be.gerard.rhozeta.core.linker;

import be.gerard.rhozeta.core.ApplicationRestController;
import be.gerard.rhozeta.shared.model.Application;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * ApplicationLinker
 *
 * @author bartgerard
 * @version v0.0.1
 */
@Component
public class ApplicationLinker implements Linker<Application> {

    @Override
    public Link toSelf(final Application item) {
        return linkTo(methodOn(ApplicationRestController.class).findOne(item.getKey())).withSelfRel();
    }

    @Override
    public Link toSelf(final Collection<Application> items) {
        return linkTo(methodOn(ApplicationRestController.class).findAll()).withSelfRel();
    }

    @Override
    public ResponseEntity.BodyBuilder addHeaders(ResponseEntity.BodyBuilder builder, Application item) {
        return builder.allow(HttpMethod.GET);
    }

    @Override
    public ResponseEntity.BodyBuilder addHeaders(ResponseEntity.BodyBuilder builder, Collection<Application> items) {
        return builder.allow(HttpMethod.GET);
    }

}
