package clothingstore.com.example.demo.domain.category;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @Column(name = "id_product_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_product_type")
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category publisher = (Category) o;
        return Objects.equals(id, publisher.id) &&
                Objects.equals(name, publisher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
