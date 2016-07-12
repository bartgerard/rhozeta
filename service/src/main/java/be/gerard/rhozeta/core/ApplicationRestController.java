package be.gerard.rhozeta.core;

import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * ApplicationRestController
 *
 * http://stateless.co/hal_specification.html
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RestController
@RequestMapping("/rest/applications")
public class ApplicationRestController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Application>> findOne(@PathVariable("key") Application.Key key) {
        return new ResponseEntity<>(toResource(applicationService.findOne(key)), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Resources<Resource<Application>>> findAll() {
        return new ResponseEntity<>(toResources(applicationService.findAll()), HttpStatus.OK);
    }

    private Resources<Resource<Application>> toResources(Collection<Application> items) {
        List<Link> links = new LinkedList<>();
        links.add(linkTo(methodOn(ApplicationRestController.class).findAll()).withSelfRel());
        return new Resources<>(items.stream().map(this::toResource).collect(Collectors.toList()), links);
    }

    private Resource<Application> toResource(Application item) {
        Link link = linkTo(methodOn(ApplicationRestController.class).findOne(item.getKey())).withSelfRel();
        return new Resource<>(item, link);
    }

}
