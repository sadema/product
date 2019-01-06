package nl.kristalsoftware.inschrijving.product.events;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(exported = false)
public interface EventRepository extends Repository<AbstractEvent<?>, Long> {

    <T extends AbstractEvent<?>> T save(T event);

    Page<AbstractEvent<?>> findAll(Pageable pageable);

    Optional<AbstractEvent<?>> findById(UUID id);

}
