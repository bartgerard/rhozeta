package be.gerard.rhozeta.core;

import be.gerard.rhozeta.core.linker.ApplicationLinker;
import be.gerard.rhozeta.shared.model.Application;
import be.gerard.rhozeta.shared.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApplicationRestController
 *
 * HATEOAS specs
 * http://stateless.co/hal_specification.html
 * https://tools.ietf.org/html/draft-kelly-json-hal-08
 *
 * @author bartgerard
 * @version v0.0.1
 */
@RestController
@RequestMapping("/rest/applications")
public class ApplicationRestController {

    @Autowired
    private ApplicationLinker applicationLinker;

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public ResponseEntity<Resource<Application>> findOne(@PathVariable("key") Application.Key key) {
        return applicationLinker.toResponse(applicationService.findOne(key), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Resources<Resource<Application>>> findAll() {
        return applicationLinker.toResponse(applicationService.findAll(), HttpStatus.OK);
    }

}
