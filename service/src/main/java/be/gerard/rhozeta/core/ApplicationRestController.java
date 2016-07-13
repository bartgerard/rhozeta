package be.gerard.rhozeta.core;

import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * ApplicationRestController
 * <p>
 * HATEOAS specs
 * http://stateless.co/hal_specification.html
 * https://tools.ietf.org/html/draft-kelly-json-hal-08
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RestController
@RequestMapping("/applications")
public class ApplicationRestController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Application>> findOne(@PathVariable("key") Application.Key key) {
        return applicationService.findOne(key)
                .map(this::toResource)
                .map(ResponseEntity::ok)
                .orElseThrow(IllegalArgumentException::new);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Resources<Resource<Application>>> findAll() {
        List<Link> links = new LinkedList<>();

        links.add(linkTo(methodOn(getClass()).findAll()).withSelfRel());

        List<Resource<Application>> applications = applicationService.findAll().stream()
                .map(this::toResource)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new Resources<>(applications, links));
    }

    private Resource<Application> toResource(final Application application) {
        List<Link> links = new LinkedList<>();

        links.add(linkTo(methodOn(getClass()).findOne(application.getKey())).withSelfRel());

        return new Resource<>(application, links);
    }

}
