package nl.kristalsoftware.inschrijving.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.kristalsoftware.inschrijving.product.events.PriceChanged;
import nl.kristalsoftware.inschrijving.product.events.ProductAdded;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String description;

    private BigDecimal price;

    public static Product of(String description, BigDecimal price) {
        Product product = new Product(null, description, price);
        product.registerEvent(ProductAdded.of(product));
        return product;
    }

    public Product changePrice(BigDecimal newPrice) {
        Product product = new Product(id, description, newPrice);
        product.registerEvent(PriceChanged.of(id, price, newPrice));
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
