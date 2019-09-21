package clothingstore.com.example.demo.controller;

import clothingstore.com.example.demo.domain.category.Category;
import clothingstore.com.example.demo.domain.category.CategoryInsertDTO;
import clothingstore.com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public Category insert(@RequestBody CategoryInsertDTO category) {
        return service.insert(category);
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
