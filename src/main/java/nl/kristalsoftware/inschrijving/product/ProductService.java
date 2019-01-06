package nl.kristalsoftware.inschrijving.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(String description, BigDecimal price) {
        Product product = Product.of(description, price);
        productRepository.save(product);
    }
    
}
