package nl.kristalsoftware.inschrijving.product.events;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import nl.kristalsoftware.inschrijving.product.Product;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Value
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class PriceChanged extends AbstractEvent<Product> {

    Long productId;
    BigDecimal oldPrice;
    BigDecimal newPrice;

}
