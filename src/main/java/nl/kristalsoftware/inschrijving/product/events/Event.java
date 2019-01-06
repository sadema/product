package nl.kristalsoftware.inschrijving.product.events;

import java.time.LocalDateTime;

public interface Event {

    LocalDateTime getPublicationDate();
    Class<?> getAggregateType();

}
