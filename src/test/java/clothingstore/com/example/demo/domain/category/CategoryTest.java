package clothingstore.com.example.demo.domain.category;

import clothingstore.com.example.demo.repository.CategoryRepository;
import clothingstore.com.example.demo.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryTest extends TestCase {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryService categoryServiceMock;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void successfulSave() throws Exception {
        CategoryInsertDTO newCategory = new CategoryInsertDTO("new category");
        String payload = toJSON(newCategory);

        when(categoryServiceMock.save(any(CategoryInsertDTO.class))).thenReturn(new Category(newCategory.getName()));


    }


    protected String toJSON(Object object) throws JsonProcessingException {
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(object);
    }
}
