package clothingstore.com.example.demo.service;

import clothingstore.com.example.demo.domain.Category;
import clothingstore.com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Category insert(String name) {
        return repository.save(new Category(name));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }
}
