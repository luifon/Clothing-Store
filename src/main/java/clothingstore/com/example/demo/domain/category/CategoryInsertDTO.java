package clothingstore.com.example.demo.domain.category;

import lombok.Getter;

@Getter
public class CategoryInsertDTO {
    String name;

    public CategoryInsertDTO() {
    }

    public CategoryInsertDTO(String name) {
        this.name = name;
    }
}
