package clothingstore.com.example.demo.controller;

import clothingstore.com.example.demo.domain.product.Product;
import clothingstore.com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
