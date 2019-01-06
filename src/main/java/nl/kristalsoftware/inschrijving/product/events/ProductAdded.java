package nl.kristalsoftware.inschrijving.product.events;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import nl.kristalsoftware.inschrijving.product.Product;
import nl.kristalsoftware.inschrijving.product.events.AbstractEvent;
import nl.kristalsoftware.inschrijving.product.events.AggregateReference;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor(staticName = "of")
@EqualsAndHashCode(callSuper = true)
@Entity
public class ProductAdded extends AbstractEvent<Product> {

    @ManyToOne
    @AggregateReference
    Product product;
}
