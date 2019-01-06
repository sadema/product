package nl.kristalsoftware.inschrijving.product.events;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RequiredArgsConstructor
@RestController
public class EventsController {

    private final EventRepository events;
    private final ControllerLinkBuilderFactory linkBuilderFactory;

    @GetMapping(path = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Resources<?>> getEvents(PagedResourcesAssembler<AbstractEvent<?>> assembler,
                                              Pageable pageable) {

        Page<AbstractEvent<?>> eventList = events.findAll(pageable);

        PagedResources<Resource<AbstractEvent<?>>> resource = assembler.toResource(eventList, event -> toResource(event));

        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = "/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<AbstractEvent<?>>> getEvent(@PathVariable UUID id) {
        return events.findById(id)
                .map(this::toResource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private Resource<AbstractEvent<?>> toResource(AbstractEvent<?> event) {
        Resource<AbstractEvent<?>> resource = new Resource<>(event);
        resource.add(linkBuilderFactory.linkTo(methodOn(EventsController.class).getEvent(event.getId())).withSelfRel());
        return resource;
    }
}
