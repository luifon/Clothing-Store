package clothingstore.com.example.demo.domain.product;

import clothingstore.com.example.demo.domain.category.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product")
    private String name;

    @Column(name = "price_product")
    private BigDecimal price;

    @JoinColumn(name = "category_fk")
    @OneToOne(cascade = CascadeType.MERGE)
    private Category category;

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                name.equals(product.name) &&
                price.equals(product.price) &&
                category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category);
    }
}
