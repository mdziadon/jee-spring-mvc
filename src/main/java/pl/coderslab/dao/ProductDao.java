package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Product;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDao {

    public List<Product> getList() {
        return Arrays.asList(
                new Product(1L, "Product1", 100),
                new Product(2L, "Product2", 200),
                new Product(3L, "Product3", 300),
                new Product(4L, "Product4", 400),
                new Product(5L, "Product5", 500)
        );
    }

    public Product getProduct(Long id) {
        return getList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(null);
    }

}
