package be.gerard.rhozeta.core.linker;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Linker
 *
 * @author bartgerard
 * @version v0.0.1
 */
public interface Linker<T> {

    default ResponseEntity<Resource<T>> toResponse(final T item, HttpStatus statusCode) {
        return addHeaders(ResponseEntity.status(statusCode), item).body(toResource(item));
    }

    default ResponseEntity<Resources<Resource<T>>> toResponse(final Collection<T> items, HttpStatus statusCode) {
        return addHeaders(ResponseEntity.status(statusCode), items).body(toResources(items));
    }

    default ResponseEntity.BodyBuilder addHeaders(final ResponseEntity.BodyBuilder builder, final T item) {
        return builder;
    }

    default ResponseEntity.BodyBuilder addHeaders(final ResponseEntity.BodyBuilder builder, final Collection<T> items) {
        return builder;
    }

    default Resource<T> toResource(final T item) {
        return new Resource<>(item, toLinks(item));
    }

    default Resources<Resource<T>> toResources(final Collection<T> items) {
        return new Resources<>(items.stream().map(this::toResource).collect(Collectors.toList()), toLinks(items));
    }

    default List<Link> toLinks(final T item) {
        return toLinks(new LinkedList<>(), item);
    }

    default List<Link> toLinks(final Collection<T> items) {
        return toLinks(new LinkedList<>(), items);
    }

    default List<Link> toLinks(final List<Link> links, final T item) {
        links.add(toSelf(item));
        return links;
    }

    default List<Link> toLinks(final List<Link> links, final Collection<T> items) {
        links.add(toSelf(items));
        return links;
    }

    Link toSelf(final T item);

    Link toSelf(final Collection<T> items);

}
