package nl.kristalsoftware.inschrijving.product.events;


import lombok.Getter;
import org.springframework.core.ResolvableType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class AbstractEvent<T> implements Event {

    @Id
    private final UUID id = UUID.randomUUID();
    private final LocalDateTime publicationDate = LocalDateTime.now();
    private final Class<?> aggregateType;

    protected AbstractEvent() {
        this.aggregateType = ResolvableType.forClass(
                AbstractEvent.class, this.getClass())
                .resolveGeneric(0);
    }

}
